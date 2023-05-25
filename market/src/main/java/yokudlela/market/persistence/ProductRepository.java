package yokudlela.market.persistence;

import org.springframework.data.repository.CrudRepository;
import yokudlela.market.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
