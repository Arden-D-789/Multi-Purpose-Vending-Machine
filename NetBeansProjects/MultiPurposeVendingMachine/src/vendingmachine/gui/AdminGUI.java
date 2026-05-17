package vendingmachine.gui;

import vendingmachine.gui.TestGUI;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import vendingmachine.ProductNotFoundException;
import vendingmachine.ProductNotFoundException;
import vendingmachine.VendingMachine;
import vendingmachine.VendingMachine;
import vendingmachine.logic.LogicAdmin;
import vendingmachine.products.AbstractProduct;

/**
 * Admin (yönetici) paneli penceresi.
 *
 * <p>Bileşenler:
 * <ul>
 *   <li><b>txtAdminScreen</b> – işlem çıktıları</li>
 *   <li><b>txtSlot</b>        – slot kodu girişi</li>
 *   <li><b>txtValue</b>       – yeni fiyat / stok miktarı girişi</li>
 *   <li><b>txtChangePassword</b> – yeni şifre veya AddProduct'ta stok miktarı</li>
 * </ul>
 *
 * <p>Şifre değiştirmek için txtChangePassword'ı kullanın.
 * Ürün eklemek için: Slot → txtSlot, Fiyat → txtValue, Stok → txtChangePassword,
 * ardından "Add Product" düğmesine basın; isim JOptionPane ile sorulur.
 */
public class AdminGUI extends javax.swing.JFrame {

    private static final Logger logger = Logger.getLogger(AdminGUI.class.getName());

    // ── Constructor ───────────────────────────────────────────
    public AdminGUI() {
        initComponents();
        setTitle("Admin Paneli");
        txtAdminScreen.setText("Admin Paneline Hoş Geldiniz.\n");
        txtAdminScreen.append("Bir işlem seçin.\n");
        txtAdminScreen.append("-------------------------------------\n");
    }

    // ── initComponents ────────────────────────────────────────
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1      = new javax.swing.JScrollPane();
        txtAdminScreen    = new javax.swing.JTextArea();
        jScrollPane2      = new javax.swing.JScrollPane();
        txtChangePassword = new javax.swing.JTextArea();
        jScrollPane3      = new javax.swing.JScrollPane();
        txtSlot           = new javax.swing.JTextArea();
        jScrollPane4      = new javax.swing.JScrollPane();
        txtValue          = new javax.swing.JTextArea();
        btnCollectRevenue = new javax.swing.JButton();
        btnViewRevenue    = new javax.swing.JButton();
        btnCheckLowStock  = new javax.swing.JButton();
        btnRestock        = new javax.swing.JButton();
        btnReprice        = new javax.swing.JButton();
        btnChangePassword = new javax.swing.JButton();
        btnAddProduct     = new javax.swing.JButton();
        btnLogOut         = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        // ── txtAdminScreen (sol, büyük alan)
        txtAdminScreen.setColumns(20);
        txtAdminScreen.setRows(5);
        txtAdminScreen.setEditable(false);
        txtAdminScreen.setLineWrap(true);
        txtAdminScreen.setWrapStyleWord(true);
        jScrollPane1.setViewportView(txtAdminScreen);

        // ── txtChangePassword (şifre / stok girişi)
        txtChangePassword.setColumns(20);
        txtChangePassword.setRows(5);
        txtChangePassword.setBorder(
            javax.swing.BorderFactory.createTitledBorder("New Password / Stock"));
        jScrollPane2.setViewportView(txtChangePassword);

        // ── txtSlot
        txtSlot.setColumns(20);
        txtSlot.setRows(5);
        txtSlot.setBorder(
            javax.swing.BorderFactory.createTitledBorder("Slot ID"));
        jScrollPane3.setViewportView(txtSlot);

        // ── txtValue
        txtValue.setColumns(20);
        txtValue.setRows(5);
        txtValue.setBorder(
            javax.swing.BorderFactory.createTitledBorder("New Price / Restock Amount"));
        jScrollPane4.setViewportView(txtValue);

        // ── Düğmeler
        btnCollectRevenue.setText("Collect Revenue");
        btnCollectRevenue.addActionListener(this::btnCollectRevenueActionPerformed);

        btnViewRevenue.setText("View Revenue");
        btnViewRevenue.addActionListener(this::btnViewRevenueActionPerformed);

