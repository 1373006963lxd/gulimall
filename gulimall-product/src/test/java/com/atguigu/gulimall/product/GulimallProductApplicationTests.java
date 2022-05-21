package com.atguigu.gulimall.product;

import com.atguigu.gulimall.product.entity.BrandEntity;
import com.atguigu.gulimall.product.service.BrandService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

@SpringBootTest
class GulimallProductApplicationTests {


    @Autowired
    BrandService brandService;
    @Test
    void contextLoads() {
        BrandEntity brandEntity = new BrandEntity();
        brandEntity.setName("华为");
        brandService.save(brandEntity);
    }

    @Test
    void getBrandEntity(){
        /*List<BrandEntity> brandEntities = brandService.list(new QueryWrapper<BrandEntity>().le("brand_id", 10));
        brandEntities.forEach((item)->{
            System.out.println(item);
        });*/
        Map<String, Object> map = brandService.getMap(new QueryWrapper<BrandEntity>().between("brand_id",10,12));
        Iterator<Map.Entry<String, Object>> entryIterator = map.entrySet().iterator();
        System.out.println(map);
    }

}
