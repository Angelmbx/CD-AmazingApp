package com.campusdual.appamazing.model.dto.dtoMapper;

import com.campusdual.appamazing.model.Contacto;
import com.campusdual.appamazing.model.dto.ContactoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper
public interface ContactoMapper {

        ContactoMapper INSTANCE = Mappers.getMapper(ContactoMapper.class);

        ContactoDTO toDTO(Contacto contacto);
        Contacto toEntity(ContactoDTO contactoDTO);

        List<ContactoDTO> toDTOList (List<Contacto> contactos);

}
