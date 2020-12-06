package com.notejava.jwt;


import com.notejava.bo.PermissionBO;
import com.notejava.cache.Cache;
import com.notejava.constant.CacheName;
import com.notejava.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class InitProcessor {

    @Autowired
    private IPermissionService permissionService;
    @Autowired
    private Cache caffeineCache;

    @PostConstruct
    public void init() {
        List<PermissionBO> permissionInfoList = permissionService.listPermissionBO();
        permissionInfoList.forEach(permissionInfo -> {
            caffeineCache.put(CacheName.PERMISSION, permissionInfo.getPermissionUri() + ":" + permissionInfo.getPermissionMethod(), permissionInfo);
        });
    }
}
