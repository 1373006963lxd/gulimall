package com.atguigu.gulimall.thirdparty;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GulimallThirdPartyApplicationTests {

    @Test
    public void contextLoads() {
    }


    @Resource
    OSSClient ossClient;

    @Test
    public void upload(){

        // Endpoint以华东1（杭州）为例，其它Region请按实际情况填写。
        //String endpoint = "oss-cn-beijing.aliyuncs.com";
        // 阿里云账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM用户进行API访问或日常运维，请登录RAM控制台创建RAM用户。
        //String accessKeyId = "LTAI5tGDiTtfnCyLGBk8Zmy4";
        //String accessKeySecret = "zJUcyr4tD0CjXK0SsMPRJaYjcmOTuN";
        // 填写Bucket名称，例如examplebucket。
        String bucketName = "gulimall-lxd525";
        // 填写Object完整路径，完整路径中不能包含Bucket名称，例如exampledir/exampleobject.txt。
        String objectName = "hahhahah.jpg";
        // 填写本地文件的完整路径，例如D:\\localpath\\examplefile.txt。
        // 如果未指定本地路径，则默认从示例程序所属项目对应本地路径中上传文件流。
        String filePath= "H:\\gulimall\\谷粒商城资料整理课件\\基础篇\\资料\\pics\\28f296629cca865e.jpg";

        // 创建OSSClient实例。
        //OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        try {
            InputStream inputStream = new FileInputStream(filePath);
            // 创建PutObject请求。
            ossClient.putObject(bucketName, objectName, inputStream);
            System.out.printf("上传成功");
        } catch (OSSException | FileNotFoundException oe) {
            System.out.println("Caught an OSSException, which means your request made it to OSS, "
                    + "but was rejected with an error response for some reason.");
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
    }
}
