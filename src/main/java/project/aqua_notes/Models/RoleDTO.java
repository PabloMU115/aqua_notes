package project.aqua_notes.Models;

public class RoleDTO {
    public Long roleId;
    public String roleType;

    public RoleDTO(Long roleId, String roleType) {
        this.roleId = roleId;
        this.roleType = roleType;
    }

    //#region Setters & Getters
    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }
    //#endregion
    
}
