package com.ageless.controller;

import com.ageless.pojo.Order;
import com.ageless.pojo.SkuOption;
import com.ageless.pojo.SkuProperty;
import com.ageless.pojo.User;
import com.ageless.service.OrderService;
import com.ageless.service.ProductService;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.math.BigInteger;
import java.util.*;

@Controller
@RequestMapping(value="/Order")
public class OrderController {
    @Resource
    private OrderService orderService;

    @Resource
    private ProductService productService;
    final Timer timer = new Timer();

    //进入商品页面
    @RequestMapping("/show")
    public String show(){
        return "udai_order";
    }


    @RequestMapping("/shows")
    public String shows(Model model, @RequestParam(required = false) String status,
                        @RequestParam(required = false)Integer id){
        Order address=orderService.order_details(id);
        List<Order> allProduct=orderService.order_product(id);
        for (int i=0;i<allProduct.size();i++){
            String skuNum= allProduct.get(i).getSkuCon();
            System.out.println(skuNum+"-*******************************************");
            String s=skuString(skuNum);
            allProduct.get(i).setSkuCons(s);
        }
        for (Order v:allProduct
                ) {
            System.out.println(v.getSkuCons()+"-*******************************************");
        }
        model.addAttribute("item",address);
        model.addAttribute("items",allProduct);
        return "udai_order_receipted";
    }





    //查询所有订单
    @RequestMapping("/all")
    @ResponseBody
    public Object all(@RequestParam(required = false) String status,
        @RequestParam(required = false)Integer id){
            List<Order> all = orderService.all(status,id);
        for (int i=0;i<all.size();i++){
            String skuNum= all.get(i).getSkuCon();
            String s=skuString(skuNum);
            all.get(i).setSkuCons(s);
        }
            return JSON.toJSONString(all);
        }
        //查看订单详情
        @GetMapping("/udai_order_detail.html")
        public String udaishop(Model model, @RequestParam(required = false) String status,
                @RequestParam(required = false)Integer id) {
            Order address=orderService.order_details(id);
            List<Order> allProduct=orderService.order_product(id);
            for (int i=0;i<allProduct.size();i++){
               String skuNum= allProduct.get(i).getSkuCon();
                System.out.println(skuNum+"-*******************************************");
               String s=skuString(skuNum);
               allProduct.get(i).setSkuCons(s);
            }
            for (Order v:allProduct
                 ) {
                System.out.println(v.getSkuCons()+"-*******************************************");
            }
            model.addAttribute("item",address);
            model.addAttribute("items",allProduct);
            return "udai_order_detail";
        }

        //订单取消（删除）
        @RequestMapping("/delorder")
        @ResponseBody
        public Object  delorder(Integer delid){
            int delOrd=orderService.delOrder(delid);
            Object json=JSON.toJSON(delOrd);
            return json;
    }

    public String skuString(String skuCon){
        StringBuffer sku = new StringBuffer();
        String substring = skuCon.substring(0, skuCon.length()-1);//截取最后一个
        System.out.println(substring);
        String[] split = substring.split(",");//以逗号分割
        Integer len = split.length;
        List<String> skuPropertyIds = new ArrayList<>();
        List<String> skuOptionIds = new ArrayList<>();
        for (String string2 : split) {
            int q = 0;
            for(int i=0;i<string2.length();i++) {
                if(string2.indexOf(":", i)!=-1){
                    q++;
                }
            }
            String skucon1 = string2.substring(q,string2.length());
            String skucon2 = string2.substring(0,q-1);

            if (!skuOptionIds.contains(skucon1)){
                skuOptionIds.add(skucon1);
            }
            if (!skuPropertyIds.contains(skucon2)){
                skuPropertyIds.add(skucon2);
            }
        }
        //service是：
        //  @Resource
        //  private ProductService service;
        List<SkuProperty> properties = productService.selectAllSkupropertyByIds(skuPropertyIds);
        List<SkuOption> options = productService.selectAllSkuoptionById(skuOptionIds);
        for (String string2 : split) {
            int q = 0;
            for(int j=0;j<string2.length();j++) {
                if(string2.indexOf(":", j)!=-1){
                    q++;
                }
            }
            String skucon1 = string2.substring(q,string2.length());
            String skucon2 = string2.substring(0,q-1);
            for (SkuProperty property:properties) {
                if (Integer.parseInt(skucon2) == property.getId()){
                    sku.append(property.getPropertyName()+":");
                }
            }
            for (SkuOption option:options) {
                if (Integer.parseInt(skucon1) == option.getId()){
                    sku.append(option.getOptionName()+",");
                }
            }
        }
        String skus = sku.toString().substring(0, sku.length()-1);//截取最后一个
        return skus;
    }


