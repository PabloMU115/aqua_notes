package project.aqua_notes.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import project.aqua_notes.Entities.PostEntity;
import project.aqua_notes.Entities.ReportEntity;
import project.aqua_notes.Entities.UserEntity;
import project.aqua_notes.Models.ReportDTOs.AddReportDTO;
import project.aqua_notes.Repositories.PostRepository;
import project.aqua_notes.Repositories.ReportRepository;
import project.aqua_notes.Repositories.UserRepository;

@Service
public class ReportService {
    private final ReportRepository repo;
    private final UserRepository userRepo;
    private final PostRepository postRepo;

    public ReportService(ReportRepository repo, UserRepository userRepo, PostRepository postRepo){
        this.repo = repo;
        this.userRepo = userRepo;
        this.postRepo = postRepo;
    }

    public List<ReportEntity> getAll(){
        return repo.findAll();
    }

    public ReportEntity add(AddReportDTO incomingReport){
        ReportEntity newReport = new ReportEntity();
        UserEntity newUser = userRepo.findById(incomingReport.getUserId()).orElseThrow();
        PostEntity newPost = new PostEntity();

        newReport.setReportType(incomingReport.getReportType());
        newReport.setReportTown(incomingReport.getReportTown());
        newReport.setReportDescription(incomingReport.getReportDescription());
        newReport.setUser(newUser);

        newPost.setReport(newReport);

        repo.save(newReport);
        postRepo.save(newPost);
        return newReport;
    }
}
