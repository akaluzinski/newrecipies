package eu.kaluzinski.recipies.repositories;

import eu.kaluzinski.recipies.model.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
