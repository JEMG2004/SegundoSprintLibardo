package co.com.hyunsedaProduct.access;

import co.com.hyunsedaProduct.domain.entity.Product;
import org.springframework.data.repository.CrudRepository;

/**Interfaces DAO de productos*/
public interface IProductDao extends CrudRepository<Product, Long> {


}
