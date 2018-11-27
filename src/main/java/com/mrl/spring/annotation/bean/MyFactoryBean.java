package com.mrl.spring.annotation.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 *  
 *  Spring提供的工厂bean
 *  
 * @作者 lwq
 * @version [版本号, 2018年9月4日]
 * @see [相关类/方法]
 * @since [产品/模块版本] 
 */
public class MyFactoryBean implements FactoryBean<Color>
{

    /* 
     *  这个返回对象会被添加到容器中
     */
    @Override
    public Color getObject() throws Exception {
        // TODO Auto-generated method stub
        System.out.println("getObject.....");
        return new Color();
    }

    @Override
    public Class<?> getObjectType() {
        // TODO Auto-generated method stub
        return Color.class;
    }

    @Override
    public boolean isSingleton() {
        // TODO Auto-generated method stub
        return true;
    }

}
