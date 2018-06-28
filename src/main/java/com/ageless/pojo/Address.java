package com.ageless.pojo;

import lombok.Data;

/**
 * 地址表
 */
@Data
public class Address {

    private Long id;//地址编号
    private Long nameId;//用户ID
    private String consignee;//收货人
    private String tel;//联系电话
    private String province;//省
    private String city;//市
    private String area;//区
    private String street;//街道
    private String details;//详细地址
    private Long state;//收货地址状态
    private String zipcode;//邮编
}
