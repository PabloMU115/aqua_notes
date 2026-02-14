package project.aqua_notes.Models.UserDTOs;

public class ModifyUserMailDTO implements Cloneable{
    public String userMail;

    //#region Constructor
    public ModifyUserMailDTO(String userMail) {
        this.userMail = userMail;
    }
    //#endregion

    //#region Setters & Getters
    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
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
