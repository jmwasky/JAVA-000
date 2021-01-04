package com.isaac.easy;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author think
 * @date 2021/1/4
 */
public class TestRequest {
    public static final MediaType JSONTYPE = MediaType.get("application/json; charset=utf-8");
    @Test
    public void testInventory() throws URISyntaxException, IOException {
        String reqJson = "";
        String url = "http://localhost:8081/mall/ping";
        OkHttpClient client = new OkHttpClient();
        final Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        String respJson = client.newCall(request).execute().body().string();
        System.out.println(respJson);


    }

    public static void main( String[] args ) throws IOException {
        String reqJson = "";
        String producerUrl = "http://localhost:8081/mall/producer";
        String consumerUrl = "http://localhost:8081/mall/consumer";
        OkHttpClient client = new OkHttpClient();
        Thread producer = new Thread(() -> {
            while (true) {
                Request request = new Request.Builder()
                        .url(producerUrl)
                        .post(RequestBody.create(JSONTYPE, ""))
                        .build();
                try {
                    String respJson = client.newCall(request).execute().body().string();
                    System.out.println("生产" + respJson);
                    Thread.sleep(100);
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread consumer = new Thread(() -> {
            while (true) {
                Request request = new Request.Builder()
                        .url(consumerUrl)
                        .post(RequestBody.create(JSONTYPE, ""))
                        .build();
                try {
                    String respJson = client.newCall(request).execute().body().string();
                    System.out.println("消费：" + respJson);
                    Thread.sleep(200);
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        producer.start();
        consumer.start();
    }
}
