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

    @Query("SELECT wr FROM WeeklyReport wr WHERE wr.project = :project AND wr.weekStartDate >= :startDate AND wr.weekEndDate <= :endDate")
    List<WeeklyReport> findByProjectAndDateRange(@Param("project") Project project,
                                                 @Param("startDate") LocalDateTime startDate,
                                                 @Param("endDate") LocalDateTime endDate);

    @Query("SELECT wr FROM WeeklyReport wr WHERE wr.user = :user AND wr.weekStartDate = :weekStart")
    Optional<WeeklyReport> findByUserAndWeekStart(@Param("user") User user, @Param("weekStart") LocalDateTime weekStart);

    @Query("SELECT SUM(wr.hoursWorked) FROM WeeklyReport wr WHERE wr.user = :user AND wr.project = :project")
    Double getTotalHoursByUserAndProject(@Param("user") User user, @Param("project") Project project);

    @Query("SELECT COUNT(wr) FROM WeeklyReport wr WHERE wr.project = :project AND wr.status = 'PENDING'")
    long countPendingReportsByProject(@Param("project") Project project);
}
