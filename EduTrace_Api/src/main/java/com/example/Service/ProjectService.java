package com.example.Service;

import com.example.Entity.Project;
import com.example.Entity.TeamMember;
import com.example.Entity.User;
import com.example.Entity.enums.ProjectStatus;
import com.example.Entity.enums.TeamMemberRole;
import com.example.Repository.ProjectRepository;
import com.example.Repository.TeamMemberRepository;
import com.example.Repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service

public class ProjectService {
    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Project getProjectById(UUID id) {
        return projectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Proyecto no encontrado"));
    }

    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    public Project updateProject(UUID id, Project project) {
        Project existing = getProjectById(id);
        existing.setName(project.getName());
        existing.setDescription(project.getDescription());
        existing.setStatus(project.getStatus());
        return projectRepository.save(existing);
    }

    public void deleteProject(UUID id) {
        projectRepository.deleteById(id);
    }
}