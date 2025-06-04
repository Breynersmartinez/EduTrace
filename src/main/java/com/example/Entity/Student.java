package com.example.Entity;

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
@Table(name = "ESTUDIANTES")

public class Student {
/*Notacion */
@Id

/*Y se va a generar de forma automatica
@GeneratedValue(strategy = GenerationType.IDENTITY)
*/

@Column (name = "IDENTIFICACION")
private int idCard;

@Column  (name = "NOMBRES")
private String firstName;

@Column  (name = "APELLIDOS")
private  String lastName;

@Column(name = "CORREO")
private String email;

}
