/** Copyright 2022 lixiaodong */
package com.atguigu.gulimall.product.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Auto-generated: 2022-05-31 11:3:26
 *
 * @author lixiaodong (i@lixiaodong)
 * @website https://github.com/settings/profile
 * 对于精度要求严格的使用bigdecimal类型
 */

@Data
public class Bounds {

  private BigDecimal buyBounds;
  private BigDecimal growBounds;

}
