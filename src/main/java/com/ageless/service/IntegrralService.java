package com.ageless.service;

import com.ageless.pojo.Product;
import com.ageless.pojo.User;

import java.util.List;

public interface IntegrralService {
    User selectjifen(Integer id);

    List<Product> selectproductjifen(Integer pageIndex);


    int update( String integral,Integer id);

    User selectUserId(String membership,String phone,String mailbox);
}
