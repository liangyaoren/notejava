package com.notejava.controller;


import com.notejava.bo.ApiResult;
import com.notejava.cache.Cache;
import com.notejava.constant.CacheName;
import com.notejava.entity.User;
import com.notejava.entity.UserDetail;
import com.notejava.jwt.AccessToken;
import com.notejava.jwt.JwtProvider;
import com.notejava.service.IUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author lyle
 * @since 2020-11-30
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    private IUserService userService;

    @Autowired
    private Cache caffeineCache;

    @GetMapping("/get")
    public User get(String id) {
        User user = userService.getById(id);
        return user;
    }

    @PostMapping("/register")
    public ApiResult register(User user) {
        if (StringUtils.isBlank(user.getUsername())) {
            return ApiResult.fail("用户名不能为空");
        }
        userService.register(user);
        return ApiResult.ok();
    }


    @PostMapping("/login")
    public AccessToken login(User user) {
        // 1 创建UsernamePasswordAuthenticationToken
        UsernamePasswordAuthenticationToken usernameAuthentication = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
        // 2 认证
        Authentication authentication = this.authenticationManager.authenticate(usernameAuthentication);
        // 3 保存认证信息
        SecurityContextHolder.getContext().setAuthentication(authentication);
        // 4 生成自定义token
        AccessToken accessToken = jwtProvider.createToken((UserDetails) authentication.getPrincipal());

        UserDetail userDetail = (UserDetail) authentication.getPrincipal();
        // 放入缓存
        caffeineCache.put(CacheName.USER, userDetail.getUsername(), userDetail);
        return accessToken;
    }
}

