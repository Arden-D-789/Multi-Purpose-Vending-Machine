package vendingmachine;

import vendingmachine.AbstractProduct;

public class TechnologicalProducts extends AbstractProduct {
    private String deviceType ;
    
    public TechnologicalProducts( int id, String slotId, String name, double price, 
                                  int stockQuantity, String deviceType){
        super(id,slotId, name, price,stockQuantity);
        this.deviceType = deviceType ;
    }
    public String getDeviceType(){
        return deviceType;
    }
}
