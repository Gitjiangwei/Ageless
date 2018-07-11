package com.ageless.config.Alipay;

import java.io.FileWriter;
import java.io.IOException;

public class AlipayConfig {
    //↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2018062160415745";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCM8C/GBlvI8pk7k9HtJ9dJUwEpK67aYPwW3SrO2ofZsw9WmYXqk+wVJpb7nL3F/Qj2R3wo6eNYbAtNkUZ8W3QSTxvf6HTsYs9QVnzufvNXFa7dBFS9YjMvAI8RzKz1bqojxWe8cFUY/24fUzQOsxAF3gI5AbikrFzgNgROTgF338Di7iqmx1y8bVFnN3XRH19ZfS4RiiA6DDRgBI9icH4NJNt2IlCvwN/5ublr9NfdsQCAvNueiQLr2mAm0UNihIvKl5vufrqZ5CCstgbF4wYg+FDkfjWLO6TMtqZQ2+8SjQjkb1EM22NrbuyStOTxgpDs64urEI8qQtAWmDWPj9N7AgMBAAECggEAHx2kHn8m4n2VEQ84qLhEEp8twW4wg2woG9AmdFbQ6WJb/42TgE+6Lo0/hjt7tmuAAAeWRN4mYE4yTKTHQAtc2/H1QIDs14eVJ7KAkJMcnFxgJ9Gd99XnYPgpng9nHCSbkZwyo+rVDtjN8kKHWrtzzSfPq9BSeKDJPIMQfk1Ai7tY8Ag0zMP95+OVwauUAaklaF59huyRFag5pKVilAh2oNSANS5enu/8Dm0B1bSvqgHmc3pdoCb1bfUNKDLPKt/wwWAXJG0SyNeJ/C5xBHuLEZd/RSt7X7AvJXT4urWONpOUa3IEgkLBHymP2/QWAofa8IwDVtcLGudLc+PlIrs5KQKBgQDb2v10JwGcXYgx7LELvdgjfqFwfj6xbFZJz0NMbEiLoaN2Niom0pprhrbEERRO5WS+JrvwH1IPGj9vpAhd4uBU5ohrMWfnyOX2gcyiJzs3SuiK0ATmtCtcEYDuZ/Z9XvojW2yPdilaCHQ6NCLFIA6KzRDwwhAT/X+bGbWmvk1ArQKBgQCkG9Mdj7Mpc5ZOkqcCtWWBXJFKTFONwyj8eRlQzsnTgU0Kj6qHuERtS0We+5vYIkF1VgspjgfzE8A3dJPvUuTafg/agvI2hJa3gRY0tV0HD+hfttRGl5bFgjf2TQiZ/G/vcV18mUYjU3fWxcHg2wcLX0Q3dd3kbnMWN2hDbyVhxwKBgQDMyiHIrgTMGDui9Wy9GStZdL0AQjg3oEiIHC394+d3WSsgE7gTzZzVh/h6jcYy7251yTLKqwIO2043ub2pZom7y7lK0AyPVQ0QHzvz10NLb9VIaBgIpc61xgApEmIByhSKFsD6qQA/wxwwkxvILuIc3INpH/tGA513Ze1U0nK3SQKBgBXu3hVqWkClASa5NPcItWtHqudqMhSVS8oKiVaifJj3BAvwTZNcDlEpKUHpUNffJC6BdHZ2VBupvRvsScVHp+yHwqiqraKZr+cQqp4ayzchaiY4skBJDE6Ta9VQUGD8Ox2eYic/+P7Jrg+XWKUrwNJFRkG/UAuys1D50MaKeU2LAoGADOI9muHac1Y7PJ9PK6fcCGis1jg8vjiVDsOYG+uvpDTaPHkP0NrlRIStNFpmkekPIXt9a5cKDcoRVwBKMuQFZ+odNcPqMFrbK3jEkfKKQpUZpMWeAQbf1/p0w1tabdESYQS1oP3gkcQBURblRDGymMS3r9G36eiSxO3byJyT9gs=";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAotpDO65JxjZ6V6yjrKBk+PWLHCzpnAOnxfbdrXvh7wDEaxTlz2mxzGePxqKdWwJ3pOtjeVbVBxyBJxrLFXpRvmNnBJerTy8CIInVLnU6NGdQjJmRtVJ1HWw5RUGHOb7U2vSPUlG980HhR8e53H32ClVJ/EzfIJ2b8WG88Sbw6z54oWnus9IynKrva713bh0FHe6bat4xG9OaO5ovsEutWVnJcNNOxfN87/tBAiH0KgnDMqY6p3oFOAGIEFoTn3UOT1wnLftf1nWhs1ybKahIaSWGjzENN2Jg4RkwNEAqtTJuGqPW40GXqoqbnDMcrlAeku3NyqA+l476MnPcu41OowIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://www.baidu.com";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipay.com/gateway.do";

    // 支付宝网关
    public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
