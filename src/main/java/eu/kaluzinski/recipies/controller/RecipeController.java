package eu.kaluzinski.recipies.controller;

import eu.kaluzinski.recipies.commands.RecipeCommand;
import eu.kaluzinski.recipies.exceptions.NotFoundException;
import eu.kaluzinski.recipies.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping("/recipe/show/{id}")
    public String showById(@PathVariable String id, Model model) {
        model.addAttribute("recipe", recipeService.getRecipeById(Long.valueOf(id)));
        return "recipe/show";
    }

    @RequestMapping("recipe/new")
    public String createRecipe(Model model){
        model.addAttribute("recipe", new RecipeCommand());

        return "recipe/createform";
    }

    @PostMapping
    @RequestMapping("recipe")
    public String saveOrUpdate(@ModelAttribute RecipeCommand command) {
        RecipeCommand savedCommand = recipeService.saveRecipeCommand(command);

        return String.format("redirect:/recipe/show/%d", savedCommand.getId());

    }

    @ExceptionHandler(NotFoundException.class)
    public ModelAndView handleNotFoundException() {
        return new ModelAndView("404error");
    }

}
