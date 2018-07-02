package com.ageless.service.impl;

import com.ageless.mapper.IntegralMapper;
import com.ageless.pojo.Product;
import com.ageless.pojo.User;
import com.ageless.service.IntegrralService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;


@Service
public class IntegralServiceImpl implements IntegrralService {


    @Resource
    private IntegralMapper sss;


    @Override
    public User selectjifen(Integer id) {
        return  sss.selectjifen(id);
    }

    @Override
    public List<Product> selectproductjifen(Integer pageIndex) {
        PageHelper.startPage(pageIndex,5);
        return sss.selectProductjifen();
    }

    @Override
    public int update(String integral,Integer id) {
        return sss.update(integral,id);
    }

    @Override
    public User selectUserId(String membership, String phone, String mailbox) {
        return sss.selectUserId(membership,phone,mailbox);
    }
}
