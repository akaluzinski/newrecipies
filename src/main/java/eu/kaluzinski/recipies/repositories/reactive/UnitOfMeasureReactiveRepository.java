package eu.kaluzinski.recipies.repositories.reactive;

import eu.kaluzinski.recipies.model.UnitOfMeasure;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface UnitOfMeasureReactiveRepository extends ReactiveCrudRepository<UnitOfMeasure, Long> {
}
