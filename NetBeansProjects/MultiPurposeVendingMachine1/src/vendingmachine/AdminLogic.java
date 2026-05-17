package vendingmachine;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AdminLogic {

    private final VendingMachine machine;
    private final Scanner scanner;
    private final FileManager fileManager;

    // Constructor: Main sınıfından gelen nesneleri alıyoruz ve FileManager'ı başlatıyoruz
    public AdminLogic(VendingMachine machine, Scanner scanner) {
        this.machine = machine;
        this.scanner = scanner;
        this.fileManager = new FileManager();
    }
   
    public boolean verifyAdmin() {
        System.out.print("  Please Enter Admin Password: ");
        String pass = scanner.nextLine().trim();
        
        // FileManager üzerinden admin.txt dosyasındaki şifreyi kontrol eder
        boolean isAuthorized = fileManager.checkAdminPassword(pass);
        
        if (!isAuthorized) {
            System.out.println("  [X] Incorrect Password!");
        }
        return isAuthorized;
    }

    public void restock(String slot, int amountChanged) {
        try {
            // VendingMachine'deki gerçek stok güncelleme fonksiyonunu çağır
            machine.restock(slot, amountChanged);
            
            // Başarılı olursa değişiklikleri text dosyasına kaydet
            saveInventoryToFile();
            System.out.println("  [OK] " + slot + " slotuna " + amountChanged + " adet ürün eklendi.");
        } catch (Exception e) { // ProductNotFoundException yakalar
            System.out.println("  [X] Stock Could Not Get Updated: " + e.getMessage());
        }
    }

    // DİKKAT: int NewPrice, VendingMachine ile uyumlu olması için double yapıldı.
    public void reprice(String slot, double newPrice) {
        try {
            // VendingMachine'deki fiyat güncelleme fonksiyonunu çağır
            machine.reprice(slot, newPrice);
            
            // Başarılı olursa değişiklikleri text dosyasına kaydet
            saveInventoryToFile();
            System.out.printf("  [OK] %s slotunun yeni fiyatı $%.2f olarak ayarlandı.%n", slot, newPrice);
        } catch (Exception e) {
            System.out.println("  [X] Fiyat güncellenemedi: " + e.getMessage());
        }
    }

    // Main sınıfından çağrılan yönetici paneli döngüsü
    public void showMenu() {
        boolean adminActive = true;

        while (adminActive) {
            System.out.println("\n  +-------------------------------+");
            System.out.println("  |   ADMIN / YÖNETİCİ PANELİ     |");
            System.out.println("  +-------------------------------+");
            System.out.println("  |  1. Envanteri Görüntüle       |");
            System.out.println("  |  2. Ürün Stok Ekle            |");
            System.out.println("  |  3. Ürün Fiyatı Değiştir      |");
            System.out.println("  |  4. Kasadaki Parayı Çek       |");
            System.out.println("  |  0. Çıkış Yap                 |");
            System.out.println("  +-------------------------------+");
            System.out.print  ("  Seçiminiz: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    machine.printInventory();
                    break;
                case "2":
                    System.out.print("  Stok eklenecek slot (örn. A1): ");
                    String rSlot = scanner.nextLine().trim().toUpperCase();
                    System.out.print("  Eklenecek adet: ");
                    try {
                        int amount = Integer.parseInt(scanner.nextLine().trim());
                        restock(rSlot, amount);
                    } catch (NumberFormatException e) {
                        System.out.println("  [X] Geçersiz sayı girdiniz.");
                    }
                    break;
                case "3":
                    System.out.print("  Fiyatı değişecek slot (örn. A1): ");
                    String pSlot = scanner.nextLine().trim().toUpperCase();
                    System.out.print("  Yeni fiyat: $");
                    try {
                        double price = Double.parseDouble(scanner.nextLine().trim());
                        reprice(pSlot, price);
                    } catch (NumberFormatException e) {
                        System.out.println("  [X] Geçersiz fiyat girdiniz.");
                    }
                    break;
                case "4":
                    double collected = machine.collectRevenue();
                    System.out.printf("  [OK] Kasadan $%.2f çekildi.%n", collected);
                    // İstersen burada fileManager.updateVault() fonksiyonunu da sıfırlamak için çağırabilirsin
                    break;
                case "0":
                    System.out.println("  Yönetici panelinden çıkılıyor...");
                    adminActive = false;
                    break;
                default:
                    System.out.println("  [X] Geçersiz seçenek.");
            }
        }
    }

    /**
     * VendingMachine sınıfı "Product" arayüzü kullanırken, 
     * FileManager "AbstractProduct" sınıfı beklediği için ikisi arasında güvenli köprü kuran yardımcı metod.
     */
    private void saveInventoryToFile() {
        Map<String, AbstractProduct> toSave = new LinkedHashMap<>();
        // VendingMachine'den güncel haritayı alıp AbstractProduct formatına dönüştürüyoruz
        for (Map.Entry<String, AbstractProduct> entry : machine.getInventory().entrySet()) {
            if (entry.getValue() instanceof AbstractProduct) {
                toSave.put(entry.getKey(), (AbstractProduct) entry.getValue());
            }
        }
        fileManager.saveInventory(toSave);
    }
}