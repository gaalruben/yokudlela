package yokudlela.recipes.persistence;

import org.springframework.data.repository.CrudRepository;
import yokudlela.recipes.model.MenuItem;

public interface MenuItemRepository extends CrudRepository<MenuItem, Long> {
}