    @GetMapping(value = "/xq")
    @ResponseBody
    public Object selectall(@RequestParam(required = false) String numbers ,@RequestParam(required = false) int id ,@RequestParam(required = false) String create) {
        List<Order> lsts =orderService.seleAll(numbers,id,create);
        System.out.println(lsts);
        Object obj = JSON.toJSON(lsts);
        System.out.println(obj);
        return obj;
    }
    @GetMapping(value = "/xqs")
    @ResponseBody
    public Object selectnid(@RequestParam(required = false) String nid) {
        List<Order> lsts =orderService.selenid(nid);
        System.out.println(lsts);
        Object obj = JSON.toJSON(lsts);
        System.out.println(obj);
        return obj;
    }
    @GetMapping(value = "/sc")
    @ResponseBody
    public Object deleteall(@RequestParam(required = false) String nid) {
        int res = orderService.delete(nid);
        Object obj = JSON.toJSONString(res);
        return obj;
    }
    @GetMapping(value = "/dall")
    @ResponseBody
    public Object delete(@RequestParam(required = false) List<String> nid) {
        int res = orderService.dall(nid);
        Object obj = JSON.toJSONString(res);
        System.out.println(obj);
        return obj;
    }

    //添加生成订单
    @PostMapping("/addOrder")
    @ResponseBody
    public  Object  addOrder(@RequestParam(required = false) String number,
                             @RequestParam(required = false) Integer addressid,
                             @RequestParam(required = false) String createDate,
                             @RequestParam(required = false) Integer atch,
                             @RequestParam(required = false) Integer userId,
                             @RequestParam(required = false)  Integer orderNumber,
                             @RequestParam(required = false) Integer OrderStatus,
                             @RequestParam(required = false) String order_price,
                             @RequestParam(required = false) Integer productid,
                             HttpSession session){


        Order order=new Order();
        //生成随机18位订单编号
        String s = "";
        Random random = new Random();
        s+=1+(random.nextInt(9));
        for (int i = 0; i < 18-1; i++) {
            s+=random.nextInt(10);
        }
        BigInteger bigInteger=new BigInteger(s);
        order.setNumber(bigInteger.toString());//订单编号随机
        order.setAddressid(1);//地址编号
        order.setAtch(1);//交易流水号
        /*User user= (User) session.getAttribute("user");
        Long useId=user.getId();//报错
        order.setUserId(useId.intValue());*/
        order.setUserId(1);
        order.setOrderNumber(5);
        order.setOrderStatus(2);
        order.setProductid(productid);
        order.setOrder_price(order_price);
        int addorder=orderService.addOrder(order);
        Object json=JSON.toJSON(addorder);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {

                try {
                    Integer ret = orderService.delete(order.getNumber());
                    if(ret > 0) {

                    }
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                // 中断线程
                timer.cancel();
            }
            //1秒等于1000毫秒  这里是一天
        },1*60*1000);

        return json;
    }
    @PostMapping("/addOrderdet")
    @ResponseBody
    public  Object  addOrderdet( @RequestParam(required = false) Integer shipid,
                                 @RequestParam(required = false) Integer oid,
                                 @RequestParam(required = false) Integer skuId,
                                 @RequestParam(required = false) Integer count){
        Order order=new Order();
        order.setOid(2);
        order.setCount(3);
        order.setShipid(1);
        order.setSkuId(skuId);
        int addorders=orderService.addOrderdet(order);
        Object json=JSON.toJSON(addorders);
        return json;
    }

    //收货修改订单状态
       @RequestMapping("/updateOrder")
       public String updataOrd(Integer id,Integer OrderStatus){
           int upOrder=orderService.updataOrder(id,OrderStatus);
           if(upOrder>0){
                System.out.print("修改成功！");
           }else{
                System.out.print("修改失败！");
           }
           return"/Order/show";
       }

}
