package yokudlela.market.persistence;

import org.springframework.data.repository.CrudRepository;
import yokudlela.market.model.Consumer;

public interface ConsumerRepository extends CrudRepository<Consumer, Long> {
}
