package com.atguigu.gulimall.product.entity;

import com.atguigu.common.valid.AddGroup;
import com.atguigu.common.valid.ListValue;
import com.atguigu.common.valid.UpdateGroup;
import com.atguigu.common.valid.UpdateStatusGroup;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * 品牌
 * 
 * @author lixiaodong
 * @email lixiaodong@gmail.com
 * @date 2022-05-21 17:14:41
 *
 * 如何防止跨过前端直接访问服务端参数的教研？
 * 1.实体中加入校验注解
 * 2.controller层接受json加上@valid进行校验
 * 3.bindingResult---接收错误异常信息
 * 4.统一处理异常
 * @ControllerAdvice
 * 5.分组校验
 * 1.给字段上标识什么时候需要校验什么时候不需要group指定
 * 2.controller层针对某一个接口加上@Validated（指名是添加还是更新）  @Validated({AddGroup.class})
 * 3.默认没有指定分组的校验注解，在分组校验情况下不生效
 *
 *  自定义校验：
 *  1.编写一个自定义的校验注解
 *  2.编写一个自定义的校验器
 *  3.关联自定义的校验器和自定义的校验注解
 */
@Data
@TableName("pms_brand")
public class BrandEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 品牌id
	 */
	@NotNull(message = "修改必须指定id",groups = {UpdateGroup.class})
	@Null(message = "新增不用指定id",groups = {AddGroup.class})
	@TableId
	private Long brandId;
	/**
	 * 品牌名
	 */
	@NotBlank(message = "品牌名不能为空",groups = {UpdateGroup.class,AddGroup.class})
	private String name;
	/**
	 * 品牌logo地址
	 */
	@NotBlank(groups = {AddGroup.class})
	@URL(message = "logo必须是一个合法的url地址",groups = {AddGroup.class,UpdateGroup.class})
	private String logo;
	/**
	 * 介绍
	 */
	private String descript;
	/**
	 * 显示状态[0-不显示；1-显示]
	 */
	@NotNull(groups ={AddGroup.class, UpdateStatusGroup.class} )
	@ListValue(vals = {0,1},groups ={AddGroup.class,UpdateGroup.class} )
	private Integer showStatus;
	/**
	 * 检索首字母
	 */
	@NotEmpty(groups = {AddGroup.class})
	@Pattern(regexp = "^[a-zA-Z]$",message = "首字母必须是a-z或A-Z",groups = {AddGroup.class,UpdateGroup.class})
	private String firstLetter;
	/**
	 * 排序
	 */
	@NotNull(groups = {AddGroup.class})
	@Min(value = 0,message = "排序必须为大于等于的数值",groups = {AddGroup.class,UpdateGroup.class})
	private Integer sort;

}
