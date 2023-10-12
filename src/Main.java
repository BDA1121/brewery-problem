import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
//    Instantiating the necessary objects
    private static InventorySystem inventory = new InventorySystem();
    private static RecipeLibrary recipeLibrary = new RecipeLibrary();
    private static ProductionSystem production;

    public static void main(String[] args) {
        production = new ProductionSystem(inventory);
//printing possible actions in a loop until u exit it
        while (true) {
            System.out.println("------------------------------------------");
            System.out.println("------------------------------------------");
            System.out.println("Brewery Control System Menu:");
            System.out.println("1. Add Ingredient to the Inventory");
            System.out.println("2. View All Ingredients in Inventory");
            System.out.println("3. Add a Recipe");
            System.out.println("4. View All Recipes");
            System.out.println("5. Create a Batch");
            System.out.println("6. Bottle a Batch");
            System.out.println("7. Clean a Container");
            System.out.println("8. Exit");

            System.out.print("Enter your choice: ");
//            a try catch method to check if input type is the same as the one required which is int
            try
            {
                int choice = new Scanner(System.in).nextInt();
// switch case to call the respective functions
                switch (choice) {
                    case 1:
                        addIngredient();
                        break;
                    case 2:
                        viewAllIngredients();
                        break;
                    case 3:
                        addRecipe();
                        break;
                    case 4:
                        viewAllRecipes();
                        break;
                    case 5:
                        createBatch();
                        break;
                    case 6:
                        bottleBatch();
                        break;
                    case 7:
                        cleanContainer();
                        break;
                    case 8:
                        System.out.println("Exiting.");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }



            }
            catch(InputMismatchException ex)
            {
                System.out.println("Unexcpected input, input an integer" );



            }

        }
    }



    private static void addIngredient() {
        System.out.print("Enter Ingredient Name: ");
        String name = new Scanner(System.in).nextLine();

        // Check if the ingredient already exists in the inventory
        for (InventorySystem.InventoryItem item : inventory.getAllItems()) {
            if (item != null && item.getIngredient().getName().equals(name)) {
                System.out.print("Enter Quantity to Add: ");
                int quantity = new Scanner(System.in).nextInt();
                item.addQuantity(quantity);
                System.out.println("Quantity Updated Successfully!");
                return;
            }
        }

        // If the ingredient doesn't exist, add it to the inventory
        System.out.print("Enter Quantity: ");
        int quantity = new Scanner(System.in).nextInt();
        Ingredient ingredient = new Ingredient(name, quantity);
        inventory.addIngredient(ingredient, quantity);
        System.out.println("Ingredient Added Successfully!");
    }


    private static void viewAllIngredients() {
        System.out.println("Current Inventory:");
        for (InventorySystem.InventoryItem item : inventory.getAllItems()) {
            if (item != null) {
                System.out.println(item.getIngredient().getName() + ": " + item.getQuantity());
            }
        }
    }

    private static void addRecipe() {
        System.out.print("Enter Recipe Name: ");
        String name = new Scanner(System.in).nextLine();
        System.out.print("Enter the number of ingredients: ");
        int n = new Scanner(System.in).nextInt();
        Ingredient[] ingredients = new Ingredient[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter Ingredient Name: ");
            String nameIng = new Scanner(System.in).nextLine();
            System.out.print("Enter Quantity: ");
            double quantity = new Scanner(System.in).nextDouble();
            ingredients[i] = new Ingredient(nameIng, quantity);
        }
        Recipe recipe = new Recipe(name, ingredients,n);
        recipeLibrary.addRecipe(recipe);
        System.out.println("Recipe for one serving of "+name+" Added Successfully!");
    }
    private static void viewAllRecipes() {
        System.out.println("Recipe Library:");
        for (Recipe recipe : recipeLibrary.getAllRecipes()) {
            System.out.println(recipe.getName());
        }
    }

    private static void createBatch() {
        System.out.print("Enter Recipe Name for Batch: ");
        String name = new Scanner(System.in).nextLine();
        Recipe recipe = recipeLibrary.getRecipe(name);
        if (recipe != null) {
            System.out.print("Enter batch size (no. of servings): ");
            int size = new Scanner(System.in).nextInt();
            production.createBatch(recipe, size);
        } else {
            System.out.println("Recipe not found.");
        }
    }

    private static void bottleBatch() {
        production.bottleBatch();
        System.out.println("Batch Bottled Successfully!");
    }

    private static void cleanContainer() {
        production.cleanContainer();
    }
}
