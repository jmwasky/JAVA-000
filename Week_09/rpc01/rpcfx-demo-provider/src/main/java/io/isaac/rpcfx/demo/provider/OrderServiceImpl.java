package io.isaac.rpcfx.demo.provider;

import io.isaac.rpcfx.demo.api.Order;
import io.isaac.rpcfx.demo.api.OrderService;

public class OrderServiceImpl implements OrderService {

    @Override
    public Order findOrderById(int id) {
        return new Order(id, "Cuijing" + System.currentTimeMillis(), 9.9f);
    }
}
