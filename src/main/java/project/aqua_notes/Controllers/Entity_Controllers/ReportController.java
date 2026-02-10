package project.aqua_notes.Controllers.Entity_Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.aqua_notes.Entities.ReportEntity;
import project.aqua_notes.Models.ReportDTOs.AddReportDTO;
import project.aqua_notes.Services.ReportService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/reports")
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService){
        this.reportService = reportService;
    }

    @PostMapping("/add")
    public ResponseEntity<ReportEntity> add(@RequestBody AddReportDTO report){
        ReportEntity saved = reportService.add(report);
        return ResponseEntity.status(201).body(saved);
    }
}
