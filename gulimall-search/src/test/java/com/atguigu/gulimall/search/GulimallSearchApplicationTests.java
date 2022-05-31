package com.atguigu.gulimall.search;

import com.alibaba.fastjson.JSON;
import com.atguigu.gulimall.search.config.GulimallElasticSearchConfig;
import lombok.Data;
import lombok.ToString;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.elasticsearch.search.aggregations.metrics.Avg;
import org.elasticsearch.search.aggregations.metrics.AvgAggregationBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GulimallSearchApplicationTests {

    @Autowired
    private RestHighLevelClient client;
    @Test
   public  void contextLoads() {
        System.out.println(client);
    }



    @ToString
    @Data
    static class Account {
        private int account_number;
        private int balance;
        private String firstname;
        private String lastname;
        private int age;
        private String gender;
        private String address;
        private String employer;
        private String email;
        private String city;
        private String state;
    }

/*
*
* 检索数据
*
* */
    @Test
    public  void searchData() throws IOException {
        //创建检索请求
        SearchRequest searchRequest = new SearchRequest();
        //指定索引
        searchRequest.indices("bank");
        //构造检索条件
        SearchSourceBuilder builder = new SearchSourceBuilder();
        //查询匹配字段
        builder.query(QueryBuilders.matchQuery("address","mill"));
        //聚合查询--按照年龄进行聚合
        TermsAggregationBuilder aggregationBuilder = AggregationBuilders.terms("ageAgg").field("age").size(10);
        builder.aggregation(aggregationBuilder);
        //计算平均薪资
        AvgAggregationBuilder balanceAvg = AggregationBuilders.avg("balanceAvg").field("balance");
        builder.aggregation(balanceAvg);
        System.out.println(builder.toString());
        searchRequest.source(builder);
        //执行检索
        SearchResponse searchResponse = client.search(searchRequest, GulimallElasticSearchConfig.COMMON_OPTIONS);

        //分析结果 searchResponse
        System.out.println(searchResponse.toString());
        SearchHits hits = searchResponse.getHits();
        SearchHit[] searchHits = hits.getHits();
        for (SearchHit hit : searchHits) {
            //hit.getId();hit.getIndex();hit.getScore();
            String sourceAsString = hit.getSourceAsString();
            Account account = JSON.parseObject(sourceAsString, Account.class);
            System.out.println("account对象: "+account);
        }
        //4. 获取聚合信息
        Aggregations aggregations = searchResponse.getAggregations();

        Terms ageAgg1 = aggregations.get("ageAgg");

        for (Terms.Bucket bucket : ageAgg1.getBuckets()) {
            String keyAsString = bucket.getKeyAsString();
            System.out.println("年龄：" + keyAsString + " ==> " + bucket.getDocCount());
        }
        /*Avg ageAvg1 = aggregations.get("ageAvg");
        System.out.println("平均年龄：" + ageAvg1.getValue());*/

        Avg balanceAvg1 = aggregations.get("balanceAvg");
        System.out.println("平均薪资：" + balanceAvg1.getValue());
    }
/*
* 测试存储数据到es
*
* */
    @Test
    public  void indexData() throws IOException {
        IndexRequest indexRequest = new IndexRequest("users");//哪一个索引--表
        indexRequest.id("1");//哪一个id
        User user = new User();
        user.setName("lixaodong");
        user.setAge(18);
        user.setGender("man");
        String jsonString = JSON.toJSONString(user);
        indexRequest.source(jsonString, XContentType.JSON);//要保存的数据
        IndexResponse index = client.index(indexRequest, GulimallElasticSearchConfig.COMMON_OPTIONS);
        System.out.println(index);
    }
    @Data
    class User{
        private String name;
        private String gender;
        private Integer age;
    }
}
