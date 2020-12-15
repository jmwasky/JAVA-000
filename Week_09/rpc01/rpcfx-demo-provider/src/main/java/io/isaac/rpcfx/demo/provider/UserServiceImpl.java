package io.isaac.rpcfx.demo.provider;

import io.isaac.rpcfx.demo.api.User;
import io.isaac.rpcfx.demo.api.UserService;

public class UserServiceImpl implements UserService {

    @Override
    public User findById(int id) {
        return new User(id, "KK" + System.currentTimeMillis());
    }
}
