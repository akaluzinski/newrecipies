package eu.kaluzinski.recipies.controller;

import eu.kaluzinski.recipies.model.Category;
import eu.kaluzinski.recipies.model.UnitOfMeasure;
import eu.kaluzinski.recipies.repositories.CategoryRepository;
import eu.kaluzinski.recipies.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(){
        Optional<Category> categoryOptional = categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> optionalUnit = unitOfMeasureRepository.findByDescription("Teaspoon");
        return "index";
    }


}
