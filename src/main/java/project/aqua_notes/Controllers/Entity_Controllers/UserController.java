package project.aqua_notes.Controllers.Entity_Controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.aqua_notes.Entities.UserEntity;
import project.aqua_notes.Models.UserDTOs.CreateUserDTO;
import project.aqua_notes.Models.UserDTOs.ModifyUserDTO;
import project.aqua_notes.Models.UserDTOs.ModifyUserMailDTO;
import project.aqua_notes.Models.UserDTOs.ModifyUserPasswordDTO;
import project.aqua_notes.Services.UserService;



@RestController
@RequestMapping("/api/users")
public class UserController {
    
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/add")
    public ResponseEntity<UserEntity> add(@RequestBody CreateUserDTO entity) {
        UserEntity saved = userService.addUser(entity);
        return ResponseEntity.status(201).body(saved);
    }
    
    @GetMapping("/getById/{id}")
    public ResponseEntity<UserEntity> getById(@PathVariable Long id) {
        UserEntity user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/")
    public ResponseEntity<List<UserEntity>> getById() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PutMapping("/modifyInfo/{id}")
    public ResponseEntity<UserEntity> modify(@PathVariable Long id, @RequestBody ModifyUserDTO entity) {
        return ResponseEntity.ok(userService.modifyUserInfo(entity, id));
    }
    
    @PutMapping("/modifyMail/{id}")
    public ResponseEntity<UserEntity> modifyMail(@PathVariable Long id, @RequestBody ModifyUserMailDTO entity) {
        return ResponseEntity.ok(userService.modifyUserMail(entity, id));
    }

    @PutMapping("/modifyPassword/{id}")
    public ResponseEntity<UserEntity> modifyPassword(@PathVariable Long id, @RequestBody ModifyUserPasswordDTO entity) {
        return ResponseEntity.ok(userService.modifyUserPassword(entity, id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        return ResponseEntity.ok(userService.deleteUser(id));
    }
}
