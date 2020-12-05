package com.notejava.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.notejava.entity.Role;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author lyle
 * @since 2020-12-05
 */
public interface IRoleService extends IService<Role> {
    List<Role> listRoleByUserId(Integer userId);
}
