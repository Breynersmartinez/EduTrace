package com.example.Entity;

import com.example.Entity.enums.ReportStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


    @Entity
    @Table(name = "weekly_reports")
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @EntityListeners(AuditingEntityListener.class)
    public class WeeklyReport {

        @Id
        @GeneratedValue
        @Column(columnDefinition = "uuid", updatable = false)
        private UUID id;

        @Column(name = "week_start_date", nullable = false)
        private LocalDateTime weekStartDate;

        @Column(name = "week_end_date", nullable = false)
        private LocalDateTime weekEndDate;

        @Column(name = "hours_worked")
        private Double hoursWorked;

        @Column(columnDefinition = "TEXT")
        private String accomplishments;

        @Column(columnDefinition = "TEXT")
        private String obstacles;

        @Column(name = "next_week_plan", columnDefinition = "TEXT")
        private String nextWeekPlan;

        @Column(name = "evidence_files")
        private String evidenceFiles; // URLs separadas por comas

        @Enumerated(EnumType.STRING)
        @Column(nullable = false)
        private ReportStatus status = ReportStatus.DRAFT;

        @Column(name = "professor_feedback", columnDefinition = "TEXT")
        private String professorFeedback;


        // Relaciones
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "project_id", nullable = false)
        private Project project;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "user_id", nullable = false)
        private User user;

        @ManyToMany
        @JoinTable(
                name = "report_completed_tasks",
                joinColumns = @JoinColumn(name = "report_id"),
                inverseJoinColumns = @JoinColumn(name = "task_id")
        )
        private List<Task> tasksCompleted;
    }


