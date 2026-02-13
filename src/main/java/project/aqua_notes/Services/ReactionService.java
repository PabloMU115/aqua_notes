package project.aqua_notes.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import project.aqua_notes.Entities.ReactionEntity;
import project.aqua_notes.Models.ReactionDTOs.AddReactionDTO;
import project.aqua_notes.Repositories.PostRepository;
import project.aqua_notes.Repositories.ReactionRepository;
import project.aqua_notes.Repositories.UserRepository;

@Service
public class ReactionService {
    private final ReactionRepository repo;
    private final UserRepository userRepo;
    private final PostRepository postRepo;

    public ReactionService(PostRepository postRepo, ReactionRepository repo, UserRepository userRepo) {
        this.postRepo = postRepo;
        this.repo = repo;
        this.userRepo = userRepo;
    }

    public List<ReactionEntity> getAll(){
        return repo.findAll();
    }

    public ReactionEntity getById(Long id){
        return repo.findById(id).orElseThrow();
    }

    public ReactionEntity add(AddReactionDTO dto){
        var user = userRepo.findById(dto.getUserId()).orElseThrow();
        var post = postRepo.findById(dto.getPostId()).orElseThrow();

        ReactionEntity newReaction = new ReactionEntity();

        newReaction.setPost(post);
        newReaction.setUser(user);
        newReaction.setReactionType(dto.getReactionType());

        repo.save(newReaction);

        return newReaction;
    }

    public ReactionEntity modify(Long id, int type){
        var reaction = getById(id);

        reaction.setReactionType(type);

        repo.save(reaction);

        return reaction;
    }

    public boolean delete(Long id){
        var item = repo.findById(id);

        if(item.isEmpty()){
            return false;
        }

        repo.deleteById(id);

        return true;
    }

    // Might be useful later...
    // public Optional<ReactionEntity> findExistingReaction(Long userId, Long postId){
    //     return getAll().stream().filter(x -> x.getUser().getUserId().equals(userId) &&
    //     x.getPost().getPostId().equals(postId)).findFirst();
    // }

}
