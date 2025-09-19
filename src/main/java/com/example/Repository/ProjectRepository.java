package com.example.Repository;

import com.example.Entity.Project;
import com.example.Entity.enums.ProjectStatus;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface ProjectRepository extends JpaRepository<Project, UUID> {

    List<Project> findByProfessor(User professor);

    List<Project> findByStatus(ProjectStatus status);

    List<Project> findByProfessorAndStatus(User professor, ProjectStatus status);

    @Query("SELECT p FROM Project p WHERE p.endDate < :currentDate AND p.status != 'COMPLETED'")
    List<Project> findOverdueProjects(@Param("currentDate") LocalDateTime currentDate);

    @Query("SELECT p FROM Project p JOIN p.teamMembers tm WHERE tm.user = :user AND tm.isActive = true")
    List<Project> findProjectsByTeamMember(@Param("user") User user);

    @Query("SELECT COUNT(p) FROM Project p WHERE p.professor = :professor AND p.status = :status")
    long countByProfessorAndStatus(@Param("professor") User professor, @Param("status") ProjectStatus status);
}
