package com.ageless.service;

import com.ageless.pojo.Address;

import java.util.List;

/**
 * 收货地址
 */
public interface AddressService {
    /**
     * 显示收货地址
     * @return
     */
    List<Address> getListAddress(Long nameId);

    /**
     * 添加地址
     * @param address
     * @return
     */
    Integer insertAddress(Address address);

    /**
     * 删除地址
     * @param id
     * @return
     */
    Integer deleteAddress(Long id);

    /**
     * 修改地址
     * @param address
     * @return
     */
    Integer updateAddress(Address address,Long id);
}
