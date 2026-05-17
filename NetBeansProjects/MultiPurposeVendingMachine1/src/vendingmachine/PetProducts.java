package vendingmachine;


import vendingmachine.AbstractProduct;

public class PetProducts extends AbstractProduct{
    private String petType ;
    
    public PetProducts (int id, String slotId, String name, double price, int stockQuantity, String petType){
        super(id, slotId, name, price, stockQuantity);
        this.petType = petType;
        
    }
    public String getPetType(){
        return petType;
    }
}
