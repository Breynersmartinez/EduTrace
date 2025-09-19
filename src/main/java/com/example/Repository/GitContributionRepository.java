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

    List<GitContribution> findByProjectAndUser(Project project, User user);

    boolean existsByCommitHash(String commitHash);

    @Query("SELECT gc FROM GitContribution gc WHERE gc.project = :project AND gc.commitDate >= :startDate AND gc.commitDate <= :endDate")
    List<GitContribution> findByProjectAndDateRange(@Param("project") Project project,
                                                    @Param("startDate") LocalDateTime startDate,
                                                    @Param("endDate") LocalDateTime endDate);

    @Query("SELECT SUM(gc.linesAdded) FROM GitContribution gc WHERE gc.user = :user AND gc.project = :project")
    Integer getTotalLinesAddedByUserAndProject(@Param("user") User user, @Param("project") Project project);

    @Query("SELECT COUNT(gc) FROM GitContribution gc WHERE gc.user = :user AND gc.project = :project")
    long getCommitCountByUserAndProject(@Param("user") User user, @Param("project") Project project);

    @Query("SELECT gc.user, COUNT(gc) as commitCount FROM GitContribution gc WHERE gc.project = :project GROUP BY gc.user ORDER BY commitCount DESC")
    List<Object[]> getContributionStatsbyProject(@Param("project") Project project);
}

