package com.notejava.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.notejava.entity.Role;
import com.notejava.entity.User;
import com.notejava.entity.UserDetail;
import com.notejava.service.IRoleService;
import com.notejava.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private IUserService userService;

    @Autowired
    private IRoleService roleService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        log.debug("开始登陆验证，用户名为: {}", s);

        // 根据用户名验证用户
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(User::getUsername, s);
        User user = userService.getOne(queryWrapper);
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在，登陆失败。");
        }

        // 构建UserDetail对象
        UserDetail userDetail = new UserDetail();
        userDetail.setUser(user);
        List<Role> roleList = roleService.listRoleByUserId(user.getId());
        userDetail.setRoleList(roleList);
        return userDetail;
    }
}
