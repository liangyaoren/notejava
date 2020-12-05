package com.notejava.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.notejava.entity.Role;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author lyle
 * @since 2020-12-05
 */
public interface RoleMapper extends BaseMapper<Role> {
    List<Role> listRoleByUserId(Integer userId);
}
