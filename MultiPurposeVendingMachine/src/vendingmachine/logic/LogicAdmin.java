package vendingmachine.logic;

import vendingmachine.ProductNotFoundException;
import vendingmachine.ProductNotFoundException;
import vendingmachine.VendingMachine;
import vendingmachine.VendingMachine;
import vendingmachine.data.FileManager;

/**
 * Yönetici işlemlerinin mantığını içerir.
 * AdminGUI tarafından kullanılır.
 *
 * Tüm veri erişimi VendingMachine singleton'ı üzerinden yapılır;
 * şifre yönetimi FileManager üzerinden sağlanır.
 */
public class LogicAdmin {

    private final VendingMachine machine     = VendingMachine.getInstance();
    private final FileManager    fileManager = new FileManager();

    // ── Gelir işlemleri ───────────────────────────────────────

    /** Mevcut toplam geliri döndürür (kasayı sıfırlamaz). */
    public double getTotalRevenue() {
        return machine.getTotalRevenue();
    }

    /** Kasadaki tüm geliri toplar, kasayı sıfırlar ve toplamı döndürür. */
    public double collectRevenue() {
        return machine.collectRevenue();
    }

    // ── Envanter işlemleri ────────────────────────────────────

    /**
     * Belirtilen slot'un stok miktarını artırır.
     *
     * @param slot   Slot kodu (örn. "B3")
     * @param amount Eklenecek adet
     * @throws ProductNotFoundException Slot bulunamazsa
     */
    public void restock(String slot, int amount) throws ProductNotFoundException {
        machine.restock(slot.toUpperCase(), amount);
    }

    /**
     * Belirtilen slot'un fiyatını günceller.
     *
     * @param slot     Slot kodu
     * @param newPrice Yeni fiyat
     * @throws ProductNotFoundException Slot bulunamazsa
     */
    public void reprice(String slot, double newPrice) throws ProductNotFoundException {
        machine.reprice(slot.toUpperCase(), newPrice);
    }

    /**
     * Yeni bir ürün ekler veya var olan slotu günceller.
     *
     * @param slot  Slot kodu
     * @param name  Ürün adı
     * @param price Fiyat
     * @param stock Başlangıç stoğu
     */
    public void addNewProduct(String slot, String name, double price, int stock) {
        machine.addNewProduct(slot.toUpperCase(), name, price, stock);
    }

    // ── Şifre işlemleri ───────────────────────────────────────

    /**
     * Admin şifresini değiştirir (FileManager aracılığıyla kalıcı olarak).
     *
     * @param newPassword Yeni şifre (boş olamaz)
     */
    public void changePassword(String newPassword) {
        if (newPassword == null || newPassword.trim().isEmpty()) {
            throw new IllegalArgumentException("Şifre boş olamaz.");
        }
        fileManager.saveAdminPassword(newPassword.trim());
    }
}
