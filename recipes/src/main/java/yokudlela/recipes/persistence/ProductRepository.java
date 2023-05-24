package yokudlela.recipes.persistence;

import org.springframework.data.repository.CrudRepository;
import yokudlela.recipes.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
