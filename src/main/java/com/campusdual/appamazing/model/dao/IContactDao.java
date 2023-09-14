package com.campusdual.appamazing.model.dao;

import com.campusdual.appamazing.model.Contacto;
import com.campusdual.appamazing.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IContactDao extends JpaRepository<Contacto, Integer> {
}
