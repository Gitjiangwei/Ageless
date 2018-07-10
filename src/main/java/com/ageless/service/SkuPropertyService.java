package com.ageless.service;

import com.ageless.pojo.SkuOption;
import com.ageless.pojo.SkuProperty;

import java.util.List;

public interface SkuPropertyService {

    public List<SkuProperty> seleAll(Integer id,String name, Integer Pid);
    public int  shan(int  id);
    public int shan1(int  id);
    public int add(SkuProperty sku);
    int addSkuOption(List<SkuOption> ls, Integer id);

    int updateSku(Integer id,String name);

    int updateOption(Integer id,String name);

}
