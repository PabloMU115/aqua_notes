package project.aqua_notes.Models.UserDTOs;

public class EndUserRegistrationDTO implements Cloneable{
    public String userName, userCountry, 
    userProvince, userCity, userPhone;

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
    public EndUserRegistrationDTO clone(){
        try{
            return (EndUserRegistrationDTO) super.clone();
        }
        catch(CloneNotSupportedException error){
            throw new AssertionError();
        }
    }
}
