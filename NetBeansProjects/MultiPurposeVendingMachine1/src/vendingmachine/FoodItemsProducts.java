package vendingmachine;

public class FoodItemsProducts extends AbstractProduct {
    private int calorieCount ;
    
    public FoodItemsProducts(int id, String slotId, String name, double price, int stockQuantity, int calorieCount){
        super(id, slotId, name, price, stockQuantity);
        this.calorieCount = calorieCount ;
    }
    
    public int getCalorieCount(){
        return calorieCount;
    }
}
