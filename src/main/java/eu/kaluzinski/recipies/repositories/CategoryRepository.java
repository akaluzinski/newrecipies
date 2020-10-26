package eu.kaluzinski.recipies.repositories;

import eu.kaluzinski.recipies.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long>{

}
