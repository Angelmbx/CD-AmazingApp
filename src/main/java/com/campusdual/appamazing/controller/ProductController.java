package com.campusdual.appamazing.controller;

import com.campusdual.appamazing.api.IProductService;
import com.campusdual.appamazing.model.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController() //indicamos que es el controlador
@RequestMapping("/products") //para acceder a productos > http://localhost:3030/products
// Faltarian los endpoints. Si solo se pone .../products intentará ejecutar un endpoint que no tenga ruta adicional
public class ProductController {

    /*@GetMapping
    public String testController(){
        return "viva Vigo"; //si introduces solo http://localhost:3030/products print este String
    }*/

    @Autowired
    private IProductService productService;

    @PostMapping
    public String testController(@RequestBody String name){
        return "Product controller works " + name + "!!"; // lo mismo pero pasandole un JSON con un String por Postman haciendo un Post
    }               //sirve para controlar que funcione el controlador

    @PostMapping("/get") //como no puede haber 2 sin argumentos ponemos /get por ejemplo
    // ahora para que ejecute esta query la ruta será: http://localhost:3030/products/get
    public ProductDTO queryProduct(@RequestBody ProductDTO productDTO){
       return this.productService.queryProduct(productDTO);
    }

    @GetMapping("/get/{id}")
    public ProductDTO queryProduct(@PathVariable int id){ //get sin pasarle JSON. > http://localhost:30030/products/get/1 mismo resultado. cambias num cambia id
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(id);
        return this.productService.queryProduct(productDTO);
    }

    @GetMapping("/getAll")
    public List<ProductDTO> queryAllProducts(){
        return this.productService.queryAllProducts();
    }
    //hasta aquí lo gets.

    //ahora insert, update, delete.

    //insert
    @PostMapping("/add")
    public int addProduct(ProductDTO productDTO){ //dado que es un POST llegaran los datos a traves del body
        return this.productService.insertProduct(productDTO);
    }
    //update
    @PutMapping("/update")
    public int updateProduct(@RequestBody ProductDTO productDTO){
        return this.productService.updateProduct(productDTO);
    }
    //delete
    @DeleteMapping("/delete")
    public int deleteProduct(@RequestBody ProductDTO productDTO){
        return this.productService.deleteProduct(productDTO);
    }


    //con to esto ya tendríamos nuestros endpoints definidos.

}
