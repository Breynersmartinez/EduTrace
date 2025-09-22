package com.example.Service;

import com.example.Entity.WeeklyReport;
import com.example.Entity.Project;
import com.example.Entity.User;
import com.example.Entity.enums.ReportStatus;
import com.example.Repository.WeeklyReportRepository;
import com.example.Repository.ProjectRepository;
import com.example.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class WeeklyReportService {

    @Autowired
    private WeeklyReportRepository weeklyReportRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private UserRepository userRepository;

    public List<WeeklyReport> getReportsByProject(UUID projectId) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Proyecto no encontrado"));
        return weeklyReportRepository.findByProject(project);
    }

    public List<WeeklyReport> getReportsByUser(Integer userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        return weeklyReportRepository.findByUser(user);
    }

    public Optional<WeeklyReport> getReportByUserAndWeek(Integer userId, LocalDateTime weekStart) {
        return weeklyReportRepository.findByUserAndWeek(userId, weekStart);
    }

    public WeeklyReport createOrUpdateReport(WeeklyReport report) {
        Optional<WeeklyReport> existing = weeklyReportRepository.findByUserAndWeek(
                report.getUser().getIdCard(), report.getWeekStartDate());

        if (existing.isPresent()) {
            WeeklyReport existingReport = existing.get();
            existingReport.setHoursWorked(report.getHoursWorked());
            existingReport.setAccomplishments(report.getAccomplishments());
            existingReport.setObstacles(report.getObstacles());
            existingReport.setNextWeekPlan(report.getNextWeekPlan());
            existingReport.setEvidenceFiles(report.getEvidenceFiles());
            return weeklyReportRepository.save(existingReport);
        }

        report.setStatus(ReportStatus.DRAFT);
        return weeklyReportRepository.save(report);
    }

    public WeeklyReport submitReport(UUID reportId) {
        return weeklyReportRepository.findById(reportId)
                .map(report -> {
                    report.setStatus(ReportStatus.SUBMITTED);
                    return weeklyReportRepository.save(report);
                })
                .orElseThrow(() -> new RuntimeException("Reporte no encontrado"));
    }

    public WeeklyReport reviewReport(UUID reportId, String feedback, ReportStatus status) {
        return weeklyReportRepository.findById(reportId)
                .map(report -> {
                    report.setStatus(status);
                    return weeklyReportRepository.save(report);
                })
                .orElseThrow(() -> new RuntimeException("Reporte no encontrado"));
    }
}