        btnCheckLowStock.setText("Check Low Stock");
        btnCheckLowStock.addActionListener(this::btnCheckLowStockActionPerformed);

        btnRestock.setText("Restock");
        btnRestock.addActionListener(this::btnRestockActionPerformed);

        btnReprice.setText("Reprice");
        btnReprice.addActionListener(this::btnRepriceActionPerformed);

        btnChangePassword.setText("Change Password");
        btnChangePassword.addActionListener(this::btnChangePasswordActionPerformed);

        btnAddProduct.setText("Add Product");
        btnAddProduct.addActionListener(this::btnAddProductActionPerformed);

        btnLogOut.setText("Log Out");
        btnLogOut.addActionListener(this::btnLogOutActionPerformed);

        // ── Layout
        javax.swing.GroupLayout layout =
            new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1,
                    javax.swing.GroupLayout.PREFERRED_SIZE, 440,
                    javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCheckLowStock)
                        .addPreferredGap(
                            javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRestock))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAddProduct)
                        .addGap(18, 18, 18)
                        .addComponent(btnReprice)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnViewRevenue,
                                javax.swing.GroupLayout.PREFERRED_SIZE, 140,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(36, 36, 36)
                            .addComponent(btnLogOut))
                        .addComponent(btnCollectRevenue,
                            javax.swing.GroupLayout.PREFERRED_SIZE, 140,
                            javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                            layout.createSequentialGroup()
                                .addComponent(jScrollPane2,
                                    javax.swing.GroupLayout.PREFERRED_SIZE,
                                    javax.swing.GroupLayout.DEFAULT_SIZE,
                                    javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(
                                    javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                        layout.createSequentialGroup()
                            .addComponent(btnChangePassword)
                            .addPreferredGap(
                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(btnViewRevenue,
                                            javax.swing.GroupLayout.PREFERRED_SIZE, 70,
                                            javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btnLogOut))
                                .addPreferredGap(
                                    javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCollectRevenue,
                                    javax.swing.GroupLayout.PREFERRED_SIZE, 43,
                                    javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane4,
                                    javax.swing.GroupLayout.PREFERRED_SIZE,
                                    javax.swing.GroupLayout.DEFAULT_SIZE,
                                    javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnCheckLowStock)
                                    .addComponent(btnRestock)))
                            .addComponent(jScrollPane2,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(btnChangePassword))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnAddProduct)
                                    .addComponent(btnReprice)))))
                    .addComponent(jScrollPane1,
                        javax.swing.GroupLayout.PREFERRED_SIZE, 333,
                        javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // ── Olay işleyicileri ────────────────────────────────────

    private void btnCollectRevenueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCollectRevenueActionPerformed
        LogicAdmin adminLogic = new LogicAdmin();
        double collected = adminLogic.collectRevenue();
        txtAdminScreen.append(String.format(
            "Kasa toplandı: $%.2f  —  Kasa sıfırlandı.%n", collected));
    }//GEN-LAST:event_btnCollectRevenueActionPerformed

    private void btnViewRevenueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewRevenueActionPerformed
        LogicAdmin adminLogic = new LogicAdmin();
        double total = adminLogic.getTotalRevenue();
        txtAdminScreen.append(String.format("Mevcut Gelir: $%.2f%n", total));
    }//GEN-LAST:event_btnViewRevenueActionPerformed

    private void btnCheckLowStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckLowStockActionPerformed
        VendingMachine machine = VendingMachine.getInstance();
        List<AbstractProduct> lowStock = machine.getLowStockProducts();

        if (lowStock.isEmpty()) {
            txtAdminScreen.append("Tüm ürünler yeterli stokta.\n");
        } else {
            txtAdminScreen.append("⚠ DÜŞÜK STOK UYARISI:\n");
            for (AbstractProduct p : lowStock) {
                txtAdminScreen.append(String.format(
                    "  Slot %-3s | %-16s | Kalan: %d adet%n",
                    p.getSlotId(), p.getName(), p.getStockQuantity()));
            }
        }
    }//GEN-LAST:event_btnCheckLowStockActionPerformed

    private void btnRestockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestockActionPerformed
        try {
            String slot   = txtSlot.getText().trim().toUpperCase();
            int    amount = Integer.parseInt(txtValue.getText().trim());

            new LogicAdmin().restock(slot, amount);

            txtAdminScreen.append(String.format(
                "Slot %s'a %d adet eklendi.%n", slot, amount));
            txtSlot.setText("");
            txtValue.setText("");

        } catch (NumberFormatException e) {
            txtAdminScreen.append("[X] Hata: Lütfen geçerli bir sayı girin.\n");
        } catch (ProductNotFoundException e) {
            txtAdminScreen.append("[X] Hata: " + e.getMessage() + "\n");
        }
    }//GEN-LAST:event_btnRestockActionPerformed

    private void btnRepriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRepriceActionPerformed
        try {
            String slot     = txtSlot.getText().trim().toUpperCase();
            double newPrice = Double.parseDouble(txtValue.getText().trim());

            new LogicAdmin().reprice(slot, newPrice);

            txtAdminScreen.append(String.format(
                "Slot %s yeni fiyatı: $%.2f%n", slot, newPrice));
            txtSlot.setText("");
            txtValue.setText("");

        } catch (NumberFormatException e) {
            txtAdminScreen.append("[X] Hata: Fiyat için ondalıklı sayı girin (örn. 2.50).\n");
        } catch (ProductNotFoundException e) {
            txtAdminScreen.append("[X] Hata: " + e.getMessage() + "\n");
        }
    }//GEN-LAST:event_btnRepriceActionPerformed

    private void btnChangePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangePasswordActionPerformed
        String newPassword = txtChangePassword.getText().trim();

        if (newPassword.isEmpty()) {
            txtAdminScreen.append("[X] Hata: Şifre boş olamaz.\n");
            return;
        }

        try {
            new LogicAdmin().changePassword(newPassword);
            txtAdminScreen.append("Şifre başarıyla güncellendi. Unutmayın!\n");
            txtChangePassword.setText("");
        } catch (IllegalArgumentException e) {
            txtAdminScreen.append("[X] Hata: " + e.getMessage() + "\n");
        }
    }//GEN-LAST:event_btnChangePasswordActionPerformed

    private void btnAddProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddProductActionPerformed
        try {
            String slot  = txtSlot.getText().trim().toUpperCase();
            double price = Double.parseDouble(txtValue.getText().trim());
            int    stock = Integer.parseInt(txtChangePassword.getText().trim());

            String name = javax.swing.JOptionPane.showInputDialog(
                this, "Yeni ürünün adını girin:");

            if (name == null || name.trim().isEmpty()) {
                txtAdminScreen.append("[X] İptal: Ürün adı boş olamaz.\n");
                return;
            }

            new LogicAdmin().addNewProduct(slot, name.trim(), price, stock);

            txtAdminScreen.append(String.format(
                "Eklendi: %dx '%s' → Slot %s  ($%.2f)%n",
                stock, name.trim(), slot, price));

            txtSlot.setText("");
            txtValue.setText("");
            txtChangePassword.setText("");

        } catch (NumberFormatException e) {
            txtAdminScreen.append(
                "[X] Hata: Fiyat ondalıklı (örn. 2.50), Stok tam sayı olmalıdır.\n");
        } catch (Exception e) {
            txtAdminScreen.append("[X] Beklenmeyen hata: " + e.getMessage() + "\n");
        }
    }//GEN-LAST:event_btnAddProductActionPerformed

    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutActionPerformed
        TestGUI mainWindow = new TestGUI();
        mainWindow.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnLogOutActionPerformed

    // ── main ─────────────────────────────────────────────────
    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info :
                    javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> new AdminGUI().setVisible(true));
    }

    // ── Değişken bildirimleri ─────────────────────────────────
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddProduct;
    private javax.swing.JButton btnChangePassword;
    private javax.swing.JButton btnCheckLowStock;
    private javax.swing.JButton btnCollectRevenue;
    private javax.swing.JButton btnLogOut;
    private javax.swing.JButton btnReprice;
    private javax.swing.JButton btnRestock;
    private javax.swing.JButton btnViewRevenue;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea txtAdminScreen;
    private javax.swing.JTextArea txtChangePassword;
    private javax.swing.JTextArea txtSlot;
    private javax.swing.JTextArea txtValue;
    // End of variables declaration//GEN-END:variables
}
