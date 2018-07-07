package com.ageless.mapper;

import com.ageless.pojo.SkuOption;
import com.ageless.pojo.SkuProperty;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SkuPropertyMapper {

    public List<SkuProperty> seleAll(@Param("id")Integer id ,@Param("name")String name,@Param("pid") Integer Pid);
    public  int shan(@Param("id") int id);
    public int shan1(@Param("id") int  id);
    public int add(SkuProperty sku);
    int addSkuOption(@Param("list") List<SkuOption> ls, @Param("id")Integer id);

    int updateSku(@Param("id")Integer id,@Param("name")String name);

    int updateOption(@Param("id")Integer id,@Param("name")String name);

}
