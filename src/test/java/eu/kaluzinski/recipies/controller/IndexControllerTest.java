package eu.kaluzinski.recipies.controller;

import eu.kaluzinski.recipies.services.RecipeService;
import lombok.SneakyThrows;
import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.Set;

import static eu.kaluzinski.recipies.model.RecipeTest.generateRecipes;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class IndexControllerTest {

    @Mock
    RecipeService recipeService;

    @Mock
    Model model;

    IndexController indexController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        indexController = new IndexController(recipeService);
        when(recipeService.getRecipes()).thenReturn(generateRecipes());
    }

    @Test
    public void shouldReturnIndexPage() {
        //when
        String viewName = indexController.getIndexPage(model);

        //then
        assertEquals("index", viewName);
    }


    @Test
    public void shouldCreateModel() {
        //given
        val argumentCaptor = ArgumentCaptor.forClass(Set.class);

        //when
        indexController.getIndexPage(model);

        //then
        verify(model, times(1)).addAttribute(eq("recipes"), argumentCaptor.capture());
        val setInController = argumentCaptor.getValue();
        assertEquals(2, setInController.size());
    }

    @SneakyThrows
    @Test
    public void shouldReturn200WithIndexView() {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }
}
