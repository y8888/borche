package com.chow.ui;


import com.chow.factory.BeanFactory;
import com.chow.service.IBlackService;
import com.chow.service.impl.BlackServiceImpl;

/**
 *
 * 模擬一個表示層，用於調用業務層
 *
 */
public class Client {
    public static void main(String[] args) {
        for (int i = 0 ; i< 5 ; i++){
            IBlackService ser = (BlackServiceImpl) BeanFactory.getBean("BlackService");
            System.out.println(ser);
            ser.saveBlack();
        }

    }
    public static String gitUpdate(String times){
        System.out.println("新来的");
        return "第"+times+"次修改Git";

    }
}

