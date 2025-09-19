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
@Table(name = "userQA")

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

/*

    private String avatar;


    @Column(nullable = false)
    private String role;

    @Column(name = "github_username")
    private String githubUsername;

    @Column(name = "is_active")
    private Boolean isActive = true;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;



 */
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
}
