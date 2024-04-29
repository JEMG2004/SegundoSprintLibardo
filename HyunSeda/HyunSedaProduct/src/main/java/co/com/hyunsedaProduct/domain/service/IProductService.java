package co.com.hyunsedaProduct.domain.service;

import java.util.List;

import co.com.hyunsedaProduct.domain.entity.Product;
import co.com.hyunsedaProduct.presentatiton.exception.ProductDomainException;
import co.com.hyunsedaProduct.presentatiton.exception.ResourceNotFoundException;
import org.springframework.data.jpa.repository.Query;

/** Interfaz de operaciones de la base de datos de productos*/

public interface IProductService {

    List<Product> findAll();
    Product findById(Long id) throws ResourceNotFoundException;
    Product create(Product product) throws ProductDomainException;
    Product update(Long id, Product product) throws ProductDomainException, ResourceNotFoundException;
    void deleteById(Long id) throws ResourceNotFoundException;





}
