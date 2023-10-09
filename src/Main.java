import java.util.Scanner;
public class Main {

    private static InventorySystem inventory = new InventorySystem();

    private static RecipeLibrary recipeLibrary = new RecipeLibrary();

    private static ProductionSystem production = new ProductionSystem();



    public static void main(String[] args) {

        while (true) {

            System.out.println("Brewery Control System Menu:");

            System.out.println("1. Add Ingredient to Inventory");

            System.out.println("2. View All Ingredients in Inventory");

            System.out.println("3. Add a Recipe");

            System.out.println("4. View All Recipes");

            System.out.println("5. Create a Batch");

            System.out.println("6. Bottle a Batch");

            System.out.println("7. Clean a Container");

            System.out.println("8. Exit");



            System.out.print("Enter your choice: ");

            int choice = new java.util.Scanner(System.in).nextInt();



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

//                case 4:
//
//                    viewAllRecipes();
//
//                    break;

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

    }



    private static void addIngredient() {

        System.out.print("Enter Ingredient Name: ");

        String name = new java.util.Scanner(System.in).nextLine();

        System.out.print("Enter Quantity: ");

        int quantity = new java.util.Scanner(System.in).nextInt();



        Ingredient ingredient = new Ingredient(name,quantity);

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

        String name = new java.util.Scanner(System.in).nextLine();



        Recipe recipe = new Recipe(name);

        recipeLibrary.addRecipe(recipe);

        System.out.println("Recipe Added Successfully!");

    }



    private static void createBatch() {

        System.out.print("Enter Recipe Name for Batch: ");

        String name = new java.util.Scanner(System.in).nextLine();



        Recipe recipe = recipeLibrary.getRecipe(name);

        if (recipe != null) {

            System.out.print("Enter batch size (no. of servings): ");

            int size = new java.util.Scanner(System.in).nextInt();



            // Assuming you have methods to create batch in the ProductionSystem

            production.createBatch(recipe, size);

            System.out.println("Batch Created Successfully!");

        } else {

            System.out.println("Recipe not found.");

        }

    }



    private static void bottleBatch() {

        // You can expand on this by selecting which batch to bottle if multiple batches exist

        production.bottleBatch();

        System.out.println("Batch Bottled Successfully!");

    }



    private static void cleanContainer() {

        production.cleanContainer();

        System.out.println("Container Cleaned Successfully!");

    }

}