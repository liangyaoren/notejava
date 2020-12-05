package com.notejava.bo;

import lombok.Data;

/**
 * <p>
 *
 * </p>
 *
 * @author lyle
 * @since 2020-07-05 19:05
 */
@Data
public class PermissionInfoBO {

    private String id;

    private String permissionName;

    private String permissionUri;

    private String permissionMethod;

    private String roleName;

    private String roleCode;
}
