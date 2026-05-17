package vendingmachine.gui;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import vendingmachine.ProductNotFoundException;
import vendingmachine.logic.ChangeCalculator;
import vendingmachine.VendingMachine;
import vendingmachine.VendingMachine;
import vendingmachine.data.FileManager;
import vendingmachine.logic.ChangeCalculator.PaymentMethod;
import vendingmachine.logic.ChangeCalculator.PaymentResult;
import vendingmachine.logic.LogicUser;
import vendingmachine.products.AbstractProduct;

/**
 * Müşteri ana ekranı.
 *
 * <p>Ekranda iki bölüm bulunur:
 * <ul>
 *   <li><b>Sol:</b> Büyük metin ekranı (txtScreen) – envanter ve işlem bilgileri</li>
 *   <li><b>Sağ:</b> Tuş takımı (A–D / 0–9 / * / #) + Slot giriş kutusu (txtInput)
 *       + Enter ve Clear düğmeleri</li>
 * </ul>
 *
 * <p><b>Özel komut:</b> Tuş takımından {@code *#AB1C3} yazılıp Enter'a basılırsa
 * admin giriş ekranı açılır.
 */
public class TestGUI extends javax.swing.JFrame {

    private static final Logger logger = Logger.getLogger(TestGUI.class.getName());

    // ── Constructor ───────────────────────────────────────────
    public TestGUI() {
        initComponents();
        bootDisplay();
    }

    /** Açılışta envanter bilgilerini txtScreen'e yazar. */
    private void bootDisplay() {
        txtScreen.setText("=== MULTI-PURPOSE VENDING MACHINE ===\n");
        txtScreen.append("Envanter yükleniyor...\n\n");

        Map<String, AbstractProduct> inventory =
            VendingMachine.getInstance().getInventory();

        for (Map.Entry<String, AbstractProduct> entry : inventory.entrySet()) {
            AbstractProduct p = entry.getValue();
            String status = p.isAvailable()
                ? "[$" + String.format("%.2f", p.getPrice()) + "] - Adet: " + p.getStockQuantity()
                : "[TÜKENDİ]";
            txtScreen.append("Slot " + entry.getKey() + " : " + p.getName() + "  " + status + "\n");
        }

        txtScreen.append("-------------------------------------\n");
        txtScreen.append("Hazır! Slot seçmek için tuş takımını kullanın.\n");
        txtScreen.append("(Admin girişi için: *#AB1C3)\n");
    }

    /** Resmi otomatik boyutlandırmak için yardımcı metot. */
    public void setScaledImage(javax.swing.JLabel label, String imagePath) {
        try {
            javax.swing.ImageIcon icon =
                new javax.swing.ImageIcon(getClass().getResource(imagePath));
            java.awt.Image img = icon.getImage();
            java.awt.Image scaled = img.getScaledInstance(
                label.getWidth(), label.getHeight(), java.awt.Image.SCALE_REPLICATE);
            label.setIcon(new javax.swing.ImageIcon(scaled));
        } catch (Exception e) {
            System.out.println("Resim bulunamadı: " + imagePath);
        }
    }

    // ── initComponents ────────────────────────────────────────
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtScreen    = new javax.swing.JTextArea();
        jPanel2      = new javax.swing.JPanel();
        jButton5     = new javax.swing.JButton();
        jButton6     = new javax.swing.JButton();
        jButton7     = new javax.swing.JButton();
        jButton13    = new javax.swing.JButton();
        jButton14    = new javax.swing.JButton();
        jButton16    = new javax.swing.JButton();
        jButton15    = new javax.swing.JButton();
        jButton12    = new javax.swing.JButton();
        jButton9     = new javax.swing.JButton();
        jButton8     = new javax.swing.JButton();
        jButton11    = new javax.swing.JButton();
        jButton10    = new javax.swing.JButton();
        jButton3     = new javax.swing.JButton();
        jButton4     = new javax.swing.JButton();
        jButton18    = new javax.swing.JButton();
        jButton17    = new javax.swing.JButton();
        btnEnter     = new javax.swing.JButton();
        jButton19    = new javax.swing.JButton();
        txtInput     = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Vending Machine");

        txtScreen.setColumns(20);
        txtScreen.setRows(5);
        txtScreen.setEditable(false);
        jScrollPane1.setViewportView(txtScreen);

