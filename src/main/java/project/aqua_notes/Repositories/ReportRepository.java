package project.aqua_notes.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.aqua_notes.Entities.ReportEntity;

@Repository
public interface ReportRepository extends JpaRepository<ReportEntity, Long> {
    
}
