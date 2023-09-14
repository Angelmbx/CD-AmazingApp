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
