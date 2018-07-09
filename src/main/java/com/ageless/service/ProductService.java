package com.ageless.service;

import com.ageless.pojo.*;

import java.util.List;

public interface ProductService {

    /**
     * 根据商品id查询所有商品属性
     * @param id 商品id
     * @return 属性集合
     */
    List<Property> selectPropertyAllById( Integer id);

    /**
     * 根据商品id查询所有商品图片
     * @param id
     * @return
     */
    List<ProductPic> selectAllPicById( Integer id);

    /**
     * 根据sku属性值和用户id查询sku
     * @param skuCon sku属性值（如：1:4,3:6）
     * @param id 用户id
     * @return sku对象
     */
    Sku selectSkuByCon(String skuCon, Integer id);

    /**
     * 查询所有sku值（如：白色、红色）根据optionid集合
     * @param list option的id组成的集合
     * @return 所有id对应的option对象的集合
     */
    List<SkuOption> selectAllSkuoptionById(List<String> list);

    /**
     * 查询所有sku属性（如：颜色、尺码）根据propertyid集合
     * @param list property的id组成的集合
     * @return 所有id对应的property对象的集合
     */
    List<SkuProperty> selectAllSkupropertyByIds(List<String> list);

    /**
     * 根据商品id查询所有sku的值
     * @param id 商品id
     * @return 商品对应的sku的集合
     */
    List<Sku> selectAllSkuById( Integer id);

    /**
     * 根据商品id查询商品
     * @param id 商品id
     * @return 商品的对象
     */
    Product selectPoroductById( Integer id);

    /**
     * 根据商品id查询商品
     * @param id 商品id
     * @return 商品的对象
     */
    List<Product> selectall( Integer id);

    int add(Product pro);

    List<Sku> selectNullSkuByOptId(List<Integer> list,Integer productId);

    int modifyProduct(Product pro);
}
