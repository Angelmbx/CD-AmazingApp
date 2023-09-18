package com.campusdual.appamazing.service;

import com.campusdual.appamazing.api.IContactosService;
import com.campusdual.appamazing.model.Contacto;
import com.campusdual.appamazing.model.dao.IContactDao;
import com.campusdual.appamazing.model.dto.ContactoDTO;
import com.campusdual.appamazing.model.dto.dtoMapper.ContactoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ContactoService")
@Lazy//So carga esta clase cando sexa invocada. Evitar cargar moito nada mais arrincar
public class ContactoService implements IContactosService {
    @Autowired
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
    public int insertContacto(ContactoDTO contactoDTO) {
        Contacto contacto = ContactoMapper.INSTANCE.toEntity(contactoDTO);
        contactDao.saveAndFlush(contacto);
        return contacto.getId();
    }

    @Override
    public int updateContacto(ContactoDTO contactoDTO) {
        return this.insertContacto(contactoDTO);
    }

    @Override
    public int deleteContacto(ContactoDTO contactoDTO) {
        int id = contactoDTO.getId();
        Contacto contacto = ContactoMapper.INSTANCE.toEntity(contactoDTO);
        contactDao.delete(contacto);

        return id;
    }
}
