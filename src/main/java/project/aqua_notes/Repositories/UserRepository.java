package project.aqua_notes.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import project.aqua_notes.Entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long>{

}
