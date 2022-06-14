package com.atguigu.gulimall.search.service;

import com.atguigu.common.es.SkuEsModel;

import java.io.IOException;
import java.util.List;

/**
 * @Description:
 *
 *
 *  2020-06-06 16:53
 **/
public interface ProductSaveService {

    boolean productStatusUp(List<SkuEsModel> skuEsModels) throws IOException;
}
