package com.example.Repository;

import com.example.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



/*Se agrega la anotacion repository */
//esto es una interface
@Repository

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
