package project.aqua_notes.Models.UserDTOs;

public class CreateUserDTO implements Cloneable{
    public String userName, userMail, userCountry, 
    userProvince, userCity, userPhone, passwordHash;
    public Long roleId;

    //#region Constructor
    public CreateUserDTO(String userName, String userMail, String userCountry, String userProvince,
            String userCity, String userPhone, String passwordHash, Long roleId) {
        this.userName = userName;
        this.userMail = userMail;
        this.userCountry = userCountry;
        this.userProvince = userProvince;
        this.userCity = userCity;
        this.userPhone = userPhone;
        this.passwordHash = passwordHash;
        this.roleId = roleId;
    }
    //#endregion

    //#region Setters & Getters

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public String getUserCountry() {
        return userCountry;
    }

    public void setUserCountry(String userCountry) {
        this.userCountry = userCountry;
    }

    public String getUserProvince() {
        return userProvince;
    }

    public void setUserProvince(String userProvince) {
        this.userProvince = userProvince;
    }

    public String getUserCity() {
        return userCity;
    }

    public void setUserCity(String userCity) {
        this.userCity = userCity;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
    //#endregion
    
    @Override
    public CreateUserDTO clone(){
        try{
            return (CreateUserDTO) super.clone();
        }
        catch(CloneNotSupportedException error){
            throw new AssertionError();
        }
    }
}
