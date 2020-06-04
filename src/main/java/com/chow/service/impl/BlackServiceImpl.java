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

    public void saveBlack() {
        dao.saveBlack();
    }

}
