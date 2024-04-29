package co.com.hyunsedaProduct.domain.service;

import co.com.hyunsedaProduct.domain.entity.Category;
import co.com.hyunsedaProduct.presentatiton.exception.CategoryDomainException;
import co.com.hyunsedaProduct.presentatiton.exception.ProductDomainException;
import co.com.hyunsedaProduct.presentatiton.exception.ResourceNotFoundException;

import java.util.List;

/** Interfaz de operaciones de la base de datos de Categoria*/
public interface ICategoryService {

    List<Category> findAll();
    Category findById(Long id) throws ResourceNotFoundException;
    Category create(Category category) throws ProductDomainException;
    Category update(Long id, Category category) throws ProductDomainException, ResourceNotFoundException;
    void deleteById(Long id) throws ResourceNotFoundException;
}
