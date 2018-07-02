package com.ageless.mapper;

import com.ageless.pojo.Product;
import com.ageless.pojo.User;
import org.apache.ibatis.annotations.Param;

import javax.validation.constraints.Size;
import java.util.List;

public interface IntegralMapper {

     User selectjifen(@Param("id") Integer id);

     List<Product> selectProductjifen();
     //进行兑换
     int update( @Param("integral") String integral,@Param("id") Integer id);


     //查询用户的ID

     User selectUserId(@Param("membership") String membership,@Param("phone") String phone,@Param("mailbox") String mailbox);

}
