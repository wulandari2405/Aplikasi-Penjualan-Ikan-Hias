/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AplikasiPenjualan;

import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Asus
 */
public class DataForm extends javax.swing.JInternalFrame {

    /**
     * Creates new form DataForm
     */
    public DataForm() throws ClassNotFoundException, SQLException {
        initComponents();
        showTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableData = new javax.swing.JTable();
        toMenuButton = new javax.swing.JButton();
        totalIkanTxt = new javax.swing.JTextField();
        totalPenjualanTxt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        tableData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nomor Pemesan", "Nama Pemesan", "Jenis Ikan", "Harga Ikan", "Tipe Ikan"
            }
        ));
        jScrollPane1.setViewportView(tableData);

        toMenuButton.setText("Ke Menu Utama");
        toMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toMenuButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Jumlah Ikan Hias Terjual");

        jLabel2.setText("Total Penjualan");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1005, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(toMenuButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(totalPenjualanTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                    .addComponent(totalIkanTxt))
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(toMenuButton)
                    .addComponent(totalIkanTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalPenjualanTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(0, 20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void toMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toMenuButtonActionPerformed
       OptionMenu optionMenu = new OptionMenu();
       optionMenu.setVisible(true);
       this.getDesktopPane().add(optionMenu);
       this.dispose();
    }//GEN-LAST:event_toMenuButtonActionPerformed

    public void showTable() throws ClassNotFoundException, SQLException{
        try{
        Statement stat = (Statement) ConnectionDb.connectDatabase().createStatement();
        String sql = "select * form ikan";  
        ResultSet rs = stat.executeQuery(sql);
        DefaultTableModel tableModel;
        tableModel = (DefaultTableModel) tableData.getModel();
        while(rs.next()){ 
            tableModel.addRow(new Object[] {
                rs.getString(1),rs.getString(2),rs.getString(3),
                rs.getString(4),rs.getString(5)
            });
        }
         } catch (SQLException ex){
             Logger.getLogger(DataForm.class.getName()).log(Level.SEVERE, null, ex);
             
         }
    }
            
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableData;
    private javax.swing.JButton toMenuButton;
    private javax.swing.JTextField totalIkanTxt;
    private javax.swing.JTextField totalPenjualanTxt;
    // End of variables declaration//GEN-END:variables
}
