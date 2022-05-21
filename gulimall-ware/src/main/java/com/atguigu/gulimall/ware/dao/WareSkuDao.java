package com.atguigu.gulimall.ware.dao;

import com.atguigu.gulimall.ware.entity.WareSkuEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品库存
 * 
 * @author lixiaodong
 * @email lixiaodong@gmail.com
 * @date 2022-05-21 23:36:56
 */
@Mapper
public interface WareSkuDao extends BaseMapper<WareSkuEntity> {
	
}