        // 4×4 tuş takımı: A 1 2 3 / B 4 5 6 / C 7 8 9 / D * 0 #
        jPanel2.setLayout(new java.awt.GridLayout(4, 4));

        jButton5.setText("A");  jButton5.addActionListener(this::jButton5ActionPerformed);
        jPanel2.add(jButton5);
        jButton6.setText("1");  jButton6.addActionListener(this::jButton6ActionPerformed);
        jPanel2.add(jButton6);
        jButton7.setText("2");  jButton7.addActionListener(this::jButton7ActionPerformed);
        jPanel2.add(jButton7);
        jButton13.setText("3"); jButton13.addActionListener(this::jButton13ActionPerformed);
        jPanel2.add(jButton13);

        jButton14.setText("B"); jButton14.addActionListener(this::jButton14ActionPerformed);
        jPanel2.add(jButton14);
        jButton16.setText("4"); jButton16.addActionListener(this::jButton16ActionPerformed);
        jPanel2.add(jButton16);
        jButton15.setText("5"); jButton15.addActionListener(this::jButton15ActionPerformed);
        jPanel2.add(jButton15);
        jButton12.setText("6"); jButton12.addActionListener(this::jButton12ActionPerformed);
        jPanel2.add(jButton12);

        jButton9.setText("C");  jButton9.addActionListener(this::jButton9ActionPerformed);
        jPanel2.add(jButton9);
        jButton8.setText("7");  jButton8.addActionListener(this::jButton8ActionPerformed);
        jPanel2.add(jButton8);
        jButton11.setText("8"); jButton11.addActionListener(this::jButton11ActionPerformed);
        jPanel2.add(jButton11);
        jButton10.setText("9"); jButton10.addActionListener(this::jButton10ActionPerformed);
        jPanel2.add(jButton10);

        jButton3.setText("D");  jButton3.addActionListener(this::jButton3ActionPerformed);
        jPanel2.add(jButton3);
        jButton4.setText("*");  jButton4.addActionListener(this::jButton4ActionPerformed);
        jPanel2.add(jButton4);
        jButton18.setText("0"); jButton18.addActionListener(this::jButton18ActionPerformed);
        jPanel2.add(jButton18);
        jButton17.setText("#"); jButton17.addActionListener(this::jButton17ActionPerformed);
        jPanel2.add(jButton17);

        btnEnter.setText("Enter");
        btnEnter.addActionListener(this::btnEnterActionPerformed);

        jButton19.setText("Clear");
        jButton19.addActionListener(this::jButton19ActionPerformed);

        txtInput.setEditable(false);
        txtInput.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtInput.setBorder(javax.swing.BorderFactory.createTitledBorder("Slot ID"));
        txtInput.addActionListener(this::txtInputActionPerformed);

