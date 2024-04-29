package co.com.hyunsedaItem.service;

import co.com.hyunsedaItem.entity.ItemProduct;
import co.com.hyunsedaItem.entity.Product;
import java.util.List;


public interface IItemProductService {

    List<ItemProduct> findAll();

    ItemProduct findById(Long id, Integer amount);

    Product create(Product product);

    Product update(Product product, Long id);

    void delete(Long id);
}
