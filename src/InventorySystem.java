public class InventorySystem {

    public static class InventoryItem {
        private Ingredient ingredient;
        private int quantity;

        public InventoryItem(Ingredient ingredient, int quantity) {
            this.ingredient = ingredient;
            this.quantity = quantity;
        }

        public Ingredient getIngredient() {
            return ingredient;
        }

        public int getQuantity() {
            return quantity;
        }

        public void addQuantity(int amount) {
            this.quantity += amount;
        }

        public void subtractQuantity(int amount) {
            this.quantity -= amount;
        }
    }

    private InventoryItem[] items;
    private int itemCount;

    public InventorySystem() {
        this.items = new InventoryItem[10];  // assuming we won't have more than 10 ingredients for simplicity
        this.itemCount = 0;
    }

    public void addIngredient(Ingredient ingredient, int quantity) {
        for (int i = 0; i < itemCount; i++) {
            if (items[i].getIngredient().getName().equals(ingredient.getName())) {
                items[i].addQuantity(quantity);
                return;
            }
        }
        items[itemCount++] = new InventoryItem(ingredient, quantity);
    }

    public InventoryItem[] getAllItems() {
        return items;
    }
}
