package co.com.hyunsedaProduct.access;
import co.com.hyunsedaProduct.domain.entity.Category;
import org.springframework.data.repository.CrudRepository;

/**Interfaces DAO de productos*/
public interface ICategoryDao extends CrudRepository<Category, Long> {
}
