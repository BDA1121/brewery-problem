public class ProductionSystem {

    private Batch currentBatch;

    private boolean isContainerDirty;



    // A nested class to represent a batch.

    // You can expand this class to have more attributes, such as expiration date, production date, etc.

    private static class Batch {

        private Recipe recipe;

        private int size;



        public Batch(Recipe recipe, int size) {

            this.recipe = recipe;

            this.size = size;

        }



        public Recipe getRecipe() {

            return recipe;

        }



        public int getSize() {

            return size;

        }

    }



    public ProductionSystem() {

        currentBatch = null;

        isContainerDirty = false;

    }



    public void createBatch(Recipe recipe, int size) {

        if (isContainerDirty) {

            System.out.println("The container is dirty. Please clean it before creating a new batch.");

            return;

        }



        // Check if ingredients are available. For this example, I'm skipping this check.

        // In a real scenario, you'll need to interact with the InventorySystem to ensure

        // you have enough of each ingredient for the recipe.



        currentBatch = new Batch(recipe, size);

        System.out.println("New batch of " + size + " servings for recipe " + recipe.getName() + " has been created.");



        // Reduce the ingredients from the inventory after creating a batch.

        // You'd typically do this by iterating over the ingredients in the recipe and

        // deducting them from the InventorySystem.

    }



    public void bottleBatch() {

        if (currentBatch == null) {

            System.out.println("No batch is available to bottle.");

            return;

        }

        System.out.println("Batch of recipe " + currentBatch.getRecipe().getName() + " with " + currentBatch.getSize() + " servings has been bottled.");

        isContainerDirty = true; // set the container as dirty after bottling

        currentBatch = null; // set current batch to null after bottling

    }



    public void cleanContainer() {

        isContainerDirty = false;

        System.out.println("Container has been cleaned.");

    }

}