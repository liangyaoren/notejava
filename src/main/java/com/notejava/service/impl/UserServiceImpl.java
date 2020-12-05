package com.notejava.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.notejava.entity.User;
import com.notejava.mapper.UserMapper;
import com.notejava.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author lyle
 * @since 2020-12-03
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void register(User user) {
        String password = passwordEncoder.encode(user.getPassword());
        user.setPassword(password);
        save(user);
    }
}
