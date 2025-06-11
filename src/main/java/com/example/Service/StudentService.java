package com.example.Service;

import java.util.List;
import java.util.Optional;

import com.example.Entity.Student;
import com.example.Repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/* NOTACION DE LOS SERVICIOS   */
@Service
public class StudentService {

   /* notacion Autowired */ 

   /* Definindo lo que seria este repositorio */
       private final   StudentRepository studentRepository;


       @Autowired
       private final ModelMapper modelMapper;

       public StudentService(StudentRepository studentRepository, ModelMapper modelMapper)
       {
           this.studentRepository = studentRepository;
           this.modelMapper = modelMapper;
       }


   /* Creacion de una serie de servicios  */


/*  Se devuelve una lista de elementos de lo que son los estudiantes. */
        public List<Student> getStudents(){

        /*Retonar toda la informacion.
        findAll() busca todos los elementos y los retorna 
        */
         return studentRepository.findAll();
   }

    /* BUSQUEDA DE ELEMENTOS A TRAVES DEL id */

    /* Este seria un estudiante y no una lista y esto  seria opcional */
    public Optional<Student> getStudent(int idCard){
        return studentRepository.findById(idCard);

    }


    /* GUARDAR Y ACTUALIZAR EN UN SOLO METODO */

    /* Va a recibir a un estudiante */
    public void saveOrUpdate(Student student){

        /* Se llama al repositorio y decirle que guarde  la informacion */
        studentRepository.save(student);
    }


    /* METODO PARA ELIMINAR A TRAVEZ DEL id  */
    public void delete( int  idCard){

        /* Se llama al repositorio y decirle que guarde  la informacion */
        studentRepository.deleteById(idCard);
    }

}
