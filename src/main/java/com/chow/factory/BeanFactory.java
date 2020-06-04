package com.chow.factory;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * 一個創建Bean對象的工廠
 * Bean在計算機英語中，有可重用組件的含義。
 *
 * 用於創建service和dao對象的
 *
 * 第一個：需要一個配置文件來配置我們的service和dao
 *        配置的內容：唯一標識=全限定類名（key=value）
 * 第二個：通過讀取配置文件中配置的內容，反射創建對象
 *
 * 配置文件可以是xml或者properties
 */
public class BeanFactory {
        //定義一個properties對象
    private static Properties pros;
        //使用靜態代碼塊為properties對象賦值
    static{
        try {
            //實例化對象
            pros = new Properties();
            //獲取properties文件的流對象
            InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");

            pros.load(in);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    /**
     * 根據Bean的名稱獲取Bean對象
     * @return
     */
    public static Object getBean(String beanName){
        Object bean = null;
        try {
            String beanPath = pros.getProperty(beanName);
            bean = Class.forName(beanPath).newInstance();
        }catch (Exception e){
            e.printStackTrace();
        }
        return bean;
    }
}
