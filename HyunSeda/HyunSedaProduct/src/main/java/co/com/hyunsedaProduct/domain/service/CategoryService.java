package co.com.hyunsedaProduct.domain.service;

import co.com.hyunsedaProduct.access.ICategoryDao;
import co.com.hyunsedaProduct.domain.entity.Category;
import co.com.hyunsedaProduct.presentatiton.exception.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Service
public class CategoryService implements ICategoryService {

    /**Inyección de categoria Dao*/
    @Autowired//permite realizar la inyección de independencia
    private ICategoryDao categoryDao;

    /**
     * Servicio para buscar todos las categorias
     * @return Listado de categorias
     */
    @Override
    @Transactional(readOnly = true) // Para que esté sincronizada con la bd
    public List<Category> findAll() {
        return (List<Category>) categoryDao.findAll();
    }

    /**
     * Busca una categoria por su Id
     * @param id codigo de la categoria
     * @return objeto de tipo categoria
     */
    @Override // Para que esté sincronizada con la bd
    public Category findById(Long id) throws ResourceNotFoundException {
        Category cate = categoryDao.findById(id).orElse(null);
        if (cate == null) {
            throw new ResourceNotFoundException();
        }
        return cate ;
    }

    /**
     * Crea una nueva categoria
     * @param category categoria a crear en la bd
     * @return Categoria creada
     */
    @Override
    @Transactional
    public Category create(Category category) throws ProductDomainException {
        List<ProductError> errors = validateDomain(category);
        if (!errors.isEmpty()) {
            throw new ProductDomainException(errors);
        }
        return categoryDao.save(category);
    }

    /**
     * Modifica o edita una categoria
     * @param id, codigo de la categoria a modificar
     * @param category categoria con los datos a editar
     * @return Categoria modificado
     */
    @Override
    @Transactional
    public Category update(Long id, Category category) throws ProductDomainException, ResourceNotFoundException {
        Category cate = this.findById(id);
        if (cate == null) {
            throw new ResourceNotFoundException();
        }

        List<ProductError> errors = validateDomain(category);

        if (!errors.isEmpty()) {
            throw new ProductDomainException(errors);
        }
        cate.setCategoryName(category.getCategoryName());
        return categoryDao.save(cate);
    }

    /**
     * Aplica validaciones o reglas del dominio para una Categoria. Antes de ser
     * agregado o modificado.
     *
     * @param category categoria a validar
     * @return lista de errores de validación
     */

    private List<ProductError> validateDomain(Category category) {
        List<ProductError> errors = new ArrayList<>();
        if(category.getCategoryId() <= 0){
            errors.add(new ProductError(ErrorCodes.INVALID_NUMBER, "codigo",
                    "El codigo de la categoria es obligatorio y mayor a cero"));
        }
        if (category.getCategoryName() == null || category.getCategoryName().isBlank()) {
            errors.add(new ProductError(ErrorCodes.EMPTY_FIELD, "name", "El nombre de la categoria es obligatoria"));
        }
        return errors;
    }
    /**
     * Eliminar categoria por su id
     * @param id codigo de la categoria a eliminar
     */
    @Override
    @Transactional
    public void deleteById(Long id) throws ResourceNotFoundException {
        Category cate = this.findById(id);
        if (cate == null) {
            throw new ResourceNotFoundException();
        }
        categoryDao.deleteById(id);
    }
}


