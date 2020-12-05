package com.notejava.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author lyle
 * @since 2020-12-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Permission implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 权限表主键
     */
      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 权限名称
     */
    private String permissionName;

    /**
     * 权限URI
     */
    private String permissionUri;

    /**
     * 权限方法类型
     */
    private String permissionMethod;

    /**
     * 逻辑删除
     */
    private Integer activeStatus;

    /**
     * 权限创建时间
     */
    private LocalDateTime createTime;


}
