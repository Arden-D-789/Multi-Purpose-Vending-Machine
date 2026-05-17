package vendingmachine;

public class UserLogic {
    private VendingMachine machine = VendingMachine.getInstance();

    public boolean checkAvailability(String slot) {
        // VendingMachine'deki gerçek stok durumuna bakar 
        return machine.isAvailable(slot);
    }

    public double getItemPrice(String slot) {
        // VendingMachine'den gerçek fiyatı çeker 
        return machine.getPrice(slot);
    }

    public boolean processSale(String slot, double moneyInserted) {
        try {
            // Ürünü stoktan düşer ve kasaya parayı ekler 
            machine.dispense(slot);
            machine.addRevenue(moneyInserted);
            FileManager fm = new FileManager();
            fm.saveInventory(machine.getInventory());
            fm.updateVault(moneyInserted);
            AbstractProduct soldProduct = machine.getProductOrThrow(slot);
            fm.logSale(soldProduct.getName(), soldProduct.getPrice());
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}