package com.campusdual.appamazing.api;

import com.campusdual.appamazing.model.dto.ProductDTO;

import java.util.List;

public interface IProductService {
    ProductDTO queryProduct(ProductDTO productDTO); //query
    List<ProductDTO> queryAllProducts(); //queryAll
    //insert update & delete. No devuelven un objeto, sino el numero de lineas afectadas
    //aunque lo configuraremos para que devuelvan el id de lo modificado
    int insertProduct(ProductDTO productDTO);//trae to do menos el id
    int updateProduct(ProductDTO productDTO); // si no hay where
    int deleteProduct(ProductDTO productDTO); // si no hay where elimina todos
}
