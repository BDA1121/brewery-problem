public class Beverage {
    private String name;
    private Ingredient[] ingredients;
    private int[] quantities;

    public Beverage(String name, Ingredient[] ingredients, int[] quantities) {
        this.name = name;
        this.ingredients = ingredients;
        this.quantities = quantities;
    }

    public String getName() {
        return name;
    }

    public Ingredient[] getIngredients() {
        return ingredients;
    }

    public int getQuantity(Ingredient ingredient) {
        for (int i = 0; i < ingredients.length; i++) {
            if (ingredients[i].getName().equals(ingredient.getName())) {
                return quantities[i];
            }
        }
        return 0; // Ingredient not found
    }
}
