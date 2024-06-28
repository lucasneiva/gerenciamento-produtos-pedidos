/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.poo.view;

/**
 *
 * @author 0030482221012
 */
public class GuiMenu extends javax.swing.JFrame {

    /**
     * Creates new form GuiMenu
     */
    public GuiMenu() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        menuCadastros = new javax.swing.JMenu();
        menuItemVendedor = new javax.swing.JMenuItem();
        menuItemCliente = new javax.swing.JMenuItem();
        menuItemPedido = new javax.swing.JMenuItem();
        menuItemSair = new javax.swing.JMenuItem();
        menuItemProduto = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        menuCadastros.setText("Cadastros");

        menuItemVendedor.setText("Vendedor");
        menuItemVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemVendedorActionPerformed(evt);
            }
        });
        menuCadastros.add(menuItemVendedor);

        menuItemCliente.setText("Cliente");
        menuItemCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemClienteActionPerformed(evt);
            }
        });
        menuCadastros.add(menuItemCliente);

        menuItemPedido.setText("Pedido");
        menuItemPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemPedidoActionPerformed(evt);
            }
        });
        menuCadastros.add(menuItemPedido);

        menuItemSair.setText("Sair");
        menuItemSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemSairActionPerformed(evt);
            }
        });
        menuCadastros.add(menuItemSair);

        menuItemProduto.setText("Produto");
        menuItemProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemProdutoActionPerformed(evt);
            }
        });
        menuCadastros.add(menuItemProduto);

        jMenuBar1.add(menuCadastros);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 269, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuItemVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemVendedorActionPerformed
        new GuiVendedor().setVisible(true);
    }//GEN-LAST:event_menuItemVendedorActionPerformed

    private void menuItemSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemSairActionPerformed
        dispose();
    }//GEN-LAST:event_menuItemSairActionPerformed

    private void menuItemClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemClienteActionPerformed
        new GuiCliente().setVisible(true);
    }//GEN-LAST:event_menuItemClienteActionPerformed

    private void menuItemPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemPedidoActionPerformed
        new GuiPedido().setVisible(true);
    }//GEN-LAST:event_menuItemPedidoActionPerformed

    private void menuItemProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemProdutoActionPerformed
        // TODO add your handling code here:
        new GuiProduto().setVisible(true);
    }//GEN-LAST:event_menuItemProdutoActionPerformed

/**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GuiMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GuiMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GuiMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GuiMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GuiMenu().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu menuCadastros;
    private javax.swing.JMenuItem menuItemCliente;
    private javax.swing.JMenuItem menuItemPedido;
    private javax.swing.JMenuItem menuItemProduto;
    private javax.swing.JMenuItem menuItemSair;
    private javax.swing.JMenuItem menuItemVendedor;
    // End of variables declaration//GEN-END:variables
}
