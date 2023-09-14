package com.campusdual.appamazing.service;

import com.campusdual.appamazing.api.IContactosService;
import com.campusdual.appamazing.model.Contacto;
import com.campusdual.appamazing.model.dao.IContactDao;
import com.campusdual.appamazing.model.dto.ContactoDTO;
import com.campusdual.appamazing.model.dto.ProductDTO;
import com.campusdual.appamazing.model.dto.dtoMapper.ContactoMapper;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ContactoService")
@Lazy//So carga esta clase cando sexa invocada. Evitar cargar moito nada mais arrincar
public class ContactoService implements IContactosService {

   private IContactDao contactDao;
    @Override
    public ContactoDTO queryContacto(ContactoDTO contactoDTO) {
        Contacto contacto = ContactoMapper.INSTANCE.toEntity(contactoDTO);

        return ContactoMapper.INSTANCE.toDTO(contactDao.getReferenceById(contacto.getId()));
    }

    @Override
    public List<ContactoDTO> queryAllContactos() {
        return ContactoMapper.INSTANCE.toDTOList(contactDao.findAll());
    }

    @Override
    public int insertProduct(ContactoDTO contactoDTO) {
        Contacto contacto = ContactoMapper.INSTANCE.toEntity(contactoDTO);
        contactDao.saveAndFlush(contacto);
        return contacto.getId();
    }

    @Override
    public int updateProduct(ContactoDTO contactoDTO) {
        return this.insertProduct(contactoDTO);
    }

    @Override
    public int deleteProduct(ContactoDTO contactoDTO) {
        int id = contactoDTO.getId();
        Contacto contacto = ContactoMapper.INSTANCE.toEntity(contactoDTO);
        contactDao.delete(contacto);

        return id;
    }
}
