package co.com.hyunsedaProduct.presentatiton;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import co.com.hyunsedaProduct.domain.entity.Product;
import co.com.hyunsedaProduct.domain.service.IProductService;
import co.com.hyunsedaProduct.presentatiton.exception.ProductDomainException;
import co.com.hyunsedaProduct.presentatiton.exception.ResourceNotFoundException;
import java.util.List;

/**Servicios web de productos*/

@RestController
@RequestMapping("products")
public class ProductController {
    @Autowired
    private IProductService productService;

    /**
     * Listar todos
     * @return listado de productos en json
     */
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Product> findAll() {
        return (List<Product>) productService.findAll();
    }

    /**
     * Listar un producto por id
     * @param id codigo
     * @return Producto en formato json
     * @throws Exception
     */
    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Product findById(@PathVariable Long id) throws ResourceNotFoundException {

        Product product = productService.findById(id);
        return product;
    }

    /**
     * Crear un producto
     * @param product producto
     * @return producto creado
     */

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Product create(@RequestBody Product product) throws ProductDomainException {
        return productService.create(product);
    }

    /**
     * Editar
     * @param product Producto a editar
     * @param id      codigo del producto
     * @return producto editado
     * @throws ResourceNotFoundException recurso no encontrado
     * @throws Exception                 Id no encontrado
     */
    @RequestMapping(value = "{id}", method = RequestMethod.PUT, produces = "application/json")
    @ResponseBody
    public Product update(@RequestBody Product product, @PathVariable Long id)
            throws ProductDomainException, ResourceNotFoundException {
        return productService.update(id, product);
    }

    /**
     * Eliminar
     * @param id codigo del producto
     * @throws ResourceNotFoundException id no encontrado
     */

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = "application/json")
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) throws ResourceNotFoundException {
        productService.deleteById(id);
    }
}
