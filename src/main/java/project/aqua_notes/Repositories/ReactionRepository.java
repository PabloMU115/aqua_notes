package project.aqua_notes.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.aqua_notes.Entities.ReactionEntity;

@Repository
public interface ReactionRepository extends JpaRepository<ReactionEntity, Long>{

}
