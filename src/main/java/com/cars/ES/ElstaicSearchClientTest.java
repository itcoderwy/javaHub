package com.cars.ES;

import com.cars.domian.Article;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;

import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.Before;
import org.junit.Test;

import java.net.InetAddress;

import java.util.Iterator;
import java.util.Map;

/**
 * @Description es服务器端测试
 * @Author Wy005
 * @Date 2020/7/30 9:56
 * @Version 1.0
 **/
@Slf4j
public class ElstaicSearchClientTest {

    private TransportClient client;

    //提取方法
    @Before
    public void init() throws Exception{
        //1,创建一个settings  主要配置es集群信息 k:集群名称  value:集群名称
        Settings esSettings = Settings.builder().put("cluster.name", "my_esLearn").build();
        //2,创建客户端Client对象
        client = new PreBuiltTransportClient(esSettings);
        //为了报证集群宕机可以 最后设置三个节点  这里测试暂时用一个
        client.addTransportAddress(new TransportAddress(InetAddress.getByName("localhost"),9300));
    }


    @Test
    public void creatIndex() throws Exception {
        log.info("开始创建es索引");
        try {
            //1,创建一个settings  主要配置es集群信息 k:集群名称  value:集群名称
            Settings esSettings = Settings.builder().put("cluster.name", "my_esLearn").build();
            //2,创建客户端Client对象
            TransportClient client = new PreBuiltTransportClient(esSettings);
            //为了报证集群宕机可以 最后设置三个节点  这里测试暂时用一个
            client.addTransportAddress(new TransportAddress(InetAddress.getByName("localhost"),9300));
            //3使用client对象创建索引库
            client.admin().indices().prepareCreate("index_hello")
                    //这个get是执行操作  之前步骤都是在设置
                    .get();
            //4,关闭client对象
            client.close();
        } catch (Exception e) {
            log.error(e.getMessage());
            //e.printStackTrace();
        }
    }


    @Test
    public void setMappering() throws Exception {
        log.info("开始创建mappering");
        try {
            //1,设置settings
            Settings esSetting = Settings.builder().put("cluster.name", "my_esLearn")
                    .build();
            //2,获取client
            TransportClient client = new PreBuiltTransportClient(esSetting);
            //3,设置es集群地址
            client.addTransportAddress(new TransportAddress(InetAddress.getByName("localhost"),9300));
            //4,设置mappering 其实是一个json格式 现在用es自带得类创建
            XContentBuilder builder = new XContentFactory().jsonBuilder()
                    .startObject()
                       .startObject("article")
                           .startObject("properties")
                               .startObject("id")
                                   .field("type","long")
                                   .field("store",true)
                               .endObject()
                                .startObject("title")
                                    .field("type","text")
                                    .field("store",true)
                                    .field("analyzer","ik_smart")
                                .endObject()
                                .startObject("content")
                                    .field("type","text")
                                    .field("store",true)
                                    .field("analyzer","ik_smart")
                                .endObject()
                             .endObject()
                          .endObject()
                    .endObject();

            //5,使用client客户端将mappering信息设置到索引库当中
            client.admin().indices().preparePutMapping("index_hello")//设置要做映射得索引
                    //设置要做映射得type
                    .setType("article")
                    //设置要做映射得文档信息
                    .setSource(builder)
                    .get();
            client.close();
            log.info("创建mappering映射成功!");
        } catch (Exception e) {
            log.error(e.getMessage());
           // e.printStackTrace();
        }
    }

    //向es索引库中添加文档
    @Test
    public void addDocument() throws Exception{
        XContentBuilder xContentBuilder = new XContentFactory().jsonBuilder()
                .startObject()
                   .field("id",2)
                   .field("title","2你好es!")
                   .field("content","2向es索引中添加文档")
                .endObject();
        client.prepareIndex("index_hello","article","2")
                .setSource(xContentBuilder)
                .get();
        client.close();
    }

    //删除es索引库中得文档
    @Test
    public void del(){
        client.prepareDelete("index_hello","article","article.getId()").get();
        client.close();
    }

