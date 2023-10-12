import org.junit.Assert.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecipeLibraryTest {

    RecipeLibrary check = new RecipeLibrary();
    @Test
    void addRecipe() {
        Ingredient ingredient1 = new Ingredient("orange",2);
        Ingredient ingredient2 = new Ingredient("water",1);
        Ingredient[] ingredients = new Ingredient[10];
        ingredients[0]= ingredient1;
        ingredients[1]= ingredient2;
        Recipe recipe = new Recipe("Orange Juice",ingredients,2);
        check.addRecipe(recipe);
        assertEquals(recipe,check.getRecipe("Orange Juice"));
    }

    @Test
    void getRecipe() {
        Ingredient ingredient1 = new Ingredient("orange",2);
        Ingredient ingredient2 = new Ingredient("water",1);
        Ingredient[] ingredients = new Ingredient[10];
        ingredients[0]= ingredient1;
        ingredients[1]= ingredient2;
        Recipe recipe = new Recipe("Orange Juice",ingredients,2);
        check.addRecipe(recipe);
        assertEquals(recipe,check.getRecipe("Orange Juice"));
    }
}