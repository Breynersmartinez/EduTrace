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


}
