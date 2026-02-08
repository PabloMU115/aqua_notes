package project.aqua_notes.Models.UserDTOs;

public class ModifyUserDTO implements Cloneable{
    public String userName, userCountry, 
    userProvince, userCity, userPhone;

    //#region Constructor
    public ModifyUserDTO(String userName, String userMail, String userCountry, String userProvince,
            String userCity, String userPhone, String passwordHash, Long roleId, Boolean verified) {
        this.userName = userName;
        this.userCountry = userCountry;
        this.userProvince = userProvince;
        this.userCity = userCity;
        this.userPhone = userPhone;
    }
    //#endregion

    //#region Setters & Getters
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
