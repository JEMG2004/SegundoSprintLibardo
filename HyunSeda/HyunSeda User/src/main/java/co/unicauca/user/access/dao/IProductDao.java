package co.unicauca.user.access.dao;


import org.springframework.data.repository.CrudRepository;

import co.unicauca.user.domain.entity.Product;


/**
 * Interfaces DAO de productos
 * @author wpantoja, ahurtado
 *
 */
public interface IProductDao extends CrudRepository<Product, Long> {

}