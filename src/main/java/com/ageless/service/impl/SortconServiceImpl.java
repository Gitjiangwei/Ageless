package com.ageless.service.impl;

import com.ageless.mapper.SortconMapper;
import com.ageless.pojo.Sort;
import com.ageless.service.SortconService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class SortconServiceImpl implements SortconService {
    @Autowired
    private SortconMapper sortconMapper;


    @Override
    @Transactional
    public List<Sort> selectAll(String name,Integer categoryThree) {

        return sortconMapper.selectAll( name,categoryThree);
    }

    @Override
    public Boolean delSort(Integer id) {
        boolean falg=false;
        int result= sortconMapper.delSort(id);
        if(result>0){
            falg=true;
        }
        return falg;
    }

    @Override
    public Boolean delSortcon(Integer id) {
        boolean falg=false;
        int result= sortconMapper.delSortcon(id);
        if(result>0){
            falg=true;
        }
        return falg;
    }
}
