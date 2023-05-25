package yokudlela.market.persistence;

import org.springframework.data.repository.CrudRepository;
import yokudlela.market.model.ConsumerProduct;

public interface ConsumerProductRepository extends CrudRepository<ConsumerProduct, Long> {
}
