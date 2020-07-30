package com.cars.ES;

import com.cars.domian.Article;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.Before;
import org.junit.Test;

import java.net.InetAddress;
import java.util.ArrayList;

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
        client.prepareDelete("index_hello","article","2").get();
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

    }


}
