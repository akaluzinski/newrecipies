package eu.kaluzinski.recipies.converters;

import eu.kaluzinski.recipies.commands.CategoryCommand;
import eu.kaluzinski.recipies.model.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class CategoryToCategoryCommandTest {

    public static final Long ID_VALUE = 1L;
    public static final String DESCRIPTION = "descript";
    CategoryToCategoryCommand convter;

    @BeforeEach
    public void setUp() {
        convter = new CategoryToCategoryCommand();
    }

    @Test
    public void shouldNotConvertNull() {
        assertNull(convter.convert(null));
    }

    @Test
    public void shouldConvertEmptyObject() {
        assertNotNull(convter.convert(new Category()));
    }

    @Test
    public void shouldConvertCategory() {
        //given
        Category category = new Category();
        category.setId(ID_VALUE);
        category.setDescription(DESCRIPTION);

        //when
        CategoryCommand categoryCommand = convter.convert(category);

        //then
        assertEquals(ID_VALUE, categoryCommand.getId());
        assertEquals(DESCRIPTION, categoryCommand.getDescription());

    }

}
