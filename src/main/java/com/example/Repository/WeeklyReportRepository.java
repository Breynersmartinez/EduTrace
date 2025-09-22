package com.example.Repository;

import com.example.Entity.WeeklyReport;
import com.example.Entity.Project;
import com.example.Entity.User;
import com.example.Entity.enums.ReportStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface WeeklyReportRepository extends JpaRepository<WeeklyReport, UUID> {

    List<WeeklyReport> findByProject(Project project);

    List<WeeklyReport> findByUser(User user);

    List<WeeklyReport> findByProjectAndUser(Project project, User user);

    List<WeeklyReport> findByStatus(ReportStatus status);


}
