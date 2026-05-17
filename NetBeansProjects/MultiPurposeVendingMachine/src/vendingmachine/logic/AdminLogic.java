package vendingmachine.logic;

import java.util.List;
import java.util.Scanner;
import vendingmachine.ProductNotFoundException;
import vendingmachine.VendingMachine;
import vendingmachine.data.FileManager;
import vendingmachine.products.AbstractProduct;

/**
 * Yönetici oturumu mantığını içerir (konsol arayüzü).
 * Main.java tarafından kullanılır.
 */
public class AdminLogic {

    private final VendingMachine machine;
    private final Scanner        scanner;
    private final FileManager    fileManager = new FileManager();

    public AdminLogic(VendingMachine machine, Scanner scanner) {
        this.machine = machine;
        this.scanner = scanner;
    }

    // ── Şifre doğrulama ───────────────────────────────────────

    /**
     * Admin şifresini doğrular.
     * @return Şifre doğruysa true
     */
    public boolean verifyAdmin() {
        System.out.print("\n  Admin Şifresi: ");
        String pw = scanner.nextLine().trim();
        if (fileManager.checkAdminPassword(pw)) {
            System.out.println("  [✓] Giriş başarılı. Hoş geldiniz, Admin.");
            return true;
        }
        System.out.println("  [X] Hatalı şifre. Erişim reddedildi.");
        return false;
    }

    // ── Ana admin menüsü ──────────────────────────────────────

    /** Admin menüsünü gösterir ve seçimleri işler. */
    public void showMenu() throws ProductNotFoundException {
        boolean active = true;
        while (active) {
            printMenu();
            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1": doViewRevenue();    break;
                case "2": doCollectRevenue(); break;
                case "3": doLowStock();       break;
                case "4": doRestock();        break;
                case "5": doReprice();        break;
                case "6": doChangePassword(); break;
                case "7": doAddProduct();     break;
                case "0":
                    System.out.println("  Admin oturumu kapatıldı.");
                    active = false;
                    break;
                default:
                    System.out.println("  [X] Geçersiz seçenek.");
            }
        }
    }

    private void printMenu() {
        System.out.println("\n  +====================================+");
        System.out.println("  |          ADMİN PANELİ              |");
        System.out.println("  +====================================+");
        System.out.println("  |  1. Geliri Görüntüle               |");
        System.out.println("  |  2. Geliri Topla                   |");
        System.out.println("  |  3. Düşük Stok Kontrolü            |");
        System.out.println("  |  4. Stok Yenile                    |");
        System.out.println("  |  5. Fiyat Güncelle                 |");
        System.out.println("  |  6. Şifre Değiştir                 |");
        System.out.println("  |  7. Yeni Ürün Ekle                 |");
        System.out.println("  |  0. Çıkış                          |");
        System.out.println("  +====================================+");
        System.out.print  ("  Seçim: ");
    }

    // ── İşlem metodları ───────────────────────────────────────

    private void doViewRevenue() {
        System.out.printf("  Toplam Gelir: $%.2f%n", machine.getTotalRevenue());
    }

    private void doCollectRevenue() {
        double collected = machine.collectRevenue();
        System.out.printf("  $%.2f toplandı. Kasa sıfırlandı.%n", collected);
    }

    private void doLowStock() {
        List<AbstractProduct> low = machine.getLowStockProducts();
        if (low.isEmpty()) {
            System.out.println("  Tüm ürünler yeterli stokta.");
        } else {
            System.out.println("  ⚠ DÜŞÜK STOK UYARISI:");
            for (AbstractProduct p : low) {
                System.out.printf("    Slot %-3s | %-16s | Kalan: %d adet%n",
                    p.getSlotId(), p.getName(), p.getStockQuantity());
            }
        }
    }

    private void doRestock() throws ProductNotFoundException {
        System.out.print("  Slot (örn. B3): ");
        String slot = scanner.nextLine().trim().toUpperCase();
        System.out.print("  Eklenecek miktar: ");
        try {
            int amount = Integer.parseInt(scanner.nextLine().trim());
            machine.restock(slot, amount);
            System.out.printf("  Slot %s'a %d adet eklendi.%n", slot, amount);
        } catch (NumberFormatException e) {
            System.out.println("  [X] Geçersiz sayı.");
        }
    }

    private void doReprice() throws ProductNotFoundException {
        System.out.print("  Slot: ");
        String slot = scanner.nextLine().trim().toUpperCase();
        System.out.print("  Yeni fiyat: $");
        try {
            double price = Double.parseDouble(scanner.nextLine().trim());
            machine.reprice(slot, price);
            System.out.printf("  Slot %s yeni fiyat: $%.2f%n", slot, price);
        } catch (NumberFormatException e) {
            System.out.println("  [X] Geçersiz fiyat.");
        }
    }

    private void doChangePassword() {
        System.out.print("  Yeni şifre: ");
        String pw = scanner.nextLine().trim();
        if (pw.isEmpty()) {
            System.out.println("  [X] Şifre boş bırakılamaz.");
            return;
        }
        fileManager.saveAdminPassword(pw);
        System.out.println("  Şifre güncellendi.");
    }

    private void doAddProduct() {
        System.out.print("  Yeni slot (örn. E1): ");
        String slot = scanner.nextLine().trim().toUpperCase();
        System.out.print("  Ürün adı: ");
        String name = scanner.nextLine().trim();
        System.out.print("  Fiyat: $");
        try {
            double price = Double.parseDouble(scanner.nextLine().trim());
            System.out.print("  Başlangıç stoğu: ");
            int stock = Integer.parseInt(scanner.nextLine().trim());
            machine.addNewProduct(slot, name, price, stock);
            System.out.printf("  '%s' ürünü slot %s'a eklendi ($%.2f, %d adet).%n",
                name, slot, price, stock);
        } catch (NumberFormatException e) {
            System.out.println("  [X] Geçersiz sayı girişi.");
        }
    }
}
