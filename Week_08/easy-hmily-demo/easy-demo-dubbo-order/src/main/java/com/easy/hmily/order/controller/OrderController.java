/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.easy.hmily.order.controller;

import com.easy.hmily.api.IAccountService;
import com.easy.hmily.api.IOrderService;
import com.easy.hmily.entity.Order;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @author xiaoyu
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    /*@DubboReference(version = "1.0.0")
    private IAccountService accountService;

    @DubboReference(version = "1.0.0")
    private IOrderService orderService;

    @Autowired
    public OrderController( IOrderService orderService) {
        this.orderService = orderService;
    }
    
    @PostMapping(value = "/orderPay")
    @ApiOperation(value = "订单支付接口（注意这里模拟的是创建订单并进行支付扣减库存等操作）")
    public String orderPay(@RequestParam(value = "count") Integer count,
                           @RequestParam(value = "amount") BigDecimal amount) {
        final long start = System.currentTimeMillis();
        Order order = orderService.findById(1);
        System.out.println("消耗时间为:" + (System.currentTimeMillis() - start));
        System.out.println("order:" +order);
        return "";
    }
*/
    
    @PostMapping(value = "/mockAccountWithTryException")
    @ApiOperation(value = "模拟下单付款操作在try阶段时候，账户rpc异常，此时订单状态会回滚，达到数据的一致性（注意:这里模拟的是系统异常，或者rpc异常）")
    public String mockAccountWithTryException(@RequestParam(value = "count") Integer count,
                                                @RequestParam(value = "amount") BigDecimal amount) {
        return "";
    }


}
