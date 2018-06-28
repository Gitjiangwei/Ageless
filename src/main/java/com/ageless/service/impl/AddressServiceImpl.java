package com.ageless.service.impl;

import com.ageless.mapper.AddressMapper;
import com.ageless.pojo.Address;
import com.ageless.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressMapper addressMapper;
    @Override
    public List<Address> getListAddress(Long nameId) {
        return addressMapper.getListAddress(nameId);
    }

    @Override
    public Integer insertAddress(Address address) {
        return addressMapper.insertAddress(address);
    }

    @Override
    public Integer deleteAddress(Long id) {
        return addressMapper.deleteAddress(id);
    }

    @Override
    public Integer updateAddress(Address address,Long id) {
        return addressMapper.updateAddress(address,id);
    }
}
