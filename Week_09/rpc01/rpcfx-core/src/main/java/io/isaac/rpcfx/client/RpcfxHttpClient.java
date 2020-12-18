package io.isaac.rpcfx.client;

import io.isaac.rpcfx.api.RpcfxResponse;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * @author think
 * @date 2020/12/16
 */
public class RpcfxHttpClient {
    public static String clientPost ( String url, String json) {

        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(url);
        // 构造消息头
        post.setHeader("Content-type", "application/json; charset=utf-8");
        post.setHeader("Connection", "Close");

        // 构建消息实体
        StringEntity entity = new StringEntity(json, Charset.forName("UTF-8"));
        entity.setContentEncoding("UTF-8");
        // 发送Json格式的数据请求
        entity.setContentType("application/json");
        post.setEntity(entity);

        HttpResponse response = null;
        try {
            response = httpClient.execute(post);
        } catch (IOException e) {
            e.printStackTrace();
        }
        HttpEntity responseEntity = response.getEntity();
        try {
            if (null != responseEntity) {
               return EntityUtils.toString(responseEntity, StandardCharsets.UTF_8);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
