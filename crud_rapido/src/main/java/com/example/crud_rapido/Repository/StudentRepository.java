package com.example.crud_rapido.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.crud_rapido.Entity.Student;

/*Se agrega la anotacion repository */
//esto es una interface
@Repository

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
