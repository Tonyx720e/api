package com.practica.api.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practica.api.entity.Student;

import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api")

public class DemoRestController {

    List<Student> studentList;

    // @PosContructor es un metodo que se ejecuta una vez se ha construido el bean
    @PostConstruct
    // LocadData() es un metodo que carga los datos
    // este metodo se ejecuta una vez se ha construido el bean
    public void LoadData() {
        studentList = new ArrayList<>();
        studentList.add(new Student(1, "Jorge", "Millares"));
        studentList.add(new Student(2, "Tony", "Medina"));
        studentList.add(new Student(3, "Geraldin", "Piña"));

    }
    // Endpoint para devolver la lista de estudiantes
    // @GetMapping es una anotacion que indica que este metodo es un endpoint
    @GetMapping("/students")
    public List<Student> listStudents() {

        return studentList;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        for(Student student: this.studentList){
            if(student.getId() == studentId){
                return student;
            }
        }
        return null;
    }

    @PostMapping("/students")
    public Student agregarStudents(@RequestBody Student theStudent){
        studentList.add(theStudent);
        return theStudent;
    }

    @PutMapping("/students")
    public Student updateStudent(@RequestBody Student upStudent){
        for(Student student: this.studentList){
            if(student.getId() == upStudent.getId()){
                student.setNombre(upStudent.getNombre());
                student.setApellido(upStudent.getApellido());

            }
        }
        return upStudent;

    }
    @DeleteMapping("/students/{studentId}")
    public int deleteStudent(@PathVariable int studentId){
        
           this.studentList.removeIf(s -> s.getId() == studentId);
              return studentId;
        
    }
    


}
