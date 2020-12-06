package com.notejava.mapper;

import com.notejava.bo.PermissionBO;
import com.notejava.entity.Permission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lyle
 * @since 2020-12-05
 */
public interface PermissionMapper extends BaseMapper<Permission> {
    List<PermissionBO> listPermissionBO();
}
