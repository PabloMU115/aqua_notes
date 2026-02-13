package project.aqua_notes.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.aqua_notes.Entities.NotificationEntity;

@Repository
public interface NotificationRepository extends JpaRepository<NotificationEntity, Long>{

}
