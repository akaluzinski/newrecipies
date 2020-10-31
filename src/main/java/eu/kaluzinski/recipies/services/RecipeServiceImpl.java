package eu.kaluzinski.recipies.services;

import eu.kaluzinski.recipies.commands.RecipeCommand;
import eu.kaluzinski.recipies.converters.RecipeCommandToRecipe;
import eu.kaluzinski.recipies.converters.RecipeToRecipeCommand;
import eu.kaluzinski.recipies.exceptions.NotFoundException;
import eu.kaluzinski.recipies.model.Recipe;
import eu.kaluzinski.recipies.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;
    private final RecipeCommandToRecipe recipeCommandToRecipe;
    private final RecipeToRecipeCommand recipeToRecipeCommand;


    public RecipeServiceImpl(RecipeRepository recipeRepository, RecipeCommandToRecipe recipeCommandToRecipe, RecipeToRecipeCommand recipeToRecipeCommand) {
        this.recipeRepository = recipeRepository;
        this.recipeCommandToRecipe = recipeCommandToRecipe;
        this.recipeToRecipeCommand = recipeToRecipeCommand;
    }

    @Override
    public Set<Recipe> getRecipes() {
        Set<Recipe> recipeSet = new HashSet<>();
        log.debug("Get recipes");
        recipeRepository.findAll().iterator().forEachRemaining(recipeSet::add);
        return recipeSet;
    }

    @Override
    public Recipe getRecipeById(Long id) {
        Optional<Recipe> recipeOptional = recipeRepository.findById(id);

        if (!recipeOptional.isPresent()) {
            throw new NotFoundException(String.format("Recipe %d not found", id));
        }
        return recipeOptional.get();
    }

    @Override
    @Transactional
    public RecipeCommand saveRecipeCommand(RecipeCommand command) {
        Recipe savedRecipe = recipeRepository.save(recipeCommandToRecipe.convert(command));
        log.debug(String.format("Save recipe:%d", savedRecipe.getId()));
        return recipeToRecipeCommand.convert(savedRecipe);
    }
}
