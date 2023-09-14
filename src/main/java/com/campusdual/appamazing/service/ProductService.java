package com.campusdual.appamazing.service;

import com.campusdual.appamazing.api.IProductService;
import com.campusdual.appamazing.model.dao.IProductDao;
import com.campusdual.appamazing.model.dto.ProductDTO;
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
        return null;
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
