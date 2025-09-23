package com.example.Repository;

import com.example.Entity.Project;
import com.example.Entity.User;
import com.example.Entity.enums.ProjectStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

@Repository
public interface ProjectRepository extends JpaRepository<Project, UUID> {
    // CAMBIADO: Buscar por creador en lugar de profesor
    List<Project> findByCreatedBy(User createdBy);
    List<Project> findByStatus(ProjectStatus status);

    @Query("SELECT p FROM Project p JOIN p.teamMembers tm WHERE tm.user.idCard = :userId AND tm.isActive = true")
    List<Project> findProjectsByUserId(@Param("userId") Integer userId);

    @Query("SELECT p FROM Project p WHERE p.createdBy.idCard = :creatorId AND p.status = :status")
    List<Project> findByCreatorAndStatus(@Param("creatorId") Integer creatorId, @Param("status") ProjectStatus status);

    // NUEVOS: Para estudiantes
    @Query("SELECT p FROM Project p WHERE p.createdBy.idCard = :userId")
    List<Project> findProjectsCreatedByUser(@Param("userId") Integer userId);
}
