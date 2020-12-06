package com.notejava.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.notejava.bo.PermissionBO;
import com.notejava.entity.Permission;
import com.notejava.mapper.PermissionMapper;
import com.notejava.service.IPermissionService;
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
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements IPermissionService {

    @Override
    public List<PermissionBO> listPermissionBO() {
        return baseMapper.listPermissionBO();
    }
}
