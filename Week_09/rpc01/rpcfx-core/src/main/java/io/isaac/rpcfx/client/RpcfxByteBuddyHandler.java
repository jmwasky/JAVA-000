package io.isaac.rpcfx.client;

import com.alibaba.fastjson.JSON;
import io.isaac.rpcfx.api.RpcfxRequest;
import io.isaac.rpcfx.api.RpcfxResponse;
import net.bytebuddy.implementation.bind.annotation.AllArguments;
import net.bytebuddy.implementation.bind.annotation.Origin;
import net.bytebuddy.implementation.bind.annotation.RuntimeType;
import net.bytebuddy.implementation.bind.annotation.This;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @author think
 * @date 2020/12/16
 */
public class RpcfxByteBuddyHandler {

    private String url;

    public RpcfxByteBuddyHandler(String url) {
        this.url = url;
    }

    public static final MediaType JSONTYPE = MediaType.get("application/json; charset=utf-8");
    @RuntimeType
    public Object interceptor( @This Object object, @Origin Method method, @AllArguments Object[] params) throws Throwable {

        RpcfxRequest request = new RpcfxRequest();
        // request.setServiceClass(this.serviceClass.getName());
        request.setClazz(object.getClass());
        request.setMethod(method.getName());
        request.setParams(params);

        RpcfxResponse response = post(request, this.url);
        if (!response.isStatus()) {
            throw new RuntimeException(response.getException().getMessage());
        }
        return JSON.parse(response.getResult().toString());
    }

    private RpcfxResponse post( RpcfxRequest req, String url) throws IOException {
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