package com.atguigu.gulimall.product;

import com.atguigu.gulimall.product.entity.BrandEntity;
import com.atguigu.gulimall.product.service.BrandService;
import com.atguigu.gulimall.product.service.CategoryService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

/*
* 1.引入oss-start
* 2.配置key，endpopint相关信息
* 3.使用OSSClient进行相关操作
*
* */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class GulimallProductApplicationTests {



    @Autowired
    BrandService brandService;

    @Autowired
    CategoryService categoryService;


    @Test
    public void testPath(){
        Long[] path = categoryService.findCatelogPath(255L);
        log.info("完整路径：{}", Arrays.asList(path));
    }
    @Test
   public void contextLoads() {
        BrandEntity brandEntity = new BrandEntity();
        brandEntity.setName("华为");
        brandService.save(brandEntity);
    }

    @Test
   public void getBrandEntity(){
        /*List<BrandEntity> brandEntities = brandService.list(new QueryWrapper<BrandEntity>().le("brand_id", 10));
        brandEntities.forEach((item)->{
            System.out.println(item);
        });*/
        Map<String, Object> map = brandService.getMap(new QueryWrapper<BrandEntity>().between("brand_id",10,12));
        Iterator<Map.Entry<String, Object>> entryIterator = map.entrySet().iterator();
        System.out.println(map);
    }

}
