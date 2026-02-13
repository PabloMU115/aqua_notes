package project.aqua_notes.Services;

import java.util.List;

import project.aqua_notes.Entities.CommentEntity;
import project.aqua_notes.Models.CommentDTOs.AddEntityDTO;
import project.aqua_notes.Repositories.CommentRepository;
import project.aqua_notes.Repositories.PostRepository;
import project.aqua_notes.Repositories.UserRepository;

public class CommentService {

    private final CommentRepository repo;
    private final UserRepository userRepo;
    private final PostRepository postRepo;

    public CommentService(PostRepository postRepo, CommentRepository repo, UserRepository userRepo) {
        this.postRepo = postRepo;
        this.repo = repo;
        this.userRepo = userRepo;
    }

    public List<CommentEntity> getAll(){
        return repo.findAll();
    }

    public CommentEntity getById(Long id){
        return repo.findById(id).orElseThrow();
    }

    public CommentEntity add(AddEntityDTO dto){
        var user = userRepo.findById(dto.getUserId()).orElseThrow();
        var post = postRepo.findById(dto.getPostId()).orElseThrow();

        CommentEntity newComment = new CommentEntity();

        newComment.setUser(user);
        newComment.setPost(post);
        newComment.setContent(dto.getContent());

        repo.save(newComment);

        return newComment;
    }

    public CommentEntity modify(Long id, String content){
        var comment = getById(id);

        comment.setContent(content);

        repo.save(comment);

        return comment;
    }


}
