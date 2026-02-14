package project.aqua_notes.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import project.aqua_notes.Entities.NotificationEntity;
import project.aqua_notes.Models.NotificationDTOs.AddNotificationDTO;
import project.aqua_notes.Repositories.NotificationRepository;
import project.aqua_notes.Repositories.PostRepository;
import project.aqua_notes.Repositories.UserRepository;

@Service
public class NotificationService {

    private final NotificationRepository repo;
    private final UserRepository userRepo;
    private final PostRepository postRepo;

    public NotificationService(PostRepository postRepo, NotificationRepository repo, UserRepository userRepo) {
        this.postRepo = postRepo;
        this.repo = repo;
        this.userRepo = userRepo;
    }

    public List<NotificationEntity> getAllFiltered(Long id){
        var list = repo.findAll().stream().filter(x -> x.getUser().getUserId().equals(id)).toList();

        if(list.isEmpty()){
            return new ArrayList<>();
        }

        return list;
    }

    public NotificationEntity add(AddNotificationDTO dto){
        var user = userRepo.findById(dto.getUserId()).orElseThrow();
        var post = postRepo.findById(dto.getPostId()).orElseThrow();

        NotificationEntity newNotification = new NotificationEntity();

        newNotification.setUser(user);
        newNotification.setTitle(dto.getTitle());
        newNotification.setNotifType(dto.getNotifType());
        newNotification.setPost(post);

        return repo.save(newNotification);
    }

    public NotificationEntity setChecked(Long id){
        var notif = repo.findById(id).orElseThrow();

        notif.setChecked(true);

        return repo.save(notif);
    } 

    public Boolean delete(Long id){
        var notif = repo.findById(id);

        if(notif.isPresent()){
            repo.delete(notif.orElseThrow());
            return true;
        }

        return false;
    }

    public Boolean deleteAll(Long id){
        var notifications = getAllFiltered(id);

        if(notifications.isEmpty()){
            return false;
        }

        repo.deleteAllInBatch(notifications);

        return true;
    }

    public Boolean deleteAllChecked(Long id){
        var notifications = getAllFiltered(id).stream().filter(x -> x.isChecked()).toList();

        if(notifications.isEmpty()){
            return false;
        }

        repo.deleteAllInBatch(notifications);

        return true;
    }
}
