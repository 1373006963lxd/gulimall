package com.atguigu.gulimall.order.dao;

import com.atguigu.gulimall.order.entity.MqMessageEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author lixiaodong
 * @email lixiaodong@gmail.com
 * @date 2022-05-21 23:22:15
 */
@Mapper
public interface MqMessageDao extends BaseMapper<MqMessageEntity> {
	
}
