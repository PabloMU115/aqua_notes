package project.aqua_notes.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import project.aqua_notes.Entities.CommentEntity;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {

}
