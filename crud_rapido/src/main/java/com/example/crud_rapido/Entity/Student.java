package com.example.crud_rapido.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/* con esta notacion, No necesitamos agregar los set ni los get con data*/
@Data
@Entity
/* Notacion Crear una tabla con el nombre que deseemos  */
@Table(name = "tbl_Student")

public class Student {
/*Notacion */
@Id
/*Y se va a generar de forma automatica */
@GeneratedValue(strategy = GenerationType.IDENTITY)

private long studentId;

private String firstName;

private  String lastName;

private String IdCard;

/* Se puede añadir configuraciones para el email con esta notacion */
@Column(name = "email_adress",unique = true,nullable = false)
private String email;

}
