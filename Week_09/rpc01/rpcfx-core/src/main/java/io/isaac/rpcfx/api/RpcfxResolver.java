package io.isaac.rpcfx.api;

public interface RpcfxResolver<T> {

    T resolve(Class<?> serviceClass);

}
