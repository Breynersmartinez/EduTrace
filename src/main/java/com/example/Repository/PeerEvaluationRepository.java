package com.example.Repository;

import com.example.Entity.PeerEvaluation;
import com.example.Entity.Project;
import com.example.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PeerEvaluationRepository extends JpaRepository<PeerEvaluation, UUID> {

    List<PeerEvaluation> findByProject(Project project);

    List<PeerEvaluation> findByEvaluated(User evaluated);

    List<PeerEvaluation> findByEvaluator(User evaluator);

    List<PeerEvaluation> findByProjectAndPeriod(Project project, String period);

    @Query("SELECT pe FROM PeerEvaluation pe WHERE pe.project = :project AND pe.evaluated = :evaluated AND pe.period = :period")
    List<PeerEvaluation> findEvaluationsForUserInPeriod(@Param("project") Project project,
                                                        @Param("evaluated") User evaluated,
                                                        @Param("period") String period);

    @Query("SELECT AVG(pe.taskCompletion), AVG(pe.codeQuality), AVG(pe.communication), AVG(pe.collaboration), AVG(pe.initiative) " +
            "FROM PeerEvaluation pe WHERE pe.evaluated = :evaluated AND pe.project = :project")
    List<Double> getAverageScoresByUserAndProject(@Param("evaluated") User evaluated, @Param("project") Project project);

    boolean existsByProjectAndEvaluatorAndEvaluatedAndPeriod(Project project, User evaluator, User evaluated, String period);
}
