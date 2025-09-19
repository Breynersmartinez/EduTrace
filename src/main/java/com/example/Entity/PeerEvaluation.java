package com.example.Entity;

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
@Table(name = "peer_evaluations")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class PeerEvaluation {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid", updatable = false)
    private UUID id;

    @Column(nullable = false)
    private String period; // "2024-W01"

    // Criterios de evaluación (1-5)
    @Column(name = "task_completion")
    private Integer taskCompletion;

    @Column(name = "code_quality")
    private Integer codeQuality;

    private Integer communication;

    private Integer collaboration;

    private Integer initiative;

    @Column(columnDefinition = "TEXT")
    private String comments;

    @Column(name = "is_anonymous")
    private Boolean isAnonymous = true;

    @CreatedDate
    @Column(name = "submitted_at", nullable = false, updatable = false)
    private LocalDateTime submittedAt;

    // Relaciones
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "evaluator_id", nullable = false)
    private User evaluator;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "evaluated_id", nullable = false)
    private User evaluated;

    // Método helper para calcular promedio
    public Double getAverageScore() {
        List<Integer> scores = List.of(taskCompletion, codeQuality, communication,
                collaboration, initiative);
        return scores.stream()
                .filter(score -> score != null)
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }
}