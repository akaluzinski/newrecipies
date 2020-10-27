package eu.kaluzinski.recipies.model;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

import static org.junit.jupiter.api.Assertions.*;

public class CategoryTest {

    Category category;

    @Before
    public void setUp(){
        category = new Category();
    }

    @Test
    public void shouldGetId() {
        Long expectedValue = 2l;

        category.setId(expectedValue);
        assertEquals(expectedValue, category.getId());
    }
}
