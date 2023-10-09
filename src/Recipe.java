public class Recipe {
    private final int MAX_INGREDIENTS = 10; // Assuming a max of 10 ingredients per recipe for simplicity
    private Ingredient[] ingredients;
    private String name;
    private int currentIngredientCount;
    private int numberOfBottles;

    public Recipe(String name) {
        this.name = name;
        this.ingredients = new Ingredient[MAX_INGREDIENTS];
        this.currentIngredientCount = 0;
    }

    public String getName() {
        return name;
    }

    public void addIngredient(Ingredient ingredient) {
        if(currentIngredientCount < MAX_INGREDIENTS) {
            ingredients[currentIngredientCount++] = ingredient;
        } else {
            System.out.println("Recipe ingredient list is full!");
        }
    }

    public Ingredient[] getIngredients() {
        return ingredients;
    }

    public void setNumberOfBottles(int number) {
        this.numberOfBottles = number;
    }

    public int getNumberOfBottles() {
        return numberOfBottles;
    }
}
