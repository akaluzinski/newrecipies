package eu.kaluzinski.recipies.services;

import eu.kaluzinski.recipies.model.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();
}
