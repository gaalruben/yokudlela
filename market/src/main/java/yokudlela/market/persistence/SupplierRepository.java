package yokudlela.market.persistence;

import org.springframework.data.repository.CrudRepository;
import yokudlela.market.model.Supplier;

public interface SupplierRepository extends CrudRepository<Supplier, Long> {
}
