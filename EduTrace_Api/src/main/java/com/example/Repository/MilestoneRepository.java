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


}
