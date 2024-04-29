package co.com.hyunsedaProduct.presentatiton;

import co.com.hyunsedaProduct.domain.entity.Category;
import co.com.hyunsedaProduct.domain.entity.Product;
import co.com.hyunsedaProduct.domain.service.ICategoryService;
import co.com.hyunsedaProduct.presentatiton.exception.ProductDomainException;
import co.com.hyunsedaProduct.presentatiton.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**Servicios web de categorias*/

@RestController
@RequestMapping("categories")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    /**
     * Crear una categoria
     * @param category categoria
     * @return categoria creado
     */
    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Category create(@RequestBody Category category) throws ProductDomainException {
        return categoryService.create(category);
    }
    /**
     * Editar
     * @param category Categoria a editar
     * @param id      codigo de la categoria
     * @return categoria editada
     * @throws ResourceNotFoundException recurso no encontrado
     * @throws Exception                 Id no encontrado
     */
    @RequestMapping(value = "{id}", method = RequestMethod.PUT, produces = "application/json")
    @ResponseBody
    public Category update(@RequestBody Category category, @PathVariable Long id)
            throws ProductDomainException, ResourceNotFoundException {
        return categoryService.update(id, category);
    }

    /**
     * Eliminar
     * @param id codigo de la categoria
     * @throws ResourceNotFoundException id no encontrado
     */
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = "application/json")
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) throws ResourceNotFoundException {
        categoryService.deleteById(id);
    }

    /**
     * Listar todos
     * @return listado de categorias en json
     */
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Category> findAll() {
        return (List<Category>) categoryService.findAll();
    }
    /**
     * Listar una categoria  por id
     * @param id codigo
     * @return Categoria en formato json
     * @throws Exception
     */
    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Category findById(@PathVariable Long id) throws ResourceNotFoundException {

        Category cate = categoryService.findById(id);
        return cate;
    }
}

