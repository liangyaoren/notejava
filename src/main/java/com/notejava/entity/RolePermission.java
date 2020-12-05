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
public class RolePermission implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 角色与权限关联表
     */
      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 角色表主键
     */
    private Long roleId;

    /**
     * 权限表主键
     */
    private Long permissionId;

    /**
     * 创建时间 
     */
    private LocalDateTime createTime;


}
