package com.example.crud_rapido.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud_rapido.Service.StudentService;
import com.example.crud_rapido.Entity.Student;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController /* NOTACION DE RESTCONTROLLER */
/* Se agrega la version con */

/* De esta manera tenemoos nuestra primera ruta  */
@RequestMapping(path = "api/v1/students")
public class StudentController {

   
    @Autowired  /* Notacion para enlazar nuestro servicio  */

    private  StudentService studentService;

/* Se van a exponer los servicios con: */
    @GetMapping

    

public List<Student> getAll(){/* Esto va a retornar una lista de estudiantes en services, le vamos a decir que 
    aca tambien vamos a tener esta informacion  */
return  studentService.getStudents();
    }


    /* Metodo para consultar Datos  */
    @GetMapping("/{studentId}")//Voy a decirle que la ruta adicionalmente, va ah recibir  el Id para consultarlo de forma especifica
    public Optional<Student> getBid(@PathVariable("studentId") Long studentId){
        return  studentService.getStudent(studentId);
            }

    /* Metodo para actualizacion de datos */
    
    @PostMapping

    /*se pone @RequestBody porque necesito datos
     y necesito que me manden los datos de un estudiantes(Student)*/
     
    public void getALL(@RequestBody Student student) { //Este no retorna ninguna informacion relevante.
    studentService.saveOrUpdate(student);//Aqui se resiven los datos y se los va ah pasar directamente al servicio
    }
 

    /*Metodo para  Eliminacion de datos  */
@DeleteMapping("/{studentId}")//cuando utilicen este elemento yo voy a recibir por este lugar el id del estudiante 
public void saveUpdate(@PathVariable("studentId") Long studentId ){
    studentService.delete(studentId);

}
    

}
