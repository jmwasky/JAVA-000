package io.isaac.rpcfx.client;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;
import io.isaac.rpcfx.api.RpcfxResponse;
import io.isaac.rpcfx.api.RpcfxRequest;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import net.bytebuddy.dynamic.loading.ClassReloadingStrategy;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.implementation.bind.annotation.*;
import net.bytebuddy.matcher.ElementMatchers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import static net.bytebuddy.matcher.ElementMatchers.*;

public final class Rpcfx {

    static {
        ParserConfig.getGlobalInstance().addAccept("io.isaac");
    }

    public static <T> T create(final Class<T> serviceClass, final String url) {
        T result = null;
        // 0. 替换动态代理 -> AOP
        return (T) Proxy.newProxyInstance(Rpcfx.class.getClassLoader(), new Class[]{serviceClass}, new RpcfxInvocationHandler(serviceClass, url));
        // 无法调通  Cannot only define public, static, final field 'delegate$f0pnm81' for interface type
        // 如果改为subclass 在服务端无法找到类
        /*try {
            result = (T) new ByteBuddy()
                    .rebase(serviceClass)
                    .name(serviceClass.getName())
                    //.implement(serviceClass)
                    .method(ElementMatchers.isDeclaredBy(serviceClass))
                    .intercept(MethodDelegation.to(new RpcfxByteBuddyHandler(url)))
                    .make()
                    .load(Rpcfx.class.getClassLoader(), ClassLoadingStrategy.Default.CHILD_FIRST)
                    //.load(Class.forName(serviceClass.getName()).getClassLoader(), ClassLoadingStrategy.Default.WRAPPER_PERSISTENT)
                    .getLoaded()
                    .newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return result;*/
    }

    public static class RpcfxInvocationHandler implements InvocationHandler {

        public static final MediaType JSONTYPE = MediaType.get("application/json; charset=utf-8");

        private final Class<?> serviceClass;
        private final String url;
        public <T> RpcfxInvocationHandler(Class<T> serviceClass, String url) {
            this.serviceClass = serviceClass;
            this.url = url;
        }

        // 可以尝试，自己去写对象序列化，二进制还是文本的，，，rpcfx是xml自定义序列化、反序列化，json: code.google.com/p/rpcfx
        // int byte char float double long bool
        // [], data class

        @Override
        public Object invoke(Object proxy, Method method, Object[] params) throws Throwable {
            RpcfxRequest request = new RpcfxRequest();
           // request.setServiceClass(this.serviceClass.getName());
            request.setClazz(this.serviceClass);
            request.setMethod(method.getName());
            request.setParams(params);

            RpcfxResponse response = post(request, url);
            // 这里判断response.status，处理异常
            if (!response.isStatus()) {
                throw new RuntimeException(response.getException().getMessage());
            }
            // 考虑封装一个全局的RpcfxException

            return JSON.parse(response.getResult().toString());
        }

        private RpcfxResponse post(RpcfxRequest req, String url) throws IOException {
            String reqJson = JSON.toJSONString(req);
            System.out.println("req json: "+reqJson);

            // 1.可以复用client
            // 2.尝试使用httpclient或者netty client
            OkHttpClient client = new OkHttpClient();
            final Request request = new Request.Builder()
                    .url(url)
                    .post(RequestBody.create(JSONTYPE, reqJson))
                    .build();
            String respJson = client.newCall(request).execute().body().string();
            System.out.println("resp json: "+respJson);
            return JSON.parseObject(respJson, RpcfxResponse.class);
        }
    }
}
