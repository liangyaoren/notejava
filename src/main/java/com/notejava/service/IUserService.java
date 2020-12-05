package com.notejava.service;

import com.notejava.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lyle
 * @since 2020-12-03
 */
public interface IUserService extends IService<User> {

    void register(User user);
}
