package project.aqua_notes.Models.UserDTOs;

public class ModifyUserPasswordDTO implements Cloneable{
    public String userPassword;

    //#region Constructor
    public ModifyUserPasswordDTO(String userPassword) {
        this.userPassword = userPassword;
    }
    //#endregion

    //#region Setters & Getters
    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
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
