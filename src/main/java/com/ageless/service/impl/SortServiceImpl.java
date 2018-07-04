package com.ageless.service.impl;

import com.ageless.mapper.SortMapper;
import com.ageless.pojo.Product;
import com.ageless.pojo.Sort;
import com.ageless.pojo.Sortcon;
import com.ageless.service.SortService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SortServiceImpl implements SortService {


    @Resource
    private SortMapper sortMapper;

    /**yy
     * 根据三级列表id查询
     * 查询三级id下面的内容
     * @return
     */
    @Override
    public List<Sort> selectsanji(Integer categorythreeId) {
        System.out.println(categorythreeId);
        return sortMapper.selectsanji(categorythreeId);
    }

    @Override
    public List<Product> selectProduct(List<Integer> list, String tiaojian,Integer pageIndex) {
        PageHelper.startPage(pageIndex,4);
        return sortMapper.selectProduct(list,tiaojian);
    }

    @Override
    public List<Product> selectmohu(String mo, String tiaojian,Integer pageIndex) {
        PageHelper.startPage(pageIndex,4);
        return sortMapper.selectmohu(mo,tiaojian);
    }

    @Override
    public int addSortcon(List<Sortcon> ls,Integer id) {
        return sortMapper.addSortcon(ls,id);
    }
}
