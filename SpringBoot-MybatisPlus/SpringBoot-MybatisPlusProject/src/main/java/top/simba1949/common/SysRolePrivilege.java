package top.simba1949.common;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 角色权限关联表
 * </p>
 *
 * @author simba@onlying.cn
 * @since 2018-10-20
 */
public class SysRolePrivilege extends Model<SysRolePrivilege> {

    private static final long serialVersionUID = 1L;

    /**
     * 角色ID
     */
    private Long roleId;

    /**
     * 权限ID
     */
    private Long privilegeId;


    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getPrivilegeId() {
        return privilegeId;
    }

    public void setPrivilegeId(Long privilegeId) {
        this.privilegeId = privilegeId;
    }

    @Override
    protected Serializable pkVal() {
        return null;
    }

    @Override
    public String toString() {
        return "SysRolePrivilege{" +
        "roleId=" + roleId +
        ", privilegeId=" + privilegeId +
        "}";
    }
}
