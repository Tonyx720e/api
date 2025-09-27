package com.practica.api.entity;

public class Profesor {

private int id;
private String nombre;
private String apellido;
private String materia;

public Profesor(int id, String nombre, String apellido, String materia) {
    this.id = id;
    this.nombre = nombre;
    this.apellido = apellido;
    this.materia = materia;
    

}

public Profesor() {
}

public int getId() {
    return id;
}

public void setId(int id) {
    this.id = id;
}

public String getNombre() {
    return nombre;
}

public void setNombre(String nombre) {
    this.nombre = nombre;
}

public String getApellido() {
    return apellido;
}

public void setApellido(String apellido) {
    this.apellido = apellido;
}

public String getMateria() {
    return materia;
}

public void setMateria(String materia) {
    this.materia = materia;
}

}
