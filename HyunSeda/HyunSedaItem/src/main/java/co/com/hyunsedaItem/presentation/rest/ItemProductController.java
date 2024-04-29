package co.com.hyunsedaItem.presentation.rest;

import co.com.hyunsedaItem.entity.ItemProduct;
import co.com.hyunsedaItem.entity.Product;
import co.com.hyunsedaItem.service.IItemProductService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Servicios web de Items
 */

@RestController
@RequestMapping("/items")
public class ItemProductController {

    @Autowired
    private IItemProductService itemService;

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<ItemProduct> findAll() {
        return itemService.findAll();
    }

    @GetMapping("/{id}/amount/{amount}")
    public ItemProduct findById(@PathVariable Long id, @PathVariable Integer amount) {
        return itemService.findById(id, amount);
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Product create(@RequestBody Product product) {
        return itemService.create(product);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Product update(@RequestBody Product producto, @PathVariable Long id) {
        return itemService.update(producto, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        itemService.delete(id);
    }

}
