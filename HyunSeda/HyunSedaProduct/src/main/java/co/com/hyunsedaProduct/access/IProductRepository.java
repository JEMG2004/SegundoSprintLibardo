package co.com.hyunsedaProduct.access;

import co.com.hyunsedaProduct.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IProductRepository extends JpaRepository<Product,Long> {

    //List<Product> findByNombre(String nombre);

   /* // Consulta buscar por categoria
    @Query("SELECT prodCat FROM productCategory prodCat WHERE prodCat.category_Name LIKE %?1% ORDER BY prod.category_Name")
    List<Product> buscarUsuariosPorCategoria(String category);*/
}
