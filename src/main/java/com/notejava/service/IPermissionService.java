package com.notejava.service;

import com.notejava.bo.PermissionBO;
import com.notejava.entity.Permission;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lyle
 * @since 2020-12-05
 */
public interface IPermissionService extends IService<Permission> {
    List<PermissionBO> listPermissionBO();
}
