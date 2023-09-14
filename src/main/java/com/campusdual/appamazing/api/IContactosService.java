package com.campusdual.appamazing.api;

import com.campusdual.appamazing.model.dto.ContactoDTO;
import com.campusdual.appamazing.model.dto.ProductDTO;

import java.util.List;

public interface IContactosService {

    ContactoDTO queryContacto (ContactoDTO contactoDTO); //query
    List<ContactoDTO> queryAllContactos(); //queryAll
    int insertProduct(ProductDTO productDTO);
    int updateProduct(ProductDTO productDTO);
    int deleteProduct(ProductDTO productDTO);


}
