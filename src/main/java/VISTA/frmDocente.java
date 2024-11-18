/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VISTA;

import javax.swing.JTable;
import CONTROLADOR.Docente;
import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.UIManager;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;
/**
 *
 * @author Abraham
 */
public class frmDocente extends javax.swing.JFrame {

    Docente doc=new Docente(this);
  
    public frmDocente() {
            
        initComponents();
          frmprueba fp=new frmprueba();
          contenedor.setLayout(new BorderLayout()); // Establecer diseño
       doc.cargarDocentesEnVista();
        InitContent(fp);
    setBackground(new Color(0, 0, 0, 0));
  
    }
public void InitContent(JPanel panel) {
        // Asegurarse de que el panel sea visible
        panel.setVisible(true);

        // Ajustar el tamaño del panel al tamaño del contenedor
        panel.setSize(contenedor.getSize());
        panel.setLocation(0, 0);

        // Eliminar todos los componentes previos del contenedor
        contenedor.removeAll();

        // Agregar el nuevo panel al contenedor
        contenedor.add(panel, BorderLayout.CENTER);

        // Actualizar la jerarquía de componentes y repintar
        contenedor.revalidate();
        contenedor.repaint();
    }
//   public void Ventana_Principal() {
//        jPanel1.removeAll();
//        frmprueba ve = new frmprueba();
//        ve.show();
//        ve.setSize(contenedor.getSize());
//        ve.setLocation(0, 0);
//        contenedor.add(ve, BorderLayout.CENTER);
//        contenedor.revalidate();
//        contenedor.repaint();
//        glo = ve;
//        
//    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tddocentes = new javax.swing.JTable();
        contenedor = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tddocentes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tddocentes);

        javax.swing.GroupLayout contenedorLayout = new javax.swing.GroupLayout(contenedor);
        contenedor.setLayout(contenedorLayout);
        contenedorLayout.setHorizontalGroup(
            contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        contenedorLayout.setVerticalGroup(
            contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 332, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(130, 130, 130)
                .addComponent(contenedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(121, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(contenedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(156, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 public JTable getTblDocentes() {
        return tddocentes;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       try {
    UIManager.setLookAndFeel(new FlatLightLaf());
} catch (Exception e) {
    e.printStackTrace();
}
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmDocente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel contenedor;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tddocentes;
    // End of variables declaration//GEN-END:variables
}
