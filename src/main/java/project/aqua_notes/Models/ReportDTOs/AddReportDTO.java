package project.aqua_notes.Models.ReportDTOs;

public class AddReportDTO {
    private int reportType;
    private String reportTown;
    private String reportDescription;
    private String coordinates;
    private Long userId;

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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }


}
