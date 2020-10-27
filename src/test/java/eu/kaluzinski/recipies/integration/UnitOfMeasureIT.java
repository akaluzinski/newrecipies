package eu.kaluzinski.recipies.integration;

import eu.kaluzinski.recipies.model.UnitOfMeasure;
import eu.kaluzinski.recipies.repositories.UnitOfMeasureRepository;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UnitOfMeasureIT {

    @Autowired
    UnitOfMeasureRepository unitOfMeasureRepository;

    @Test
    public void shouldFindUnitOfMeasureByDescription() {
        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByDescription("Teaspoon");

        assertEquals(true, unitOfMeasureOptional.isPresent());
        assertEquals("Teaspoon", unitOfMeasureOptional.get().getDescription());
    }
}
