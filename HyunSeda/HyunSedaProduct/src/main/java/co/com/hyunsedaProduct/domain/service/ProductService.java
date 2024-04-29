package co.com.hyunsedaProduct.domain.service;

import co.com.hyunsedaProduct.access.IProductDao;
import co.com.hyunsedaProduct.domain.entity.Product;
import co.com.hyunsedaProduct.presentatiton.exception.ProductDomainException;
import co.com.hyunsedaProduct.presentatiton.exception.ProductError;
import co.com.hyunsedaProduct.presentatiton.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements IProductService {

    /**
     * Inyección de producto Dao
     */
    @Autowired//permite realizar la inyección de independencia
    private IProductDao productDao;

    /**
     * Servicio para buscar todos los productos
     *
     * @return Listado de productos
     */
    @Override
    @Transactional(readOnly = true) // Para que esté sincronizada con la bd
    public List<Product> findAll() {
        return (List<Product>) productDao.findAll();
    }

    /**
     * Busca un producto por su Id
     *
     * @param id codigo del producto
     * @return objeto de tipo producto
     */
    @Override
    public Product findById(Long id) throws ResourceNotFoundException {
        Product prod = productDao.findById(id).orElse(null);
        if (prod == null) {
            throw new ResourceNotFoundException();
        }
        return prod;
    }

    /**
     * Crea un nuevo producto
     *
     * @param product producto a crear en la bd
     * @return Producto creado
     */
    @Override
    @Transactional
    public Product create(Product product) throws ProductDomainException {
        List<ProductError> errors = validateDomain(product);

        if (!errors.isEmpty()) {
            throw new ProductDomainException(errors);
        }
        /*if (product.getCreateAt() == null) {
            product.setCreateAt(new Date());}*/
        return productDao.save(product);
    }

    /**
     * Modifica o edita un producto
     *
     * @param id,     codigo del producto a modificar
     * @param product producto con los datos a editar
     * @return Producto modificado
     */
    @Override
    @Transactional
    public Product update(Long id, Product product) throws ProductDomainException, ResourceNotFoundException {
        Product prod = this.findById(id);
        if (prod == null) {
            throw new ResourceNotFoundException();
        }

        List<ProductError> errors = validateDomain(product);

        if (!errors.isEmpty()) {
            throw new ProductDomainException(errors);
        }

        prod.setProductName(product.getProductName());
        prod.setProductPrice(product.getProductPrice());

        return productDao.save(prod);
    }

    /**
     * Aplica validaciones o reglas del dominio para un producto. Antes de ser
     * agregado o modificado.
     *
     * @param product producto a validad
     * @return lista de errores de validación
     */

    private List<ProductError> validateDomain(Product product) {
        List<ProductError> errors = new ArrayList<>();

        if (product.getProductId() <= 0) {
            errors.add(new ProductError(ErrorCodes.INVALID_NUMBER, "codigo",
                    "El codigo del producto es obligatorio y mayor a cero"));
        }
        if (product.getProductName() == null || product.getProductName().isBlank()) {
            errors.add(new ProductError(ErrorCodes.EMPTY_FIELD, "name", "El nombre del producto es obligatorio"));
        }

        if (product.getProductPrice() <= 0) {
            errors.add(new ProductError(ErrorCodes.INVALID_NUMBER, "price",
                    "El precio del producto es obligatorio y mayor a cero"));
        }
        if (product.getProductStock() <= 0 || product.getProductStock() > 1) {
            errors.add(new ProductError(ErrorCodes.INVALID_NUMBER, "cantidad",
                    "La cantidad del producto es obligatorio y debe estar entre 0 - 1"));
        }
        return errors;
    }

    /**
     * Eliminar producto por su id
     *
     * @param id identificador del producto a eliminar
     */
    @Override
    @Transactional
    public void deleteById(Long id) throws ResourceNotFoundException {
        Product prod = this.findById(id);
        if (prod == null) {
            throw new ResourceNotFoundException();
        }
        productDao.deleteById(id);
    }

}
