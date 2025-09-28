package com.practica.api.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practica.api.entity.Profesor;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("api")
public class RestControllerProfesor {
    List<Profesor> profesorList;
    @PostConstruct
    private void LoadData(){
        profesorList = new ArrayList<>();
        profesorList.add(new Profesor(1, "Jorge", "Millares", "Programacion"));
        profesorList.add(new Profesor(2, "Mirian", "Valenzuela", "Diseño UX / UI"));
        profesorList.add(new Profesor(3, "Mario","Castañeda","Doblaje"));
        
    }
    @GetMapping("/listaProfesores")
    private List<Profesor> listarProfesores(){
        return profesorList;
    }

    @GetMapping("/busquedaProfesor/{idProfesor}")
    private Profesor busquedaProfesor(@PathVariable int idProfesor){
        for(Profesor profesor: this.profesorList){
            if(profesor.getId() == idProfesor)
            return profesor;
        }
        return null;
    }

    @PostMapping("/listaProfesores")
    private List<Profesor> agregarProfesor(@RequestBody Profesor elProfesor){
        profesorList.add(elProfesor);
        return profesorList;

    }

    @PutMapping("/actualizar")
    private List<Profesor> actualizarList(@RequestBody Profesor actualizarProfesor){
        for(Profesor profesor: this.profesorList){
            if(profesor.getId() == actualizarProfesor.getId()){
                profesor.setNombre(actualizarProfesor.getNombre());
                profesor.setApellido(actualizarProfesor.getApellido());
                profesor.setMateria(actualizarProfesor.getMateria());
               
            

            }
            
        }
        return profesorList;
    }

    @DeleteMapping("listaProfesores/{idDelete}")
    private int eliminarProfesor(@PathVariable int idDelete){
       this.profesorList.removeIf(dProf -> dProf.getId() == idDelete);
         return this.profesorList.size();
    }


}
