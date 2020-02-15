package com.xiaohongdian.common.util;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SpringUtils implements ApplicationContextAware {

    private ApplicationContext applicationContext = null;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if(this.applicationContext == null){
            this.applicationContext  = applicationContext;
        }
    }

    //获取applicationContext
    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    //通过name获取 Bean.
    public Object getBean(String name){
        return getApplicationContext().getBean(name);
    }

    //通过class获取Bean.
    public <T> T getBean(Class<T> clazz){
        return getApplicationContext().getBean(clazz);
    }

    //通过class获取Beans.
    public <T> List<T> getBeans(Class<T> clazz){
        List<T> beans = new ArrayList<>();
        String[] beanNames = getApplicationContext().getBeanNamesForType(clazz);
        if (beanNames!=null&&beanNames.length>0) {
            for (String beanName:beanNames) {
                T bean = getApplicationContext().getBean(beanName, clazz);
                beans.add(bean);
            }
        }
        return beans;
    }

    //通过name,以及Clazz返回指定的Bean
    public <T> T getBean(String name,Class<T> clazz){
        return getApplicationContext().getBean(name, clazz);
    }

    // 获取当前环境参数  exp: dev,prod,test
    public String getActiveProfile() {
        String []profiles = getApplicationContext().getEnvironment().getActiveProfiles();
        if(ArrayUtils.isNotEmpty(profiles)){
            return profiles[0];
        }
        return "";
    }
}
