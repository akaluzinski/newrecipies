package eu.kaluzinski.recipies.services;

import eu.kaluzinski.recipies.model.Recipe;
import eu.kaluzinski.recipies.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public Set<Recipe> getRecipes() {
        Set<Recipe> recipeSet = new HashSet<>();
        log.debug("Get recipes");
        recipeRepository.findAll().iterator().forEachRemaining(recipeSet::add);
        return recipeSet;
    }
}
