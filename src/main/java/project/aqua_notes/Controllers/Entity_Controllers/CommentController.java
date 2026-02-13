package project.aqua_notes.Controllers.Entity_Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.aqua_notes.Entities.CommentEntity;
import project.aqua_notes.Models.CommentDTOs.AddCommentDTO;
import project.aqua_notes.Services.CommentService;


@RestController
@RequestMapping("/api/comments")
public class CommentController {

    private final CommentService service;

    public CommentController(CommentService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public ResponseEntity<CommentEntity> add(@RequestBody AddCommentDTO dto) {
        return ResponseEntity.status(201).body(service.add(dto));
    }

}
