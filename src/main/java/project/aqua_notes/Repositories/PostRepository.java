package project.aqua_notes.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.aqua_notes.Entities.PostEntity;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long>{

}
