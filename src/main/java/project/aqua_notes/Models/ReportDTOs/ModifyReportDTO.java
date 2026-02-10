package project.aqua_notes.Models.ReportDTOs;

public class ModifyReportDTO {
    private int reportType;
    private String reportTown;
    private String reportDescription;

    public int getReportType() {
        return reportType;
    }

    public void setReportType(int reportType) {
        this.reportType = reportType;
    }

    public String getReportTown() {
        return reportTown;
    }

    public void setReportTown(String reportTown) {
        this.reportTown = reportTown;
    }

    public String getReportDescription() {
        return reportDescription;
    }

    public void setReportDescription(String reportDescription) {
        this.reportDescription = reportDescription;
    }

}
