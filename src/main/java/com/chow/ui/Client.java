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
        IBlackService ser = (BlackServiceImpl) BeanFactory.getBean("BlackService");
        ser.saveBlack();
    }
}

