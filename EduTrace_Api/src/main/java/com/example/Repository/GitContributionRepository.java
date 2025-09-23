package com.example.Repository;

import com.example.Entity.GitContribution;
import com.example.Entity.Project;
import com.example.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface GitContributionRepository extends JpaRepository<GitContribution, UUID> {
    List<GitContribution> findByProject(Project project);
    List<GitContribution> findByUser(User user);

    @Query("SELECT gc FROM GitContribution gc WHERE gc.project.id = :projectId AND gc.commitDate BETWEEN :startDate AND :endDate")
    List<GitContribution> findByProjectAndDateRange(@Param("projectId") UUID projectId,
                                                    @Param("startDate") LocalDateTime startDate,
                                                    @Param("endDate") LocalDateTime endDate);

    @Query("SELECT SUM(gc.linesAdded), SUM(gc.linesDeleted) FROM GitContribution gc WHERE gc.user.idCard = :userId AND gc.project.id = :projectId")
    Object[] getUserContributionStats(@Param("userId") Integer userId, @Param("projectId") UUID projectId);
}