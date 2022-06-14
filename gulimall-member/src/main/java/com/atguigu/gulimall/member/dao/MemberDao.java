package com.atguigu.gulimall.member.dao;

import com.atguigu.gulimall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author 李晓东
 * @email lixiaodong@gulimall.com
 * @date 2020-05-22 19:42:06
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
