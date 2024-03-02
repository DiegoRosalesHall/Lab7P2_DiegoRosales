
package lab7p2_diegorosales;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;


public class Main extends javax.swing.JFrame {
    
    
    AdmProducto adm = new AdmProducto();
    public void clearcmd(){
        tf_command.setText("");
    }
    public void clear(){
        DefaultTableModel model = (DefaultTableModel) jtb_productos.getModel();
               
             
               model.setNumRows(0);
               model.setNumRows(1);
               
               
               jtb_productos.setModel(model);
               JOptionPane.showMessageDialog(this, "La tabla se ha vaciado!");
               tf_command.setText("");
    }
    public void verificarCMD() throws DiegoException, IOException{
        ArrayList<String> comandosvalidos = new ArrayList<>();
        comandosvalidos.add("./load");
        comandosvalidos.add("./create");
        comandosvalidos.add("./clear");
        comandosvalidos.add("./refresh");
        int ind;
        String [] comando = tf_command.getText().split(" ");
        boolean valid = false;
        for (int i = 0; i < comandosvalidos.size(); i++) {
            if(comandosvalidos.get(i).equals(comando[0])){
            valid=true;
            ind=i;
            }
            else{
                
            }
        }
        if (valid==false){
            JOptionPane.showMessageDialog(this, "Error, comando invalido");
            
        }
        else{
           if(comando[0].equals(comandosvalidos.get(0))){
               JOptionPane.showMessageDialog(this, comando[1]);
               File archivo = new File("./CSV/"+comando[1]);
               if(!archivo.exists()){
                   JOptionPane.showMessageDialog(this, "Error, el archivo no existe");
               }
               else{
                   adm = new AdmProducto("./CSV/"+comando[1]);
                   adm.cargarArchivo();
                   DefaultTableModel model = (DefaultTableModel) jtb_productos.getModel();
                   for (Producto p : adm.getProductos()) {
                       Object [] r = { p.getId(), p.getName(),p.getCategory(),p.getPrice(),p.getAisle(),p.getBin()};
                       model.addRow(r);
                   }
                    jtb_productos.setModel(model);
                    
                    DefaultTreeModel treemodel = (DefaultTreeModel) jt_csv.getModel();
                    DefaultMutableTreeNode raiz = (DefaultMutableTreeNode) treemodel.getRoot();
                    
                   
                    raiz.add(new DefaultMutableTreeNode(archivo));
                    treemodel.reload();
                 
                    
                    jt_csv.setModel(treemodel);
                    tf_command.setText("");
               }
               
           } // ./ LOAD
           
           else if(comando[0].equals(comandosvalidos.get(1))){
               if(!comando[2].equals("-single") || !comando[1].contains(".txt")){
                   JOptionPane.showMessageDialog(this, "Error sintactico");
               }
               else
               {
                   int rows = jtb_productos.getRowCount();
                   Producto p = new Producto();
                   FileWriter fw = null;
                   BufferedWriter bw =null;
                   
                   File arch = new File("./CSV/"+comando[1]);
                   boolean flag=false;
                   int cont=0;
                   for (int i = 0; i < jtb_productos.getRowCount(); i++) {
                       for (int j = 0; j < jtb_productos.getColumnCount(); j++) {
                           if(jtb_productos.getValueAt(i, j)==null){
                               cont++;
                           flag=true;
                           }
                           if(cont==6){
                               flag=false;
                               cont=0;
                           }
                           
                       }
                       cont=5;
                   }
                   if(flag==true){
                       JOptionPane.showMessageDialog(this, "no puede crearse porque hay un parametro vacio");
                   }
                   else{
                   try{
                       fw = new FileWriter(arch, true);
                            bw = new BufferedWriter(fw);
                            int connt=0;
                        for (int i = 0; i < rows; i++) {
                            
                            for (int j = 0; j < jtb_productos.getColumnCount(); j++) {
                                if(jtb_productos.getValueAt(i, j)==null){
                                    connt++;
                                }
                                if(j==5 && connt==6){
                                  continue;  
                                }
                                else if(j==5 && connt <6){
                                     bw.write( jtb_productos.getValueAt(i, 0)+",");
                           bw.write(jtb_productos.getValueAt(i, 1)+",");
                           bw.write( jtb_productos.getValueAt(i, 2)+",");
                           bw.write(jtb_productos.getValueAt(i, 3)+",");
                           bw.write( jtb_productos.getValueAt(i, 4)+",");
                           bw.write( jtb_productos.getValueAt(i, 5)+","); 
                                }
                            }
                         
                       
                   }
                        
                   
                   }
                   
                   
                   catch(Exception e){
                       
                   }
                   bw.close();
        fw.close();
                    DefaultTreeModel treemodel = (DefaultTreeModel) jt_csv.getModel();
                    DefaultMutableTreeNode raiz = (DefaultMutableTreeNode) treemodel.getRoot();
                    raiz.add(new DefaultMutableTreeNode(arch));
                    treemodel.reload();
                    jt_csv.setModel(treemodel);
                  
                  JOptionPane.showMessageDialog(this, "Has creado con exito!");
                   
               tf_command.setText("");
               }
               }   
           } // ./ CREATE
           
           else if(comando[0].equals(comandosvalidos.get(2))){
               clear();
           } // ./ CLEAR
            
            else if(comando[0].equals(comandosvalidos.get(3))){
              JOptionPane.showMessageDialog(this, "El arbol se ha actualizado!");
               tf_command.setText("");
               
           } // ./ REFRESH
        }
          
    }
   
