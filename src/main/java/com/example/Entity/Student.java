package com.example.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
/* Notacion Crear una tabla con el nombre que deseemos  */
@Table(name = "ESTUDIANTES")

public class Student {
/*Notacion */
@Id
@Column (name = "IDENTIFICACION")
private int idCard;

@Column  (name = "NOMBRES")
private String firstName;

@Column  (name = "APELLIDOS")
private  String lastName;

@Column(name = "CORREO")
private String email;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getIdCard() {
        return idCard;
    }

    public void setIdCard(int idCard) {
        this.idCard = idCard;
    }
}
