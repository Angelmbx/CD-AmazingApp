package com.campusdual.appamazing.controller;

import com.campusdual.appamazing.api.IContactosService;
import com.campusdual.appamazing.model.dto.ContactoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/contactos")
public class ContactoController {

    @Autowired
    private IContactosService contactosService;

    @PostMapping("/get")
    public ContactoDTO queryProduct(@RequestBody ContactoDTO contactoDTO){
        return this.contactosService.queryContacto(contactoDTO);
    }

    @GetMapping("/get/{id}")
    public ContactoDTO queryProduct(@PathVariable int id){
        ContactoDTO contactoDTO = new ContactoDTO();
        contactoDTO.setId(id);
        return this.contactosService.queryContacto(contactoDTO);
    }
    @GetMapping("/getAll")
    public List<ContactoDTO> queryAllProducts(){
        return this.contactosService.queryAllContactos();
    }
    //hasta aqui gets.
    @PostMapping("/add")
    public int addContacto(@RequestBody ContactoDTO contactoDTO){
        return this.contactosService.insertContacto(contactoDTO);
    }

    @PutMapping("/update")
    public int updateContacto(@RequestBody ContactoDTO contactoDTO){
        return this.contactosService.updateContacto(contactoDTO);
    }

    @DeleteMapping("/delete")
    public int deleteContacto(@RequestBody ContactoDTO contactoDTO){
        return this.contactosService.deleteContacto(contactoDTO);
    }


}
