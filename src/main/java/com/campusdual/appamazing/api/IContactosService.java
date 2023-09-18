package com.campusdual.appamazing.api;

import com.campusdual.appamazing.model.dto.ContactoDTO;

import java.util.List;

public interface IContactosService {

    ContactoDTO queryContacto (ContactoDTO contactoDTO); //query
    List<ContactoDTO> queryAllContactos(); //queryAll
    int insertContacto(ContactoDTO contactoDTO);
    int updateContacto(ContactoDTO contactoDTO);
    int deleteContacto(ContactoDTO contactoDTO);


}
