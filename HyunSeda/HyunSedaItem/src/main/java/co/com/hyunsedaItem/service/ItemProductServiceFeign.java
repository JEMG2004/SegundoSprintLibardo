package co.com.hyunsedaItem.service;

import co.com.hyunsedaItem.entity.ItemProduct;
import co.com.hyunsedaItem.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("serviceFeign")
public class ItemProductServiceFeign implements IItemProductService {

    @Autowired
    private IProductClientRest clientFeign;

    @Override
    public List<ItemProduct> findAll() {
        return clientFeign.list().stream().map(p -> new ItemProduct(p, 1)).collect(Collectors.toList());
    }

    @Override
    public ItemProduct findById(Long id, Integer amount) {
        return new ItemProduct(clientFeign.detail(id), amount);
    }

    @Override
    public Product create(Product product) {
        return clientFeign.create(product);
    }

    @Override
    public Product update(Product product, Long id) {
        return clientFeign.update(product, id);
    }

    @Override
    public void delete(Long id) {
        clientFeign.delete(id);
    }
}
