package yokudlela.recipes.persistence;

import org.springframework.data.repository.CrudRepository;
import yokudlela.recipes.model.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
