package com.cars.ES;

import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.Test;

import java.net.InetAddress;

/**
 * @Description es服务器端测试
 * @Author Wy005
 * @Date 2020/7/30 9:56
 * @Version 1.0
 **/
@Slf4j
public class ElstaicSearchClientTest {

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
}
