package com.practica.api.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practica.api.entity.Profesor;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("api/profesores")
public class RestControllerProfesor {
    List<Profesor> profesorList;
    @PostConstruct
    private void LoadData(){
        profesorList = new ArrayList<>();
        profesorList.add(new Profesor(1, "Jorge", "Millares", "Programacion"));
        profesorList.add(new Profesor(2, "Mirian", "Valenzuela", "Diseño UX / UI"));
        profesorList.add(new Profesor(3, "Mario","Castañeda","Doblaje"));
        
    }
    @RequestMapping("/lista")
    private List<Profesor> listarProfesores(){
        return profesorList;
    }

    @RequestMapping("/busquedaProfesor/{idProfesor}")
    private Profesor busquedaProfesor(@PathVariable int idProfesor){
        for(Profesor profesor: this.profesorList){
            if(profesor.getId() == idProfesor)
            return profesor;
        }
        return null;
    }


}
