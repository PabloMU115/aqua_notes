package project.aqua_notes.Controllers.Entity_Controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.aqua_notes.Entities.CommentEntity;
import project.aqua_notes.Models.CommentDTOs.AddCommentDTO;
import project.aqua_notes.Models.CommentDTOs.ModifyCommentDTO;
import project.aqua_notes.Services.CommentService;



@RestController
@RequestMapping("/api/comments")
public class CommentController {

    private final CommentService service;

    public CommentController(CommentService service) {
        this.service = service;
    }

    @GetMapping("/")
    public ResponseEntity<List<CommentEntity>> getAll() {
        return ResponseEntity.status(201).body(service.getAll());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<CommentEntity> getAll(@PathVariable Long id) {
        return ResponseEntity.status(201).body(service.getById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<CommentEntity> add(@RequestBody AddCommentDTO dto) {
        return ResponseEntity.status(201).body(service.add(dto));
    }

    @PutMapping("/modify/{id}")
    public ResponseEntity<CommentEntity> modify(@PathVariable Long id, @RequestBody ModifyCommentDTO content){
        return ResponseEntity.status(201).body(service.modify(id, content));
    }

    @PutMapping("/delete/{id}")
    public ResponseEntity<CommentEntity> delete(@PathVariable Long id) {
        return ResponseEntity.status(201).body(service.delete(id));
    }
}