        // ── Layout ────────────────────────────────────────────
        javax.swing.GroupLayout layout =
            new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1,
                    javax.swing.GroupLayout.PREFERRED_SIZE, 340,
                    javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtInput,
                            javax.swing.GroupLayout.PREFERRED_SIZE, 194,
                            javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2,
                            javax.swing.GroupLayout.DEFAULT_SIZE, 222,
                            Short.MAX_VALUE)
                        .addPreferredGap(
                            javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                        layout.createSequentialGroup()
                            .addGap(0, 6, Short.MAX_VALUE)
                            .addComponent(btnEnter,
                                javax.swing.GroupLayout.PREFERRED_SIZE, 98,
                                javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                        layout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(jButton19,
                                javax.swing.GroupLayout.PREFERRED_SIZE, 98,
                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1,
                            javax.swing.GroupLayout.PREFERRED_SIZE, 389,
                            javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtInput)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2,
                                javax.swing.GroupLayout.Alignment.TRAILING,
                                javax.swing.GroupLayout.PREFERRED_SIZE, 256,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                layout.createSequentialGroup()
                                    .addComponent(btnEnter,
                                        javax.swing.GroupLayout.PREFERRED_SIZE, 56,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton19,
                                        javax.swing.GroupLayout.PREFERRED_SIZE, 56,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(0, 20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // ── Tuş olayları ──────────────────────────────────────────
    private void txtInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtInputActionPerformed
        // Yok — Enter butonu kullanılır
    }//GEN-LAST:event_txtInputActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        txtInput.setText(txtInput.getText() + "A");
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        txtInput.setText(txtInput.getText() + "B");
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        txtInput.setText(txtInput.getText() + "C");
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        txtInput.setText(txtInput.getText() + "D");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        txtInput.setText(txtInput.getText() + "1");
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        txtInput.setText(txtInput.getText() + "2");
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        txtInput.setText(txtInput.getText() + "3");
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        txtInput.setText(txtInput.getText() + "4");
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        txtInput.setText(txtInput.getText() + "5");
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        txtInput.setText(txtInput.getText() + "6");
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        txtInput.setText(txtInput.getText() + "7");
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        txtInput.setText(txtInput.getText() + "8");
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        txtInput.setText(txtInput.getText() + "9");
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        txtInput.setText(txtInput.getText() + "0");
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        txtInput.setText(txtInput.getText() + "*");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        txtInput.setText(txtInput.getText() + "#");
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        txtInput.setText("");
    }//GEN-LAST:event_jButton19ActionPerformed

    // ── Enter — satın alma veya admin girişi ─────────────────
    private void btnEnterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnterActionPerformed
        String input = txtInput.getText().trim();

        if (input.length() == 2) {
            // Normal slot seçimi (örn. "A1")
            handlePurchase(input.toUpperCase());

        } else if (input.equals("*#AB1C3")) {
            // Gizli admin kodu
            handleAdminLogin();

        } else {
            txtScreen.append("[X] Geçersiz giriş! Lütfen geçerli bir slot girin (örn. A1).\n");
        }

        txtInput.setText("");
    }//GEN-LAST:event_btnEnterActionPerformed

    // ── Satın alma akışı ──────────────────────────────────────

    private void handlePurchase(String slot) {
        LogicUser logic = new LogicUser();

        if (!logic.checkAvailability(slot)) {
            txtScreen.append("[X] Slot " + slot + " boş veya tükenmiş!\n");
            return;
        }

        double price = logic.getItemPrice(slot);

        // Ödeme miktarı ilet
        String moneyInput = javax.swing.JOptionPane.showInputDialog(
            this,
            String.format("Ürün fiyatı: $%.2f%nNakit miktarınızı girin:", price)
        );

        if (moneyInput == null || moneyInput.trim().isEmpty()) {
            txtScreen.append("Satın alma iptal edildi.\n");
            return;
        }

        try {
            double moneyInserted = Double.parseDouble(moneyInput.trim());

            PaymentResult payment = ChangeCalculator.processPayment(
                price, moneyInserted, PaymentMethod.CASH);

            if (payment.isSuccess()) {
                boolean ok = logic.processSale(slot, payment.getAmountPaid());
                if (ok) {
                    txtScreen.append("✓ Satış tamamlandı! " + payment.getMessage() + "\n");
                    if (payment.getChangeAmount() > 0) {
                        txtScreen.append("  Para üstü dağılımı:\n");
                        for (Map.Entry<String, Integer> e : payment.getChangeBreakdown().entrySet()) {
                            txtScreen.append("    " + e.getValue() + "x " + e.getKey() + "\n");
                        }
                    }
                } else {
                    txtScreen.append("[X] Hata: Ürün çıkarılamadı.\n");
                }
            } else {
                txtScreen.append("[X] Ödeme Hatası: " + payment.getMessage() + "\n");
            }
        } catch (NumberFormatException ex) {
            txtScreen.append("[X] Geçersiz tutar. Lütfen sayı girin (örn. 2.00).\n");
        } catch (ProductNotFoundException ex) {
            System.getLogger(TestGUI.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }

        txtScreen.append("----------------------------\n");
    }

    // ── Admin giriş akışı ────────────────────────────────────

    private void handleAdminLogin() {
        String password = javax.swing.JOptionPane.showInputDialog(
            this, "Admin Şifresi:");

        if (password == null) return;  // iptal

        FileManager fm = new FileManager();
        if (fm.checkAdminPassword(password)) {
            txtScreen.append("[✓] Admin girişi başarılı! Panel açılıyor...\n");
            AdminGUI adminWindow = new AdminGUI();
            adminWindow.setVisible(true);
            this.dispose();
        } else {
            txtScreen.append("[X] Hatalı şifre. Erişim reddedildi.\n");
        }
    }

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
        java.awt.EventQueue.invokeLater(() -> new TestGUI().setVisible(true));
    }

    // ── Değişken bildirimleri ─────────────────────────────────
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnter;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtInput;
    private javax.swing.JTextArea txtScreen;
    // End of variables declaration//GEN-END:variables
}
