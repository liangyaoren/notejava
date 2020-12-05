package com.notejava.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.notejava.entity.Role;
import com.notejava.mapper.RoleMapper;
import com.notejava.service.IRoleService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author lyle
 * @since 2020-12-05
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {
    @Override
    public List<Role> listRoleByUserId(Integer userId) {
        if (userId == null) {
            return null;
        }
        return getBaseMapper().listRoleByUserId(userId);
    }
}
