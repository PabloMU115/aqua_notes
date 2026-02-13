package project.aqua_notes.Services;

import org.springframework.stereotype.Service;

import project.aqua_notes.Repositories.NotificationRepository;

@Service
public class NotificationService {

    private final NotificationRepository repo;

    public NotificationService(NotificationRepository repo) {
        this.repo = repo;
    }
}
