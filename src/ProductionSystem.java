public class ProductionSystem {

    private Batch currentBatch;


    private boolean isContainerDirty;

    private InventorySystem inventory;


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



    public ProductionSystem(InventorySystem inventory) {

        currentBatch = null;
        this.inventory = inventory;
        isContainerDirty = false;

    }



    public void createBatch(Recipe recipe, int size) {
        if (isContainerDirty) {
            System.out.println("The container is dirty. Please clean it before creating a new batch.");
            return;
        }

        // Check if ingredients are available in the inventory
        Ingredient[] ingredientsRequired = recipe.getIngredients();
        for (int i = 0; i < recipe.getContents(); i++) {
            Ingredient requiredIngredient = ingredientsRequired[i];
            int requiredQuantity = (int) (requiredIngredient.getQuantity() * size);
            int availableQuantity = inventory.getQuantity(requiredIngredient.getName());

            if (requiredQuantity > availableQuantity) {
                System.out.println("Insufficient quantity of " + requiredIngredient.getName() + " in inventory.");
                return;
            }
        }

        // Deduct ingredients from the inventory
        for (int i = 0; i < recipe.getContents(); i++) {
            Ingredient requiredIngredient = ingredientsRequired[i];
            int requiredQuantity = (int) (requiredIngredient.getQuantity() * size);
            inventory.subtractIngredient(requiredIngredient.getName(), requiredQuantity);
        }

        currentBatch = new Batch(recipe, size);
        System.out.println("New batch of " + size + " servings for recipe " + recipe.getName() + " has been created.");
        isContainerDirty = true;
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

        if (currentBatch != null) {
            System.out.println("Cannot clean the container until the batch is bottled.");
            return;
        }
        isContainerDirty = false;
        System.out.println("Container has been cleaned.");

    }

}