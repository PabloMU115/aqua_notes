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

import project.aqua_notes.Entities.NotificationEntity;
import project.aqua_notes.Models.NotificationDTOs.AddNotificationDTO;
import project.aqua_notes.Services.NotificationService;



@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    private final NotificationService service;

    public NotificationController(NotificationService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<NotificationEntity>> getAllFiltered(@PathVariable Long id) {        
        return ResponseEntity.status(201).body(service.getAllFiltered(id));
    }

    @PutMapping("/check/{id}")
    public ResponseEntity<NotificationEntity> setChecked(@PathVariable Long id) {        
        return ResponseEntity.status(201).body(service.setChecked(id));
    }

    @PostMapping("/add")
    public ResponseEntity<NotificationEntity> add(@RequestBody AddNotificationDTO dto) {        
        return ResponseEntity.status(201).body(service.add(dto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id){
        return ResponseEntity.status(201).body(service.delete(id));
    }

    @DeleteMapping("/delete/all/{id}")
    public ResponseEntity<Boolean> deleteAll(@PathVariable Long id){
        return ResponseEntity.status(201).body(service.deleteAll(id));
    }

    @DeleteMapping("/delete/checked/{id}")
    public ResponseEntity<Boolean> deleteAllChecked(@PathVariable Long id){
        return ResponseEntity.status(201).body(service.deleteAllChecked(id));
    }
}
