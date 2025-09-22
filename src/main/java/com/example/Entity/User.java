package com.example.Entity;

import com.example.Entity.enums.UserRole;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;


import java.time.LocalDateTime;
import java.util.List;


@Entity
/* Notacion Crear una tabla con el nombre que deseemos  */
@Table(name = "USUARIOS")

//extends Auditable<String>
public class User {
/*Notacion */
@Id
@Column (name = "IDENTIFICACION")
private int idCard;


@Column  (name = "NOMBRES")
private String firstName;


@Column  (name = "APELLIDOS")
private  String lastName;

@Email
@Column(name = "CORREO")
private String email;


// foto usuario
    private String avatar;


    @Column(nullable = false)
    private String role;

    @Column(name = "github_username")
    private String githubUsername;

    @Column(name = "is_active")
    private Boolean isActive = true;




    // Relaciones
    @OneToMany(mappedBy = "professor", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Project> professorProjects;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<TeamMember> teamMemberships;

    @OneToMany(mappedBy = "assignedTo", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Task> assignedTasks;

    // Método helper para obtener nombre completo
    public String getFullName() {
        return firstName + " " + lastName;
    }




    // getters and setters
    public int getIdCard() {
        return idCard;
    }

    public void setIdCard(int idCard) {
        this.idCard = idCard;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getGithubUsername() {
        return githubUsername;
    }

    public void setGithubUsername(String githubUsername) {
        this.githubUsername = githubUsername;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    

    public List<Project> getProfessorProjects() {
        return professorProjects;
    }

    public void setProfessorProjects(List<Project> professorProjects) {
        this.professorProjects = professorProjects;
    }

    public List<TeamMember> getTeamMemberships() {
        return teamMemberships;
    }

    public void setTeamMemberships(List<TeamMember> teamMemberships) {
        this.teamMemberships = teamMemberships;
    }

    public List<Task> getAssignedTasks() {
        return assignedTasks;
    }

    public void setAssignedTasks(List<Task> assignedTasks) {
        this.assignedTasks = assignedTasks;
    }
}
