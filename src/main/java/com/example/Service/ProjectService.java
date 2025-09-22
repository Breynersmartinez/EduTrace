package com.example.Service;

import com.example.Entity.Project;
import com.example.Entity.User;
import com.example.Entity.enums.ProjectStatus;
import com.example.Repository.ProjectRepository;
import com.example.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Optional<Project> getProjectById(UUID id) {
        return projectRepository.findById(id);
    }

    // CAMBIADO: Buscar proyectos creados por un estudiante
    public List<Project> getProjectsCreatedByUser(Integer userId) {
        User creator = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        return projectRepository.findByCreatedBy(creator);
    }

    public List<Project> getProjectsByStatus(ProjectStatus status) {
        return projectRepository.findByStatus(status);
    }

    public List<Project> getProjectsByUserId(Integer userId) {
        return projectRepository.findProjectsByUserId(userId);
    }

    // MODIFICADO: Crear proyecto asignando al creador

    public Project createProject(Project project, Integer creatorId) {
        User creator = userRepository.findById(creatorId)
                .orElseThrow(() -> new RuntimeException("Usuario creador no encontrado"));

        project.setCreatedBy(creator);
        project.setStatus(ProjectStatus.PLANNING);
        return projectRepository.save(project);
    }

    public Project updateProject(UUID id, Project updatedProject) {
        return projectRepository.findById(id)
                .map(project -> {
                    project.setName(updatedProject.getName());
                    project.setDescription(updatedProject.getDescription());
                    project.setType(updatedProject.getType());
                    project.setStatus(updatedProject.getStatus());
                    project.setStartDate(updatedProject.getStartDate());
                    project.setEndDate(updatedProject.getEndDate());
                    project.setRepositoryUrl(updatedProject.getRepositoryUrl());
                    project.setRequireWeeklyReports(updatedProject.getRequireWeeklyReports());
                    project.setEnablePeerEvaluation(updatedProject.getEnablePeerEvaluation());
                    project.setAutoGithubSync(updatedProject.getAutoGithubSync());
                    return projectRepository.save(project);
                })
                .orElseThrow(() -> new RuntimeException("Proyecto no encontrado"));
    }

    public void deleteProject(UUID id) {
        projectRepository.deleteById(id);
    }
}
