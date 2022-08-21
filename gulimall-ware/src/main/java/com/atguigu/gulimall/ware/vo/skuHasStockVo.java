package com.atguigu.gulimall.ware.vo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class skuHasStockVo {
    @TableId
    private Long skuId;
    private Boolean hasStock;
}
