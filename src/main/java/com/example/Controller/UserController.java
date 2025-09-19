package com.example.Controller;

import com.example.Entity.User;
import com.example.Service.UserService;
import com.example.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController /* NOTACION DE RESTCONTROLLER */
/* Se agrega la version con */

/* De esta manera tenemoos nuestra primera ruta  */
@RequestMapping(path = "api/v1/students")
public class UserController {

    @Autowired  /* Notacion para enlazar nuestro servicio  */

    private final UserService userService;
    public UserController(UserService userService)
    {
        this.userService = userService;
    }


    /* Se van a exponer los servicios con: */
    @GetMapping
    public List<User> getAll(){/* Esto va a retornar una lista de estudiantes en services, le vamos a decir que
    aca tambien vamos a tener esta informacion  */
        return  userService.getUsers();
    }


    /* Metodo para consultar Datos  */
    @GetMapping("/{idCard}")//Voy a decirle que la ruta adicionalmente, va ah recibir  el Id para consultarlo de forma especifica
    public Optional<User> getBid(@PathVariable("idCard") int  idCard){
        return  userService.getUser(idCard);
    }

    /* Metodo para actualizacion de datos */

    @PostMapping

    /*se pone @RequestBody porque necesito datos
     y necesito que me manden los datos de un estudiantes(Student)*/

    public void getALL(@RequestBody User user) { //Este no retorna ninguna informacion relevante.
        userService.saveOrUpdate(user);//Aqui se resiven los datos y se los va ah pasar directamente al servicio
    }


    /*Metodo para  Eliminacion de datos  */
    @DeleteMapping("/{idCard}")//cuando utilicen este elemento yo voy a recibir por este lugar el id del estudiante
    public void saveUpdate(@PathVariable("idCard") int idCard ){
        userService.delete(idCard);

    }

}
