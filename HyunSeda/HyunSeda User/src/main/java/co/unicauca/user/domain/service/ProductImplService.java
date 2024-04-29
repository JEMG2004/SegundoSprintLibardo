package co.unicauca.user.domain.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.unicauca.user.access.dao.IProductDao;
import co.unicauca.user.domain.entity.Product;
import co.unicauca.user.presentation.rest.exceptions.ResourceNotFoundException;
import co.unicauca.user.presentation.rest.exceptions.ProductDomainException;
import co.unicauca.user.presentation.rest.exceptions.ProductError;

/**
 * Implementación de la Interfaz IProductService
 * 
 * @author wpantoja, ahurtado
 *
 */

@Service
public class ProductImplService implements IProductService {
	/**
	 * Inyección de producto Dao
	 */
	@Autowired
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
	 * @param id identificador del producto
	 * @return objeto de tipo producto
	 */
	@Override // Para que esté sincronizada con la bd
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

		if (product.getCreateAt() == null) {
			product.setCreateAt(new Date());
		}

		return productDao.save(product);
	}

	/**
	 * Modifica o edita un producto
	 * 
	 * @param id,     identificador del producto a modificar
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

		prod.setName(product.getName());
		prod.setPrice(product.getPrice());

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

		if (product.getName() == null || product.getName().isBlank()) {
			errors.add(new ProductError(EnumErrorCodes.EMPTY_FIELD, "name", "El nombre del producto es obligatorio"));
		}

		if (product.getPrice() <= 0) {
			errors.add(new ProductError(EnumErrorCodes.INVALID_NUMBER, "price",
					"El precio del producto es obligatorio y mayor a cero"));
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
