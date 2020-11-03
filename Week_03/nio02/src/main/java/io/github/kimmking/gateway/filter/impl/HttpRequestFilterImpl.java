package io.github.kimmking.gateway.filter.impl;

import io.github.kimmking.gateway.common.Constants;
import io.github.kimmking.gateway.filter.HttpRequestFilter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.*;

/**
 * @author think
 * @date 2020/11/2
 */
public class HttpRequestFilterImpl extends ChannelInboundHandlerAdapter implements HttpRequestFilter {
    public HttpRequestFilterImpl() {
    }

    @Override
    public void filter( FullHttpRequest fullRequest, ChannelHandlerContext ctx ) {
        HttpHeaders headers = fullRequest.headers();
        headers.set(Constants.HEADER_NIO, "liangchao");
    }
}
