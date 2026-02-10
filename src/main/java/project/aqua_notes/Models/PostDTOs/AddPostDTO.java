package project.aqua_notes.Models.PostDTOs;

import project.aqua_notes.Entities.ReportEntity;

public class AddPostDTO {
    private ReportEntity report;

    public ReportEntity getReport() {
        return report;
    }

    public void setReport(ReportEntity report) {
        this.report = report;
    }    
}
