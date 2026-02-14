package project.aqua_notes.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import project.aqua_notes.Entities.UserEntity;
import project.aqua_notes.Models.UserDTOs.EndUserRegistrationDTO;
import project.aqua_notes.Models.UserDTOs.ModifyUserDTO;
import project.aqua_notes.Models.UserDTOs.ModifyUserMailDTO;
import project.aqua_notes.Models.UserDTOs.ModifyUserPasswordDTO;
import project.aqua_notes.Repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private final UserRepository userRepo;

    public PasswordEncoder encoder = new BCryptPasswordEncoder();

    public UserService(UserRepository userRepo)
    {
        this.userRepo = userRepo;
    }

    public UserEntity addUser(EndUserRegistrationDTO user) {
        UserEntity newUser = new UserEntity();

        newUser.setUserCity(user.getUserCity());
        newUser.setUserCountry(user.getUserCountry());
        newUser.setUserPhone(user.getUserPhone());
        newUser.setUserName(user.getUserName());
        newUser.setUserProvince(user.getUserProvince());

        userRepo.save(newUser);

        return newUser;
    }

    public UserEntity getUserById(Long id) {
        return userRepo.findById(id)
            .orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found")
            );
    }

    public List<UserEntity> getAllUsers() {
        return userRepo.findAll();
    }

    public UserEntity modifyUserInfo(ModifyUserDTO user, long id){
        var oldUser = userRepo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        oldUser.setUserCity(user.getUserCity());
        oldUser.setUserCountry(user.getUserCountry());
        oldUser.setUserPhone(user.getUserPhone());
        oldUser.setUserName(user.getUserName());
        oldUser.setUserProvince(user.getUserProvince());

        userRepo.save(oldUser);
        return oldUser;
    }

    public UserEntity modifyUserMail(ModifyUserMailDTO user, long id){
        var oldUser = userRepo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        oldUser.setUserMail(user.getUserMail());

        userRepo.save(oldUser);
        return oldUser;
    }

    public UserEntity modifyUserPassword(ModifyUserPasswordDTO user, long id){
        var oldUser = userRepo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        oldUser.setPasswordHash(encoder.encode(user.getUserPassword()));

        userRepo.save(oldUser);
        return oldUser;
    }

    public boolean deleteUser(Long id){
        userRepo.deleteById(id);
        return false;
    }
}