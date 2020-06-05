package com.chow.factory;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
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
    
    //定义一个Map，用于存放我们要创建的对象。我们称之为容器

    private static Map<String,Object> beans;
    
        //使用靜態代碼塊為properties對象賦值
    static{
        try {
            //實例化對象
            pros = new Properties();
            //獲取properties文件的流對象
            InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");

            pros.load(in);
            //实例化容器
            beans = new HashMap<String, Object>();
            //取出配置文件中的所有Key
            Enumeration keys = pros.keys();
            //遍历枚举
            while(keys.hasMoreElements()){
                //取出每个Key
                String key = keys.nextElement().toString();
                //根据key获取value
                String beanPath = pros.getProperty(key);
                //反射创建对象
                Object value = Class.forName(beanPath).newInstance();
                //把key和value存入容器中
                beans.put(key,value);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }


    /**
     * 根據Bean的名稱獲取Bean對象
     * @return
     */
    public static Object getBean(String beanName){
        return beans.get(beanName);
    }

    /**
     * 根據Bean的名稱獲取Bean對象
     * @return
     */

/*    public static Object getBean(String beanName){
        Object bean = null;
        try {
            String beanPath = pros.getProperty(beanName);
            bean = Class.forName(beanPath).newInstance();
        }catch (Exception e){
            e.printStackTrace();
        }
        return bean;
    }*/
}
