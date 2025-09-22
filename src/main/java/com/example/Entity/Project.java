package com.example.Entity;

import com.example.Entity.enums.ProjectStatus;
import com.example.Entity.enums.ProjectType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "projects")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Project {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid", updatable = false)
    private UUID id;

    @Column(nullable = false)
    @NotBlank(message = "Nombre del proyecto es requerido")
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ProjectType type;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ProjectStatus status = ProjectStatus.PLANNING;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @Column(name = "repository_url")
    private String repositoryUrl;

    // Settings del proyecto
    @Column(name = "require_weekly_reports")
    private Boolean requireWeeklyReports = true;

    @Column(name = "enable_peer_evaluation")
    private Boolean enablePeerEvaluation = true;

    @Column(name = "auto_github_sync")
    private Boolean autoGithubSync = false;



    // NUEVO: Creado por un estudiante (líder del proyecto)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private User createdBy;

    // Relaciones
    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private List<TeamMember> teamMembers;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private List<Task> tasks;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private List<Milestone> milestones;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private List<WeeklyReport> weeklyReports;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private List<Meeting> meetings;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProjectType getType() {
        return type;
    }

    public void setType(ProjectType type) {
        this.type = type;
    }

    public ProjectStatus getStatus() {
        return status;
    }

    public void setStatus(ProjectStatus status) {
        this.status = status;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public String getRepositoryUrl() {
        return repositoryUrl;
    }

    public void setRepositoryUrl(String repositoryUrl) {
        this.repositoryUrl = repositoryUrl;
    }

    public Boolean getRequireWeeklyReports() {
        return requireWeeklyReports;
    }

    public void setRequireWeeklyReports(Boolean requireWeeklyReports) {
        this.requireWeeklyReports = requireWeeklyReports;
    }

    public Boolean getEnablePeerEvaluation() {
        return enablePeerEvaluation;
    }

    public void setEnablePeerEvaluation(Boolean enablePeerEvaluation) {
        this.enablePeerEvaluation = enablePeerEvaluation;
    }

    public Boolean getAutoGithubSync() {
        return autoGithubSync;
    }

    public void setAutoGithubSync(Boolean autoGithubSync) {
        this.autoGithubSync = autoGithubSync;
    }


    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public List<TeamMember> getTeamMembers() {
        return teamMembers;
    }

    public void setTeamMembers(List<TeamMember> teamMembers) {
        this.teamMembers = teamMembers;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public List<Milestone> getMilestones() {
        return milestones;
    }

    public void setMilestones(List<Milestone> milestones) {
        this.milestones = milestones;
    }

    public List<WeeklyReport> getWeeklyReports() {
        return weeklyReports;
    }

    public void setWeeklyReports(List<WeeklyReport> weeklyReports) {
        this.weeklyReports = weeklyReports;
    }

    public List<Meeting> getMeetings() {
        return meetings;
    }

    public void setMeetings(List<Meeting> meetings) {
        this.meetings = meetings;
    }
}
