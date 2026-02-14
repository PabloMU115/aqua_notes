package project.aqua_notes.Controllers.Entity_Controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.aqua_notes.Entities.ReportEntity;
import project.aqua_notes.Models.ReportDTOs.AddReportDTO;
import project.aqua_notes.Models.ReportDTOs.ModifyReportDTO;
import project.aqua_notes.Services.ReportService;




@RestController
@RequestMapping("/api/reports")
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService){
        this.reportService = reportService;
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/")
    public ResponseEntity<List<ReportEntity>> getAll() {
        return ResponseEntity.status(201).body(reportService.getAll());
    }

    @PreAuthorize("hasAuthority('ROLE_USER') or hasAuthority('ROLE_ADMIN')")
    @PostMapping("/add")
    public ResponseEntity<ReportEntity> add(@RequestBody AddReportDTO report){
        ReportEntity saved = reportService.add(report);
        return ResponseEntity.status(201).body(saved);
    }

    @PutMapping("/modify/{id}")
    public ResponseEntity<ReportEntity> modify(@PathVariable Long id, @RequestBody ModifyReportDTO dto) {
        ReportEntity report = reportService.modify(id, dto);
        return ResponseEntity.status(201).body(report);
    }

    @PutMapping("/changeActivity/{id}")
    public ResponseEntity<ReportEntity> changeActivity(@PathVariable Long id) {
        ReportEntity report = reportService.changeActivity(id);
        return ResponseEntity.status(201).body(report);
    }
    
    @PutMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        return ResponseEntity.ok(reportService.delete(id));
    }
}
