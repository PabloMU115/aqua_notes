package project.aqua_notes.Services;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import project.aqua_notes.Entities.AnonUserEntity;
import project.aqua_notes.Entities.PostEntity;
import project.aqua_notes.Entities.ReportEntity;
import project.aqua_notes.Entities.UserEntity;
import project.aqua_notes.Models.ReportDTOs.AddReportDTO;
import project.aqua_notes.Models.ReportDTOs.ModifyReportDTO;
import project.aqua_notes.Repositories.AnonUserRepository;
import project.aqua_notes.Repositories.PostRepository;
import project.aqua_notes.Repositories.ReportRepository;
import project.aqua_notes.Repositories.UserRepository;

@Service
public class ReportService {
    private final ReportRepository repo;
    private final UserRepository userRepo;
    private final PostRepository postRepo;
    private final AnonUserRepository anonRepo;

    public ReportService(AnonUserRepository anonRepo, PostRepository postRepo, ReportRepository repo, UserRepository userRepo) {
        this.anonRepo = anonRepo;
        this.postRepo = postRepo;
        this.repo = repo;
        this.userRepo = userRepo;
    }

    public List<ReportEntity> getAll(){
        return repo.findAll();
    }

    public ReportEntity getById(Long id){
        return repo.findById(id).orElseThrow();
    }

    public ResponseEntity<Void> add(AddReportDTO incomingReport){
        ReportEntity newReport = new ReportEntity();
        PostEntity newPost = new PostEntity();

        newReport.setReportType(incomingReport.getReportType());
        newReport.setReportTown(incomingReport.getReportTown());
        newReport.setReportDescription(incomingReport.getReportDescription());
        newReport.setCoordinates(incomingReport.getCoordinates());
        
        if (incomingReport.getUserId() != null) {
            UserEntity newUser = userRepo.findById(incomingReport.getUserId()).orElseThrow();
            newReport.setUser(newUser);
        }
        else{
            AnonUserEntity newAnon = new AnonUserEntity();
            newAnon.setAnonUserId(incomingReport.getAnonUserId());
            newAnon.setName(incomingReport.getAnonUserName());
            newReport.setAnonUser(newAnon);
            anonRepo.save(newAnon);
        }

        newPost.setReport(newReport);

        repo.save(newReport);
        postRepo.save(newPost);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    public ReportEntity modify(Long id, ModifyReportDTO dto){
        ReportEntity report = getById(id);

        report.setReportTown(dto.getReportTown());
        report.setReportType(dto.getReportType());
        report.setReportDescription(dto.getReportDescription());
        report.setCoordinates(dto.getCoordinates());

        repo.save(report);

        return report;
    }

    public ReportEntity changeActivity(Long id){
        ReportEntity report = repo.findById(id).orElseThrow();
        if(report.isActive()){
            report.setActive(false);
        }else{
            report.setActive(true);
        }
        repo.save(report);
        return report;
    }

    public boolean delete(Long id){
        ReportEntity report = repo.findById(id).orElseThrow();
        report.setVisible(false);
        repo.save(report);
        return false;
    }
}
