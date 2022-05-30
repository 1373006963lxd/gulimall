package com.atguigu.gulimall.ware.controller.feign;

import com.atguigu.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("gulimall-product")
public interface ProductFeignService {

    /*
    * 可以采用两种方式远程调用
    * 1.直接到指定服务请求
    * 1.1@FeignClient("gulimall-product")
    * 1.2@RequestMapping("/product/skuinfo/info/{skuId}")
    *
    * 2.让所有远程调用请求都过网关
    * 2.1@FeignClient("gulimall-gateway")
    * 2.2@RequestMapping(/api/product/skuinfo/info/{skuId}")
    * */

    @RequestMapping("/product/skuinfo/info/{skuId}")
    public R info(@PathVariable("skuId") Long skuId);
}
