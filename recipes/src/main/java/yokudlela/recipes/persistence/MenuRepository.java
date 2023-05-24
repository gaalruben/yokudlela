package yokudlela.recipes.persistence;

import org.springframework.data.repository.CrudRepository;
import yokudlela.recipes.model.Menu;

public interface MenuRepository extends CrudRepository<Menu, Long> {
}
