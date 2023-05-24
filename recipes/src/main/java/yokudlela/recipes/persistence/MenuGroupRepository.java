package yokudlela.recipes.persistence;

import org.springframework.data.repository.CrudRepository;
import yokudlela.recipes.model.MenuGroup;

public interface MenuGroupRepository extends CrudRepository<MenuGroup, Long> {
}
