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

        /*
        // NUEVO: Comentarios de compañeros de equipo (peer review)
        @Column(name = "peer_comments", columnDefinition = "TEXT")
        private String peerComments;
*/

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


        public UUID getId() {
            return id;
        }

        public void setId(UUID id) {
            this.id = id;
        }

        public LocalDateTime getWeekStartDate() {
            return weekStartDate;
        }

        public void setWeekStartDate(LocalDateTime weekStartDate) {
            this.weekStartDate = weekStartDate;
        }

        public LocalDateTime getWeekEndDate() {
            return weekEndDate;
        }

        public void setWeekEndDate(LocalDateTime weekEndDate) {
            this.weekEndDate = weekEndDate;
        }

        public Double getHoursWorked() {
            return hoursWorked;
        }

        public void setHoursWorked(Double hoursWorked) {
            this.hoursWorked = hoursWorked;
        }

        public String getAccomplishments() {
            return accomplishments;
        }

        public void setAccomplishments(String accomplishments) {
            this.accomplishments = accomplishments;
        }

        public String getObstacles() {
            return obstacles;
        }

        public void setObstacles(String obstacles) {
            this.obstacles = obstacles;
        }

        public String getNextWeekPlan() {
            return nextWeekPlan;
        }

        public void setNextWeekPlan(String nextWeekPlan) {
            this.nextWeekPlan = nextWeekPlan;
        }

        public String getEvidenceFiles() {
            return evidenceFiles;
        }

        public void setEvidenceFiles(String evidenceFiles) {
            this.evidenceFiles = evidenceFiles;
        }

        /*
        public String getPeerComments() {
            return peerComments;
        }

        public void setPeerComments(String peerComments) {
            this.peerComments = peerComments;
        }


         */
        public ReportStatus getStatus() {
            return status;
        }

        public void setStatus(ReportStatus status) {
            this.status = status;
        }

        public Project getProject() {
            return project;
        }

        public void setProject(Project project) {
            this.project = project;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

        public List<Task> getTasksCompleted() {
            return tasksCompleted;
        }

        public void setTasksCompleted(List<Task> tasksCompleted) {
            this.tasksCompleted = tasksCompleted;
        }
    }
