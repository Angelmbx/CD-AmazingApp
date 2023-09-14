package com.campusdual.appamazing.controller;

import org.springframework.web.bind.annotation.*;

@RestController() //indicamos que es el controlador
@RequestMapping("/products") //para acceder a productos > http://localhost:3030/products
// Faltarian los endpoints. Si solo se pone .../products intentará ejecutar un endpoint que no tenga ruta adicional
public class ProductController {

    /*@GetMapping
    public String testController(){
        return "viva Vigo"; //si introduces solo http://localhost:3030/products print este String
    }*/

    @PostMapping
    public String testController(@RequestBody String name){
        return "Product controller works " + name + "!!"; // lo mismo pero pasandole un JSON con un String por Postman
    }


}
