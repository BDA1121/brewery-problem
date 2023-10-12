public class Recipe {
    private final int MAX_INGREDIENTS = 10;
    private int contents;
    private Ingredient[] ingredients;
    private String name;

    public Recipe(String name,Ingredient[] ingredients,int n) {
        this.name = name;
        this.ingredients = ingredients;
        this.contents = n;
    }

    public String getName() {
        return name;
    }

    public Ingredient[] getIngredients() {
        return ingredients;
    }

    public int getContents() {
        return contents;
    }

}
