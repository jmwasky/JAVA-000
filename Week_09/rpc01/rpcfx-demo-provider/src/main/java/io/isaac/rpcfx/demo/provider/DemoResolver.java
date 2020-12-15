package io.isaac.rpcfx.demo.provider;

import io.isaac.rpcfx.api.RpcfxResolver;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class DemoResolver<T> implements RpcfxResolver<T>, ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public T resolve(Class<?> serviceClass) {
        return (T)this.applicationContext.getBean(serviceClass);
    }
}
