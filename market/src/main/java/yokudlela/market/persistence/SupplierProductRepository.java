package yokudlela.market.persistence;

import org.springframework.data.repository.CrudRepository;
import yokudlela.market.model.SupplierProduct;

public interface SupplierProductRepository extends CrudRepository<SupplierProduct, Long> {
}
