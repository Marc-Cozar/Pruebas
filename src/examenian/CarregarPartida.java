/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenian;

import entity.Movimiento;
import entity.Partida;
import static examenian.UnoVsUno.movimiento;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Query;
import org.hibernate.Session;
import java.util.List;

/**
 *
 * @author Marc
 */
public class CarregarPartida extends javax.swing.JFrame {

    Session session;
    List list;
    List list2;
    Movimiento movimiento;
    int movimientoC = 0;
    boolean checker=true;
    
    
    /**
     * Creates new form carregarPartida
     */
    public CarregarPartida() {
        initComponents();
        session = NewHibernateUtil.getSessionFactory().openSession();
        carregarPartides();
    }
    
    public void carregarPartides(){
        
        //accede al archivo partida.java
        Partida partida;
        //creo una string de datos 
        String[] datos = new String[2];
        
        //abro una sesion para hacer consultas
        session.beginTransaction();
        //creo una String y le paso la consulta
        String SQL_QUERY;
        SQL_QUERY = "FROM Partida";
        //creo un query y le envio la consulta a la base de datos. Temporalmente
        //se guardan los datos en query
        Query query = session.createQuery(SQL_QUERY);
        //hago una lista y le meto los datos del query
        list = query.list();
        //cierro la consulta
        session.getTransaction().commit();
        
        //defino la tabla
        DefaultTableModel model = new DefaultTableModel();
        //añado columnas
        model.addColumn("ID PARTIDA");
        model.addColumn("GANADOR");
        tablePartidas.setModel(model);
        
         for (int i = 0; i < list.size(); i++) {
             //(partida) sirve para referirse a que es un objeto de partida y
             //le pasamos la lista de list
             partida = (Partida) list.get(i);
             //imprime en la consola, solo visual para nosotros
             System.out.println(partida.getGanador());
             //le metemos los datos a las columnas
             datos[1] = partida.getGanador();
             datos[0] = partida.getIdPartida().toString();
             //metemos las filas con los datos
             model.addRow(datos);
         }
         tablePartidas.setModel(model);
    }
    
        public void generarLista(int id){
            
        tablePartida.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "", "", ""
            }
        ));    
        //resetear movimientos
        movimientoC=0;
        //resetear checker
        boolean checker=true;
        
        session.beginTransaction();
        
        String SQL_QUERY;
        SQL_QUERY = "FROM Movimiento m where m.partida.idPartida = " + id ;
        
        Query query = session.createQuery(SQL_QUERY);
        list2 = query.list();
        session.getTransaction().commit();
    }
    
    public void movimientoCount(int i){
    
        
        System.out.println("HOLA ENTRA1");
        
        if (i < list2.size()) {
            movimiento = (Movimiento) list2.get(i);

            if(checker){
                tablePartida.setValueAt("X", movimiento.getFila(), movimiento.getColumna());
                checker=false;
                System.out.println("HOLA ENTRA");
            } else if (!checker){
                tablePartida.setValueAt("O", movimiento.getFila(), movimiento.getColumna());
                System.out.println("HOLA ENTRA3");
                checker=true;
            }
                movimientoC++;
        }
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
        tablePartida = new javax.swing.JTable();
        butTornar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablePartidas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtPartida = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tablePartida.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "", "", ""
            }
        ));
        tablePartida.setGridColor(new java.awt.Color(0, 0, 0));
        tablePartida.setRowHeight(100);
        jScrollPane1.setViewportView(tablePartida);

        butTornar.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        butTornar.setText("TORNAR");
        butTornar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butTornarActionPerformed(evt);
            }
        });

        tablePartidas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tablePartidas);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel1.setText("PARTIDA :");

        txtPartida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPartidaActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("CARREGAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jButton2.setText("SEGÜENT MOVIMENT");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                        .addGap(116, 116, 116))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(butTornar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtPartida, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtPartida, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(butTornar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void butTornarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butTornarActionPerformed
        // TODO add your handling code here:
        Home fra = new Home();
        fra.setVisible(true);
        dispose();
    }//GEN-LAST:event_butTornarActionPerformed

    private void txtPartidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPartidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPartidaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int id = Integer.parseInt(txtPartida.getText());
        generarLista(id);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        movimientoCount(movimientoC);
        System.out.println("HOLA");
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(CarregarPartida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CarregarPartida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CarregarPartida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CarregarPartida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CarregarPartida().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butTornar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablePartida;
    private javax.swing.JTable tablePartidas;
    private javax.swing.JTextField txtPartida;
    // End of variables declaration//GEN-END:variables
}
