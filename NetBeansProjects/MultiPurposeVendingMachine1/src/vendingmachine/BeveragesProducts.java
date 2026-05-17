package vendingmachine;
public class BeveragesProducts extends AbstractProduct{
    private boolean isCooled ;
    
    public BeveragesProducts(int id, String slotId, String name, double price,int stockQuantity, boolean isCooled){
        super(id, slotId, name, price, stockQuantity);
        this.isCooled = isCooled;
    }
    public boolean isCooled(){
        return isCooled;
    }
    public void setCooled(boolean cooled){
        this.isCooled= cooled;
    }
}
