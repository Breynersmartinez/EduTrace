package com.example.Service;

import java.util.List;
import java.util.Optional;


import com.example.Entity.User;
import com.example.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/* NOTACION DE LOS SERVICIOS   */
@Service
public class UserService {

    /* notacion Autowired */

    /* Definindo lo que seria este repositorio */
    private final   UserRepository userRepository;




    public UserService(UserRepository userRepository)
    {
        this.userRepository = userRepository;

    }


    /* Creacion de una serie de servicios  */


    /*  Se devuelve una lista de elementos de lo que son los estudiantes. */
    public List<User> getUsers(){

        /*Retonar toda la informacion.
        findAll() busca todos los elementos y los retorna
        */
        return userRepository.findAll();
    }

    /* BUSQUEDA DE ELEMENTOS A TRAVES DEL id */

    /* Este seria un estudiante y no una lista y esto  seria opcional */
    public Optional<User> getUser(int idCard){
        return userRepository.findById(idCard);

    }


    /* GUARDAR Y ACTUALIZAR EN UN SOLO METODO */

    /* Va a recibir a un estudiante */
    public void saveOrUpdate(User user){

        /* Se llama al repositorio y decirle que guarde  la informacion */
        userRepository.save(user);
    }


    /* METODO PARA ELIMINAR A TRAVEZ DEL id  */
    public void delete( int  idCard){

        /* Se llama al repositorio y decirle que guarde  la informacion */
        userRepository.deleteById(idCard);
    }

}