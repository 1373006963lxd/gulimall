package com.atguigu.gulimall.product.dao;

import com.atguigu.gulimall.product.entity.AttrEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品属性
 * 
 * @author lixiaodong
 * @email lixiaodong@gmail.com
 * @date 2022-05-21 17:14:42
 */
@Mapper
public interface AttrDao extends BaseMapper<AttrEntity> {
	
}
