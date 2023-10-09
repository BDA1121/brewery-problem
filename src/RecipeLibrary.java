public class RecipeLibrary {
    private final int MAX_RECIPES = 100;
    private Recipe[] recipes;
    private int currentRecipeCount;

    public RecipeLibrary() {
        this.recipes = new Recipe[MAX_RECIPES];
        this.currentRecipeCount = 0;
    }

    public void addRecipe(Recipe recipe) {
        if(currentRecipeCount < MAX_RECIPES) {
            recipes[currentRecipeCount++] = recipe;
        } else {
            System.out.println("Recipe library is full!");
        }
    }

    public Recipe getRecipe(String name) {
        for (int i = 0; i < currentRecipeCount; i++) {
            if (recipes[i].getName().equals(name)) {
                return recipes[i];
            }
        }
        return null;
    }
}
