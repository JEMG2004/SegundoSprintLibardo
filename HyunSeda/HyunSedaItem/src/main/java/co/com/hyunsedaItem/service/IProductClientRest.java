package co.com.hyunsedaItem.service;

import java.util.List;

import co.com.hyunsedaItem.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;



@FeignClient(name = "hyunSedaProduct", url = "localhost:8001")
public interface IProductClientRest {

    @GetMapping("/products/")
    public List<Product> list();

    @GetMapping("/products/{id}")
    public Product detail(@PathVariable Long id);

    @PostMapping("/products")
    public Product create(@RequestBody Product product);

    @PutMapping("/products/{id}")
    public Product update(@RequestBody Product product, @PathVariable Long id);

    @DeleteMapping("/eliminar/{id")
    public void delete(@PathVariable Long id);
}
