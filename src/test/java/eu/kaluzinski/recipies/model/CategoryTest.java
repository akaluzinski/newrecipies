package eu.kaluzinski.recipies.model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CategoryTest {

    Category category;

    @BeforeEach
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
