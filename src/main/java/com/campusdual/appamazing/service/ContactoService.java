package com.campusdual.appamazing.service;

import com.campusdual.appamazing.api.IContactosService;
import com.campusdual.appamazing.model.dto.ContactoDTO;
import com.campusdual.appamazing.model.dto.ProductDTO;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ContactoService")
@Lazy//So carga esta clase cando sexa invocada. Evitar cargar moito nada mais arrincar
public class ContactoService implements IContactosService {
    @Override
    public ContactoDTO queryContacto(ContactoDTO contactoDTO) {
        return null;
    }

    @Override
    public List<ContactoDTO> queryAllContactos() {
        return null;
    }

    @Override
    public int insertProduct(ProductDTO productDTO) {
        return 0;
    }

    @Override
    public int updateProduct(ProductDTO productDTO) {
        return 0;
    }

    @Override
    public int deleteProduct(ProductDTO productDTO) {
        return 0;
    }
}
