package eu.kaluzinski.recipies.model;

import eu.kaluzinski.recipies.converters.RecipeCommandToRecipe;
import eu.kaluzinski.recipies.converters.RecipeToRecipeCommand;
import eu.kaluzinski.recipies.repositories.RecipeRepository;
import eu.kaluzinski.recipies.services.RecipeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class RecipeTest {

    RecipeServiceImpl recipeService;

    @Mock
    RecipeRepository recipeRepository;

    @Mock
    RecipeToRecipeCommand recipeToRecipeCommand;

    @Mock
    RecipeCommandToRecipe recipeCommandToRecipe;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        recipeService = new RecipeServiceImpl(recipeRepository, recipeCommandToRecipe, recipeToRecipeCommand);
    }

    @Test
    public void shouldGetRecipeById() {
        Recipe recipe = new Recipe();
        recipe.setId(1L);
        Optional<Recipe> recipeOptional = Optional.of(recipe);

        when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);

        Recipe recipeReturned = recipeService.findById(1L);

        assertNotNull(recipeReturned);
        verify(recipeRepository, times(1)).findById(anyLong());
        verify(recipeRepository, never()).findAll();
    }

    @Test
    public void shouldGetRecipes() {
        when(recipeRepository.findAll()).thenReturn(generateRecipes());

        Set<Recipe> recipes = recipeService.getRecipes();
        assertEquals(recipes.size(), 2);
        verify(recipeRepository, times(1)).findAll();
    }

    public static Set<Recipe> generateRecipes() {
        Recipe recipe1 = new Recipe();
        recipe1.setId(1l);

        Recipe recipe2 = new Recipe();
        recipe2.setId(2l);

        Set<Recipe> recipesRepo = new HashSet<>();
        recipesRepo.add(recipe1);
        recipesRepo.add(recipe2);
        return recipesRepo;
    }

}
