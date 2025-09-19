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

    List<Task> findByAssignedTo(User user);

    List<Task> findByProjectAndStatus(Project project, TaskStatus status);

    List<Task> findByAssignedToAndStatus(User user, TaskStatus status);

    @Query("SELECT t FROM Task t WHERE t.dueDate < :currentDate AND t.status != 'COMPLETED'")
    List<Task> findOverdueTasks(@Param("currentDate") LocalDateTime currentDate);

    @Query("SELECT t FROM Task t WHERE t.project = :project AND t.assignedTo = :user")
    List<Task> findByProjectAndAssignedTo(@Param("project") Project project, @Param("user") User user);

    @Query("SELECT COUNT(t) FROM Task t WHERE t.assignedTo = :user AND t.status = :status")
    long countByAssignedToAndStatus(@Param("user") User user, @Param("status") TaskStatus status);

    @Query("SELECT t FROM Task t WHERE t.project = :project AND t.priority = :priority ORDER BY t.dueDate ASC")
    List<Task> findByProjectAndPriorityOrderByDueDate(@Param("project") Project project, @Param("priority") TaskPriority priority);

    @Query("SELECT SUM(t.actualHours) FROM Task t WHERE t.assignedTo = :user AND t.project = :project")
    Double getTotalHoursByUserAndProject(@Param("user") User user, @Param("project") Project project);
}
