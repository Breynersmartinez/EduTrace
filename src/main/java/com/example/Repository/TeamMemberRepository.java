package com.example.Repository;

import com.example.Entity.TeamMember;
import com.example.Entity.Project;
import com.example.Entity.User;
import com.example.Entity.enums.TeamMemberRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TeamMemberRepository extends JpaRepository<TeamMember, UUID> {
    List<TeamMember> findByProject(Project project);
    List<TeamMember> findByUser(User user);
    List<TeamMember> findByProjectAndIsActiveTrue(Project project);

    Optional<TeamMember> findByProjectAndUser(Project project, User user);

    @Query("SELECT tm FROM TeamMember tm WHERE tm.project.id = :projectId AND tm.role = :role AND tm.isActive = true")
    List<TeamMember> findActiveTeamMembersByProjectAndRole(@Param("projectId") UUID projectId,
                                                           @Param("role") TeamMemberRole role);
}