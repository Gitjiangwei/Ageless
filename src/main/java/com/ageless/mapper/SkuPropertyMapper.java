package com.ageless.mapper;

import com.ageless.pojo.SkuProperty;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SkuPropertyMapper {

    public List<SkuProperty> seleAll(@Param("id")int id ,@Param("name")String name);
    public  int shan(@Param("id") int id);
    public int shan1(@Param("id") int  id);
}
