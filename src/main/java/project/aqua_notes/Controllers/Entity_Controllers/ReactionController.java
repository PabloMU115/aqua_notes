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

import project.aqua_notes.Entities.ReactionEntity;
import project.aqua_notes.Models.ReactionDTOs.AddReactionDTO;
import project.aqua_notes.Services.ReactionService;





@RestController
@RequestMapping("/api/reactions")
public class ReactionController {
    private final ReactionService service;

    public ReactionController(ReactionService service) {
        this.service = service;
    }

    @GetMapping("/")
    public ResponseEntity<List<ReactionEntity>> getAll() {
        return ResponseEntity.status(201).body(service.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity<ReactionEntity> add(@RequestBody AddReactionDTO dto) {
        return ResponseEntity.status(201).body(service.add(dto));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ReactionEntity> getMethodName(@PathVariable Long id) {
        return ResponseEntity.status(201).body(service.get(id));
    }
    
    @PutMapping("/modify/{id}/{type}")
    public ResponseEntity<ReactionEntity> modify(@PathVariable Long id, @PathVariable int type) {
        return ResponseEntity.status(201).body(service.modify(id, type));
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Long id){
        return service.delete(id);
    }
}
