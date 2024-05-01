package co.com.hyunseda.market.domain.acess;

import co.com.hyunseda.market.domain.Category;
import co.com.hyunseda.market.domain.Product;
import java.util.ArrayList;
import java.util.List;

public interface IProductRepository {
       
    List<Product> findAllByCategoryId(int categoryId);
    
    
    List<Product> findAll();
    List<Product> findAllByName(String productName);
    Category findByCategoryId(int category);
    boolean save(Product newProduct); //Lo guarda en un repositorio
    boolean saveProductCategory(Product newProduct,Category newCategory);
    
    public Product findByName(String name); // Método para buscar un producto por nombre
    boolean edit(int productId, Product product);
    boolean delete(int productId);
    Product findById(int productId);
}
 

