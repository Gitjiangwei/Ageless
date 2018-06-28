package com.ageless.util;

import java.util.Random;

/**
 * @author Wang.sir
 * @create 2018-06-21 16:26
 * @desc
 **/
public class RandUtil {
    public  static String  getRandomNum(){
        Random random=new Random();
        String randomNum = random.nextInt(1000000) + "";
        if(randomNum.length()!=6){
            System.out.println("6位伪随机数："+randomNum);
            return  getRandomNum();
        }
        System.out.println("6位随机数："+randomNum);
        return randomNum;
    }
    public  static String  getRandomNum5(){
        Random random5=new Random();
        String randomNum5 = random5.nextInt(100000) + "";
        if(randomNum5.length()!=5){
            System.out.println("5位伪随机数："+randomNum5);
            return  getRandomNum5();
        }
        System.out.println("5位随机数："+randomNum5);
        return randomNum5;
    }
}
