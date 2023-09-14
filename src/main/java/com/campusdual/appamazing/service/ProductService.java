package com.campusdual.appamazing.service;

import com.campusdual.appamazing.api.IProductService;
import com.campusdual.appamazing.model.Product;
import com.campusdual.appamazing.model.dao.IProductDao;
import com.campusdual.appamazing.model.dto.ProductDTO;
import com.campusdual.appamazing.model.dto.dtoMapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ProductService")
@Lazy//So carga esta clase cando sexa invocada. Evitar cargar moito nada mais arrincar
public class ProductService implements IProductService {
    @Autowired
    //automaticamente cando se inicialice ProductService le pase una intancia de ProductDao con la que pueda trabajar
    private IProductDao productDao;

    @Override
    public ProductDTO queryProduct(ProductDTO productDTO) {
        //DAO no puede trabajar con DTOs solo con entidades que hay en la BD
        //Lo primero que hacemos entonces es una conversión
        Product product = ProductMapper.INSTANCE.toEntity(productDTO); //esto se podría omitir porque el DTO tambien tiene id... pero la conversion del return es necesaria igualmente
        //ahora ya tenemos nuestro Producto,

        //le paso un Id de un producto, me devuelve la tupla correspondiente
        //vuelvo a hacer la conversión
        return ProductMapper.INSTANCE.toDTO(productDao.getReferenceById(product.getId()));
    }

    @Override
    public List<ProductDTO> queryAllProducts() {
        //el DAO nos devuelve una lista de entidades, y lo que nos devuelve nuestra funcion es una lista de DTOs
        //se hace conversion y se devuelve
        return ProductMapper.INSTANCE.toDTOList(productDao.findAll());
    }

    @Override
    public int insertProduct(ProductDTO productDTO) {
        //llega productDTO que traerá todos los datos salvo ID que lo genera la BD automáticamente
        //hacemos conversión
        Product product = ProductMapper.INSTANCE.toEntity(productDTO);
        productDao.saveAndFlush(product);
        //saveAndFlush = Guardar y commitear los cambios
        return product.getId(); //devuelve ID del producto insertado
    }

    @Override
    public int updateProduct(ProductDTO productDTO) {
        //insert si existe el ID lo actualiza, sino crea uno nuevo. Asi que se llama insert y el gestiona

        return this.insertProduct(productDTO);
    }

    @Override
    public int deleteProduct(ProductDTO productDTO) {
        int id = productDTO.getId();
        Product product = ProductMapper.INSTANCE.toEntity(productDTO); //entidad que le pasamos al dao para que elimine
        productDao.delete(product); //se elimina

        return id; //devuelve id de la entidad eliminada
    }
}
