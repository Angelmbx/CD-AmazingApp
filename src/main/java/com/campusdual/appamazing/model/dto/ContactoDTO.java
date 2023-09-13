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

}