    //用java对象得方式添加数据到es索引库
    @Test
    public void setDoc() throws Exception {
        //1,先创建java对象 并赋值
        Article article = new Article();
        article.setId(3);
        article.setTitle("很短，自己看看，爱信不信");
        article.setContent("好好干好手头的事情，不要意气用事，好好做好交接工作");
        //2,将对象中得值用jackson转换成json
        ObjectMapper mapper = new ObjectMapper();
        String articleJson = mapper.writeValueAsString(article);

        client.prepareIndex("index_hello","article","3")
                .setSource(articleJson, XContentType.JSON)
                .get();
        client.close();

    }

    @Test
    public void edit() throws Exception{
        //1,先创建java对象 并赋值
        Article article = new Article();
        article.setId(3);
        article.setTitle("3很短，自己看看，爱信不信");
        article.setContent("3好好干好手头的事情，不要意气用事，好好做好交接工作");
        //2,将对象中得值用jackson转换成json
        ObjectMapper mapper = new ObjectMapper();
        String articleJson = mapper.writeValueAsString(article);

        client.prepareIndex("index_hello","article","3")
                .setSource(articleJson, XContentType.JSON)
                .get();
        client.close();
    }

    //根据id查询
    @Test
    public void getDocById() throws Exception{
        QueryBuilder queryBuilder = QueryBuilders.idsQuery().addIds("1","3");
        this.search(queryBuilder);
        /*SearchResponse searchResponse = client.prepareSearch("index_hello").setTypes("article").setQuery(queryBuilder).get();
        SearchHits searchHits = searchResponse.getHits();
        System.out.println("查询结果得总记录数:"+searchHits.getTotalHits());
        Iterator<SearchHit> iterator =  searchHits.iterator();
        while (iterator.hasNext()){
            SearchHit searchHit = iterator.next();
            Map<String, Object> source = searchHit.getSourceAsMap();
            System.out.println(source.get("id"));
            System.out.println(source.get("title"));
            System.out.println(source.get("content"));
        }
     client.close();*/
    }

    //抽取查询方法
    private void search(QueryBuilder queryBuilder)throws Exception{
        SearchResponse searchResponse = client.prepareSearch("index_hello")
                .setTypes("article")
                .setQuery(queryBuilder)
                //设置分页信息开始点
                .setFrom(0)
                //设置每页条数
                .setSize(3)
                .get();
        SearchHits searchHits = searchResponse.getHits();
        System.out.println("查询结果得总记录数:"+searchHits.getTotalHits());
        Iterator<SearchHit> iterator =  searchHits.iterator();
        while (iterator.hasNext()){
            SearchHit searchHit = iterator.next();
            Map<String, Object> source = searchHit.getSourceAsMap();
            System.out.println(source.get("id"));
            System.out.println(source.get("title"));
            System.out.println(source.get("content"));
        }
        client.close();
    }

    //根据term查询
    @Test
    public void searchByTerm() throws Exception{
        //参数1:要搜索得字段   参数2:要搜索得关键词
      QueryBuilder queryBuilder = QueryBuilders.termQuery("title", "你好");
      this.search(queryBuilder);
    }

    @Test
    public void queryString() throws Exception{
        //是对搜索得语句先分词再去查询
        //defaultField("title")意思是可以指定搜索域(字段)
        QueryBuilder queryBuilder = QueryBuilders.queryStringQuery("交接工作").defaultField("content");
        this.search(queryBuilder);
    }

    //批量添加数据
    @Test
    public void addDoc1()throws Exception{
        for (int i = 1; i < 101 ; i++) {
            //1,先创建java对象 并赋值
            Article article = new Article();
            article.setId(i);
            article.setTitle(i+"很短，自己看看，爱信不信");
            article.setContent(i+"好好干好手头的事情，不要意气用事，好好做好交接工作");
            //2,将对象中得值用jackson转换成json
            ObjectMapper mapper = new ObjectMapper();
            String articleJson = mapper.writeValueAsString(article);

            client.prepareIndex()
                    .setIndex("index_hello")
                    .setType("article")
                    .setId(i+"")
                    .setSource(articleJson, XContentType.JSON)
                    .get();
        }
        client.close();
    }



}
