package com.isaac.easy.redis.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author think
 * @date 2020/12/29
 */
@Component
public final class SpringContextAwareUtils implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (SpringContextAwareUtils.applicationContext == null) {
            SpringContextAwareUtils.applicationContext = applicationContext;
        }
    }

    public static <T> T getBean(Class<T> clazz) {
        return SpringContextAwareUtils.applicationContext.getBean(clazz);
    }

    public static Object getBean(String name) {
        return SpringContextAwareUtils.applicationContext.getBean(name);
    }

    public static String getProperty(String key) {
        return SpringContextAwareUtils.applicationContext.getEnvironment().getProperty(key);
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }
}