    public Main() {
        
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

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenu8 = new javax.swing.JMenu();
        jMenu9 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        tf_command = new javax.swing.JTextField();
        bt_enter = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jt_csv = new javax.swing.JTree();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtb_productos = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        menu_clearcmd = new javax.swing.JMenu();
        menu_clear = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();

        jMenu8.setText("Load");
        jPopupMenu1.add(jMenu8);

        jMenu9.setText("Refresh Trees");
        jPopupMenu1.add(jMenu9);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        tf_command.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_commandActionPerformed(evt);
            }
        });

        bt_enter.setText("Enter");
        bt_enter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_enterMouseClicked(evt);
            }
        });

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Archivos CSV");
        jt_csv.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jt_csv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jt_csvMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jt_csv);

        jtb_productos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Category", "Price", "Aisle", "Bin"
            }
        ));
        jScrollPane2.setViewportView(jtb_productos);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(tf_command, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_enter)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_command, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_enter))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Windows");

        jMenu4.setText("Clear");

        menu_clearcmd.setText("Clear Command Line");
        menu_clearcmd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_clearcmdActionPerformed(evt);
            }
        });
        jMenu4.add(menu_clearcmd);

        menu_clear.setText("Clear Table");
        menu_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_clearActionPerformed(evt);
            }
        });
        jMenu4.add(menu_clear);

        jMenu2.add(jMenu4);

        jMenu7.setText("Refresh Tree");
        jMenu2.add(jMenu7);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Help");
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf_commandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_commandActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_commandActionPerformed

    private void bt_enterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_enterMouseClicked
        try {
            verificarCMD();
        } catch (DiegoException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bt_enterMouseClicked

    private void jt_csvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jt_csvMouseClicked
       
         /* if(evt.getButton()==3){
        if(jt_csv.getSelectionPath().getLastPathComponent() instanceof Producto){
        
            jPopupMenu1.show(this, evt.getX(), evt.getY());
        }
        else{
            
        }
        } */
    }//GEN-LAST:event_jt_csvMouseClicked

    private void menu_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_clearActionPerformed
        clear();
    }//GEN-LAST:event_menu_clearActionPerformed

    private void menu_clearcmdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_clearcmdActionPerformed
        clearcmd();
    }//GEN-LAST:event_menu_clearcmdActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_enter;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTree jt_csv;
    private javax.swing.JTable jtb_productos;
    private javax.swing.JMenu menu_clear;
    private javax.swing.JMenu menu_clearcmd;
    private javax.swing.JTextField tf_command;
    // End of variables declaration//GEN-END:variables
}
