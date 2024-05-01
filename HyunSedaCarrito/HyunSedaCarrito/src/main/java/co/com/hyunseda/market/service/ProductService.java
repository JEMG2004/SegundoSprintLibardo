package co.com.hyunseda.market.service;

import co.com.hyunseda.market.domain.Category;
import co.com.hyunseda.market.domain.Product;
import co.com.hyunseda.market.domain.acess.IProductRepository;
import co.com.hyunseda.market.infrastructure.Subject;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Laura Sofia
 */
public class ProductService {
    
    // Ahora hay una dependencia de una abstracción, no es algo concreto,
    // no sabe cómo está implementado.
    private Product product;
    private IProductRepository repository;

    /**
     * Inyección de dependencias en el constructor. Ya no conviene que el mismo
     * servicio cree un repositorio concreto
     *
     * @param repository una clase hija de IProductRepository
     */
    public ProductService(IProductRepository repository) {
        this.repository = repository; //NO HAY  new
                                       //Se hace por inyección de dependencia
    }

    public double calculateProductTax(Product product) {

        //Validate product.
        if (product == null) {
            return 0;
        }
        double TAX = 0.19d;
        double productTax = product.getProductPrice() * TAX;
        return productTax;
    }

    public boolean saveProduct(int productId,String productName,String productDescripcion, double productPrice, int stock, String keywords, String productCaracteristc, int categoryId) {
        ArrayList<Category> catsecundarias = new ArrayList<>();
        //Validate product
        Product newProduct = new Product();
        Category newCategory = new Category();
        
        newProduct.setProductId(productId);
        newProduct.setProductName(productName);
        newProduct.setProductDescripcion(productDescripcion);
        
        newProduct.setProductPrice(productPrice);
        newProduct.setProductStock(stock);
        newProduct.setKeywords(keywords);
        newProduct.setProductCaracteristc(productCaracteristc);
        
        newCategory.setCategoryId(categoryId);
        newCategory.setCategoryName("defecto");
        newProduct.setCategory(newCategory);
        catsecundarias.add(newCategory);
        newProduct.setCategoriasSecundarias(catsecundarias);
        if (/*newProduct.getProductId() < 0 || */newProduct.getProductName().isEmpty()) {
            return false;
        }
        
        return repository.save(newProduct);
    }
    
    public boolean saveProduct_Category(int productId,int categoryId) {

        //Validate product
        Product newProduct = new Product();
        Category newCategory = new Category();
        
        newProduct = repository.findById(productId);
        newCategory.setCategoryId(categoryId);
        newCategory.setCategoryName("default");
        //newCategory = repository.findByCategoryId(categoryId);
        System.out.println("HOLAA HASTA AHORA PRODUCTID: ");
        System.out.println(newProduct.getProductId());
        System.out.println("HOLAA HASTA AHORA CATEGORIAIDDD: ");
        System.out.println(newCategory.getCategoryId());
        if(newCategory == null){
            return false;
        }          
        return repository.saveProductCategory(newProduct,newCategory);
    }

    public List<Product> listProducts() {
        List<Product> products = new ArrayList<>();
        products = repository.findAll();

        return products;
    }
    
    public boolean editProduct(int productId, Product prod) {
        
        //Validate product
        if (prod == null || prod.getProductName().isEmpty() ) {
            return false;
        }
        repository.edit(productId, prod);
        return true;
    }
    
    public boolean deleteProduct(int productId){
        return repository.delete(productId);
    }
    
    public List<Product> findAllProducts() {
         List<Product> products = new ArrayList<>();
         products = repository.findAll();

         return products;
     }
    
   public Product findProductById(int productId) {
        return repository.findById(productId);
    }

    /**public Product getProduct() {
        return product;
    }*/
    
     public List<Product> findAllProductsByName(String productName) {
        List<Product> products = new ArrayList<>();
        products = repository.findAllByName(productName);

        return products;
    }
    public Product findProductByName(String name) {
        product = repository.findByName(name);
        return product;
    }

    public List<Product> findAllProductsByCategoryId(int id) {
        List<Product> products = new ArrayList<>();
        products = repository.findAllByCategoryId(id);

        return products;
    }
}
