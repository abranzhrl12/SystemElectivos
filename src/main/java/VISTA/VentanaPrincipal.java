/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VISTA;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;
import MODELO.Roles.SesionUsuario;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.formdev.flatlaf.extras.components.FlatButton;
import com.formdev.flatlaf.extras.components.FlatButton.ButtonType;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class VentanaPrincipal extends javax.swing.JFrame {
private LOGIN loginView; // Referencia a la ventana de login
  private static boolean isExpanded = true;
    SesionUsuario ses=new SesionUsuario();
    public VentanaPrincipal() {
        this.loginView = loginView; // Guarda la referencia a la ventana de login
        initComponents();
        
       txtrol.setText(SesionUsuario.getRoluser());
       txtnombre.setText(ses.getNombreUsuario());
       Iconbard.setIcon(new FlatSVGIcon(getClass().getResource("/Iconos/Icon.svg")));
       this.getContentPane().setBackground(Color.WHITE);
       System.setProperty("flatlaf.windowDecorationColor", "#FFFFFF"); // Color blanco para la barra de título
       jMenuBar1.setBackground(Color.WHITE);
  this.getRootPane().putClientProperty("JRootPane.titleBarBackground", Color.WHITE);
   this.getRootPane().putClientProperty("JRootPane.frameBorder", null);
   
                FlatLightLaf.setup();
   // Crear un menú estándar
          // Crear el botón personalizado
        FlatButton usersButton = new FlatButton();
        usersButton.setIcon(new FlatSVGIcon("Iconos/Icon.svg")); // Ruta al ícono SVG
        usersButton.setButtonType(ButtonType.toolBarButton);
        usersButton.setPreferredSize(new Dimension(40,90));
        usersButton.setFocusable(false);
        usersButton.setPreferredSize(new Dimension(50, 30)); // Ancho fijo, altura ajustable más tarde
usersButton.setMaximumSize(new Dimension(50, Integer.MAX_VALUE)); // Altura para ocupar todo el espacio disponible


        FlatButton usersButton2 = new FlatButton();
        usersButton2.setIcon(new FlatSVGIcon("Iconos/Icon.svg",14 ,14)); // Ruta al ícono SVG
        usersButton2.setButtonType(ButtonType.toolBarButton);
usersButton2.setPreferredSize(new Dimension(50, 30)); // Ancho fijo, altura ajustable más tarde
usersButton2.setMaximumSize(new Dimension(50, Integer.MAX_VALUE)); // Altura para ocupar todo el espacio disponible
        usersButton2.setFocusable(false);


        // Agregar el botón al extremo derecho del menú
        jMenuBar1.add(Box.createGlue());
          // Texto al centro
//              Dimension minSize = new Dimension(20, 0); // Espacio mínimo
//        Dimension prefSize = new Dimension(20, 0); // Espacio preferido
//        Dimension maxSize = new Dimension(50, 0); // Espacio máximo
//        Box.Filler customSpacer = new Box.Filler(minSize, prefSize, maxSize);
//        
        
     
        jMenuBar1.add(usersButton);
         jMenuBar1.add(Box.createHorizontalStrut(10));
         jMenuBar1.add(usersButton2);
          jMenuBar1.add(Box.createHorizontalStrut(20));
  

       

      
    }

//   public static void contraerPanel(JPanel panel) {
//        int anchoInicial = panel.getWidth();
//        int anchoFinal = 50; // Ancho final al que se contraerá
//        int paso = 10; // Cantidad de píxeles que se reducirá en cada paso
//
//        Timer timer = new Timer(10, new ActionListener() {
//            int anchoActual = anchoInicial;
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                anchoActual -= paso;
//                if (anchoActual <= anchoFinal) {
//                    anchoActual = anchoFinal;
//                    ((Timer)e.getSource()).stop(); // Detener el Timer al alcanzar el ancho final
//                }
//                panel.setBounds(panel.getX(), panel.getY(), anchoActual, panel.getHeight());
//                panel.revalidate();
//                panel.repaint();
//            }
//        });
//        timer.start();
//    }
     public static boolean isAnimating = false;
private static void contraerPanel(JPanel panel) {
  
        if (isAnimating) {
        return; // Si ya hay una animación en progreso, no hacer nada
    }

    isAnimating = true; // Marcar que la animación ha comenzado

    int anchoInicial = panel.getWidth();
    int anchoFinal = isExpanded ? 80 : 250; // Si está expandido, contraer; si está contraído, expandir
    int duration = 300; // Duración deseada en milisegundos (0.3 segundos)
    int steps = 30; // Dividir la animación en 30 pasos
    int intervalo = duration / steps; // Calcular el intervalo basado en la duración y el número de pasos
    double paso = (double)(anchoFinal - anchoInicial) / steps; // Ajuste gradual del tamaño en cada paso

    Timer timer = new Timer(intervalo, new ActionListener() {
        double anchoActual = anchoInicial;

        @Override
        public void actionPerformed(ActionEvent e) {
            anchoActual += paso;
            int anchoRedondeado = (int) Math.round(anchoActual);

            // Detener el timer si alcanzamos el tamaño final
            if ((paso > 0 && anchoRedondeado >= anchoFinal) || (paso < 0 && anchoRedondeado <= anchoFinal)) {
                anchoRedondeado = anchoFinal;
                ((Timer) e.getSource()).stop(); // Detener el Timer
                isAnimating = false; // Marcar que la animación ha terminado
            }

            // Aplicar el nuevo tamaño
//            panel.setBounds(panel.getX(), panel.getY(), anchoRedondeado, panel.getHeight());
//            panel.revalidate();
//            panel.repaint();
 panel.setPreferredSize(new Dimension(anchoRedondeado, panel.getHeight()));
            panel.revalidate(); // Recalcular el diseño del contenedor
            panel.repaint();
        }
    });

    timer.start();
    isExpanded = !isExpanded; // Alterna el estado del panel
}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        panelone = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        rSButtonIconI1 = new rojerusan.RSButtonIconI();
        panelRound2 = new Components.PanelRound();
        rSPanelCircleImage1 = new rojerusan.RSPanelCircleImage();
        txtrol = new javax.swing.JLabel();
        txtnombre = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        Iconbard = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Horas No Electivas");
        setBackground(new java.awt.Color(0, 0, 0));

        jPanel1.setBackground(new java.awt.Color(250, 250, 250));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelone.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("ELECTIVAS");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jButton1.setText("CONTRAER");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(88, 88, 88)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(31, 31, 31))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jLabel1))
                .addGap(23, 23, 23))
        );

        rSButtonIconI1.setBackground(new java.awt.Color(255, 255, 255));
        rSButtonIconI1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Abraham\\Documents\\NetBeansProjects\\SISTEMAELECTIVAS\\src\\main\\java\\Iconos\\anime.png")); // NOI18N
        rSButtonIconI1.setText("Iniciar");
        rSButtonIconI1.setColorText(new java.awt.Color(153, 153, 153));
        rSButtonIconI1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rSButtonIconI1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonIconI1ActionPerformed(evt);
            }
        });

        panelRound2.setBackground(new java.awt.Color(255, 255, 255));
        panelRound2.setBorderColor(new java.awt.Color(208, 213, 227));

        rSPanelCircleImage1.setColorBorde(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout rSPanelCircleImage1Layout = new javax.swing.GroupLayout(rSPanelCircleImage1);
        rSPanelCircleImage1.setLayout(rSPanelCircleImage1Layout);
        rSPanelCircleImage1Layout.setHorizontalGroup(
            rSPanelCircleImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );
        rSPanelCircleImage1Layout.setVerticalGroup(
            rSPanelCircleImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );

        txtrol.setText("---");

        txtnombre.setText("--");

        javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
        panelRound2.setLayout(panelRound2Layout);
        panelRound2Layout.setHorizontalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rSPanelCircleImage1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtrol)
                    .addComponent(txtnombre))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRound2Layout.setVerticalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelRound2Layout.createSequentialGroup()
                        .addComponent(txtnombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtrol))
                    .addComponent(rSPanelCircleImage1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout paneloneLayout = new javax.swing.GroupLayout(panelone);
        panelone.setLayout(paneloneLayout);
        paneloneLayout.setHorizontalGroup(
            paneloneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneloneLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(paneloneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneloneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneloneLayout.createSequentialGroup()
                        .addComponent(rSButtonIconI1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneloneLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(83, 83, 83))))
        );
        paneloneLayout.setVerticalGroup(
            paneloneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneloneLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(rSButtonIconI1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.add(panelone, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 230, 680));

        jButton2.setText("jButton2");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 360, 20, 60));

        jMenuBar1.setOpaque(true);
        jMenuBar1.setPreferredSize(new java.awt.Dimension(118, 40));
        jMenuBar1.add(Iconbard);

        jMenu2.setText("Ayuda");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Fuente");
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
     contraerPanel(panelone);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        contraerPanel(panelone);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void rSButtonIconI1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonIconI1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rSButtonIconI1ActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
try {
    UIManager.setLookAndFeel(new FlatLightLaf());
} catch (Exception e) {
    e.printStackTrace();
}
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Iconbard;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private Components.PanelRound panelRound2;
    private javax.swing.JPanel panelone;
    private rojerusan.RSButtonIconI rSButtonIconI1;
    private rojerusan.RSPanelCircleImage rSPanelCircleImage1;
    private javax.swing.JLabel txtnombre;
    private javax.swing.JLabel txtrol;
    // End of variables declaration//GEN-END:variables
}
