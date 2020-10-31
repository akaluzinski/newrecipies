package eu.kaluzinski.recipies.services;

import eu.kaluzinski.recipies.commands.RecipeCommand;
import eu.kaluzinski.recipies.model.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();

    Recipe findById(Long l);

    RecipeCommand findCommandById(Long l);

    RecipeCommand saveRecipeCommand(RecipeCommand command);

    void deleteById(Long idToDelete);
}
