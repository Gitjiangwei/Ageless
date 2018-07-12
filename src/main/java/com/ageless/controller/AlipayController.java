package com.ageless.controller;


import com.ageless.config.Alipay.AlipayConfig;
import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping(value = "alipay")
public class AlipayController {
    Log log = LogFactory.getLog(AlipayController.class);
    @ResponseBody
    @RequestMapping(value ="/pagepay",method = RequestMethod.POST)
    public Object pagepay( @RequestParam(required = false) String WIDout_trade_no,@RequestParam(required = false) String WIDtotal_amount
            ,@RequestParam(required = false) String WIDsubject,@RequestParam(required = false) String xWIDbody) {
        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);

        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
        System.out.println("参数"+WIDout_trade_no+","+","+WIDtotal_amount+","+WIDsubject);
        //商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no = WIDout_trade_no;
        //付款金额，必填
        String total_amount = WIDtotal_amount;
        //订单名称，必填
        String subject = WIDsubject;
        //商品描述，可空
        String body =xWIDbody;

        alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
                + "\"total_amount\":\""+ total_amount +"\","
                + "\"subject\":\""+ subject +"\","
                + "\"body\":\""+ body +"\","
                + "\"timeout_express\":\"10m\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

        //若想给BizContent增加其他可选请求参数，以增加自定义超时时间参数timeout_express来举例说明
        //alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
        //		+ "\"total_amount\":\""+ total_amount +"\","
        //		+ "\"subject\":\""+ subject +"\","
        //		+ "\"body\":\""+ body +"\","
        //		+ "\"timeout_express\":\"10m\","
        //		+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        //请求参数可查阅【电脑网站支付的API文档-alipay.trade.page.pay-请求参数】章节

        //请求
        String result = null;
        try {
            result = alipayClient.pageExecute(alipayRequest).getBody();
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }

        //输出
        System.out.println("张晓鹏"+result);
        Object obj=JSON.toJSON(result);
        System.out.println("小花花"+obj);
        return result;


    }

}
