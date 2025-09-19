package com.example.Repository;


import com.example.Entity.Milestone;
import com.example.Entity.Project;
import com.example.Entity.enums.MilestoneStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface MilestoneRepository extends JpaRepository<Milestone, UUID> {

    List<Milestone> findByProject(Project project);

    List<Milestone> findByProjectAndStatus(Project project, MilestoneStatus status);

    List<Milestone> findByProjectOrderByDueDateAsc(Project project);

    @Query("SELECT m FROM Milestone m WHERE m.dueDate < :currentDate AND m.status != 'COMPLETED'")
    List<Milestone> findOverdueMilestones(@Param("currentDate") LocalDateTime currentDate);

    @Query("SELECT COUNT(m) FROM Milestone m WHERE m.project = :project AND m.status = 'COMPLETED'")
    long countCompletedMilestonesByProject(@Param("project") Project project);

    @Query("SELECT m FROM Milestone m WHERE m.project = :project AND m.dueDate <= :date ORDER BY m.dueDate ASC")
    List<Milestone> findUpcomingMilestones(@Param("project") Project project, @Param("date") LocalDateTime date);
}
