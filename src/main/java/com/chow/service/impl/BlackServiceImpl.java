package com.chow.service.impl;

import com.chow.dao.IBlackDao;
import com.chow.dao.impl.BlackDaoImpl;
import com.chow.factory.BeanFactory;
import com.chow.service.IBlackService;

/**
 * 账户业务层实现类
 */
public class BlackServiceImpl implements IBlackService {

    private IBlackDao dao = (BlackDaoImpl)BeanFactory.getBean("BlackDao");

//    private volatile int i = 1;

    public void saveBlack() {
        int i = 1;
        dao.saveBlack();
        System.out.println(i);
        i++;
    }

}
