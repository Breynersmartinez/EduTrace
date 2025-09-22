package com.example.Repository;


import com.example.Entity.Task;
import com.example.Entity.Project;
import com.example.Entity.User;
import com.example.Entity.enums.TaskStatus;
import com.example.Entity.enums.TaskPriority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface TaskRepository extends JpaRepository<Task, UUID> {
    List<Task> findByProject(Project project);
    List<Task> findByAssignedTo(User assignedTo);
    List<Task> findByStatus(TaskStatus status);
    List<Task> findByPriority(TaskPriority priority);

    @Query("SELECT t FROM Task t WHERE t.assignedTo.idCard = :userId AND t.status = :status")
    List<Task> findByUserIdAndStatus(@Param("userId") Integer userId, @Param("status") TaskStatus status);

    @Query("SELECT t FROM Task t WHERE t.project.id = :projectId AND t.dueDate BETWEEN :startDate AND :endDate")
    List<Task> findTasksByProjectAndDateRange(@Param("projectId") UUID projectId,
                                              @Param("startDate") LocalDateTime startDate,
                                              @Param("endDate") LocalDateTime endDate);
}
