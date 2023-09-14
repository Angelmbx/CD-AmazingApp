package com.campusdual.appamazing.model.dto;

import com.sun.istack.NotNull;

import javax.persistence.Column;

public class ContactoDTO {

    //los campos aquí declarados seran los que se envién a quien hizo la petición, y así evitar
    //traer todos los campos de la entity. (aunque en este caso estamos trayendo todos)
    private int id;
    private String nombre;
    private String primer_apellido;
    private String segundo_apellido;
    private String telefono;
    private String email;

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

    public String getPrimer_apellido() {
        return primer_apellido;
    }

    public void setPrimer_apellido(String primer_apellido) {
        this.primer_apellido = primer_apellido;
    }

    public String getSegundo_apellido() {
        return segundo_apellido;
    }

    public void setSegundo_apellido(String segundo_apellido) {
        this.segundo_apellido = segundo_apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
