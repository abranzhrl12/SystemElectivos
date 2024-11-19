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
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.formdev.flatlaf.extras.components.FlatButton;
import com.formdev.flatlaf.extras.components.FlatButton.ButtonType;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
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
         lblLupa.setIcon(new FlatSVGIcon(getClass().getResource("/Iconos/Icon.svg")));
//       this.getContentPane().setBackground("#00000");
       this.getContentPane().setBackground(new Color(247, 248, 250));

       //System.setProperty("flatlaf.windowDecorationColor", "#FFFFFF"); // Color blanco para la barra de título
       jMenuBar1.setBackground(Color.WHITE);
//  this.getRootPane().putClientProperty("JRootPane.titleBarBackground","#00000");
  this.getRootPane().putClientProperty("JRootPane.titleBarBackground", new Color(247, 248, 250));

   this.getRootPane().putClientProperty("JRootPane.frameBorder", null);
   
                FlatLightLaf.setup();
   // Crear un menú estándar
          // Crear el botón personalizado
        FlatButton usersButton = new FlatButton();
        usersButton.setIcon(new FlatSVGIcon("Iconos/iconNotification.svg")); // Ruta al ícono SVG
        usersButton.setButtonType(ButtonType.toolBarButton);
        usersButton.setPreferredSize(new Dimension(40,90));
        usersButton.setFocusable(false);
        usersButton.setPreferredSize(new Dimension(50, 30)); // Ancho fijo, altura ajustable más tarde
usersButton.setMaximumSize(new Dimension(50, Integer.MAX_VALUE)); // Altura para ocupar todo el espacio disponible


        FlatButton usersButton2 = new FlatButton();
        usersButton2.setIcon(new FlatSVGIcon("Iconos/iconMessage.svg",14 ,14)); // Ruta al ícono SVG
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
  
          FlatSVGIcon icon = new FlatSVGIcon("Iconos/arrowprev.svg");
          btnarrownext.setIcon(new FlatSVGIcon("Iconos/arrownext.svg"));
btnarrowprev.setIcon(icon);
       
panelr.putClientProperty(FlatClientProperties.STYLE, "arc:10");
panellateral.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, new Color(208, 213, 227)));

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
        panelPrincipal = new javax.swing.JPanel();
        panelone = new javax.swing.JPanel();
        flatTabbedPane1 = new com.formdev.flatlaf.extras.components.FlatTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        panelRound2 = new Components.PanelRound();
        txtrol = new javax.swing.JLabel();
        txtnombre = new javax.swing.JLabel();
        rSPanelCircleImage1 = new rojerusan.RSPanelCircleImage();
        rSButtonIconI1 = new rojerusan.RSButtonIconI();
        panellateral = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        flatButton1 = new com.formdev.flatlaf.extras.components.FlatButton();
        flatButton2 = new com.formdev.flatlaf.extras.components.FlatButton();
        flatButton3 = new com.formdev.flatlaf.extras.components.FlatButton();
        flatButton4 = new com.formdev.flatlaf.extras.components.FlatButton();
        lblLupa = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        btnarrownext = new com.formdev.flatlaf.extras.components.FlatButton();
        btnarrowprev = new com.formdev.flatlaf.extras.components.FlatButton();
        panelr = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        flatTextField2 = new com.formdev.flatlaf.extras.components.FlatTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        Iconbard = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Horas No Electivas");
        setBackground(new java.awt.Color(0, 0, 0));

        panelPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        panelPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelone.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout paneloneLayout = new javax.swing.GroupLayout(panelone);
        panelone.setLayout(paneloneLayout);
        paneloneLayout.setHorizontalGroup(
            paneloneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );
        paneloneLayout.setVerticalGroup(
            paneloneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 110, Short.MAX_VALUE)
        );

        panelPrincipal.add(panelone, new org.netbeans.lib.awtextra.AbsoluteConstraints(566, 140, -1, -1));

        flatTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        flatTabbedPane1.setTabType(com.formdev.flatlaf.extras.components.FlatTabbedPane.TabType.underlined);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 530, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 255, Short.MAX_VALUE)
        );

        flatTabbedPane1.addTab("tab2", jPanel3);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 530, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 255, Short.MAX_VALUE)
        );

        flatTabbedPane1.addTab("tab1", jPanel2);

        panelPrincipal.add(flatTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 280, -1, -1));

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

        panelPrincipal.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(726, 135, -1, -1));

        panelRound2.setBackground(new java.awt.Color(255, 255, 255));
        panelRound2.setBorderColor(new java.awt.Color(208, 213, 227));

        txtrol.setText("---");

        txtnombre.setText("--");

        javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
        panelRound2.setLayout(panelRound2Layout);
        panelRound2Layout.setHorizontalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addGap(174, 174, 174)
                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtrol)
                    .addComponent(txtnombre))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRound2Layout.setVerticalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addComponent(txtnombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtrol)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelPrincipal.add(panelRound2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 190, 140, 80));

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

        panelPrincipal.add(rSPanelCircleImage1, new org.netbeans.lib.awtextra.AbsoluteConstraints(649, 210, -1, -1));

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
        panelPrincipal.add(rSButtonIconI1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 710, 257, -1));

        panellateral.setBackground(new java.awt.Color(204, 204, 204));
        panellateral.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(255, 0, 0));

        flatButton1.setText("Dashboard");
        flatButton1.setButtonType(com.formdev.flatlaf.extras.components.FlatButton.ButtonType.toolBarButton);
        flatButton1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        flatButton1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        flatButton2.setText("Asignar Actividades");
        flatButton2.setButtonType(com.formdev.flatlaf.extras.components.FlatButton.ButtonType.toolBarButton);

        flatButton3.setText("Ver Reportes");
        flatButton3.setButtonType(com.formdev.flatlaf.extras.components.FlatButton.ButtonType.toolBarButton);

        flatButton4.setText("Registrar Actividades");
        flatButton4.setButtonType(com.formdev.flatlaf.extras.components.FlatButton.ButtonType.toolBarButton);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(flatButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(flatButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(flatButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(flatButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(flatButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(flatButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(flatButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(flatButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(528, Short.MAX_VALUE))
        );

        panellateral.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 16, -1, -1));

        panelPrincipal.add(panellateral, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, -1, 710));

        lblLupa.setBackground(new java.awt.Color(255, 204, 0));
        panelPrincipal.add(lblLupa, new org.netbeans.lib.awtextra.AbsoluteConstraints(514, 117, 58, 35));

        jPanel1.setBackground(new java.awt.Color(247, 248, 250));

        jPanel6.setBackground(new java.awt.Color(255, 51, 51));
        jPanel6.setLayout(new java.awt.GridLayout(1, 0));

        btnarrownext.setBackground(new java.awt.Color(102, 255, 51));
        btnarrownext.setBorder(null);
        btnarrownext.setButtonType(com.formdev.flatlaf.extras.components.FlatButton.ButtonType.toolBarButton);
        jPanel6.add(btnarrownext);

        btnarrowprev.setBackground(new java.awt.Color(255, 204, 102));
        btnarrowprev.setBorder(null);
        btnarrowprev.setButtonType(com.formdev.flatlaf.extras.components.FlatButton.ButtonType.toolBarButton);
        jPanel6.add(btnarrowprev);

        panelr.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Silabo   /   Desarrollo de Soluciones Informáticas");

        javax.swing.GroupLayout panelrLayout = new javax.swing.GroupLayout(panelr);
        panelr.setLayout(panelrLayout);
        panelrLayout.setHorizontalGroup(
            panelrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelrLayout.createSequentialGroup()
                .addGap(158, 158, 158)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                .addGap(159, 159, 159))
        );
        panelrLayout.setVerticalGroup(
            panelrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelrLayout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        flatTextField2.setMargin(new java.awt.Insets(2, 6, 2, 15));
        flatTextField2.setPadding(new java.awt.Insets(0, 0, 0, 15));
        flatTextField2.setTrailingComponent(lblLupa);
        flatTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                flatTextField2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(24, 24, 24)
                .addComponent(flatTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                .addGap(17, 17, 17))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(flatTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelr, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(0, 10, Short.MAX_VALUE))
        );

        panelPrincipal.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1040, 46));

        jMenuBar1.setBackground(new java.awt.Color(247, 248, 250));
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
                .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
     contraerPanel(panelone);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void rSButtonIconI1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonIconI1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rSButtonIconI1ActionPerformed

    private void flatTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_flatTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_flatTextField2ActionPerformed

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
    private com.formdev.flatlaf.extras.components.FlatButton btnarrownext;
    private com.formdev.flatlaf.extras.components.FlatButton btnarrowprev;
    private com.formdev.flatlaf.extras.components.FlatButton flatButton1;
    private com.formdev.flatlaf.extras.components.FlatButton flatButton2;
    private com.formdev.flatlaf.extras.components.FlatButton flatButton3;
    private com.formdev.flatlaf.extras.components.FlatButton flatButton4;
    private com.formdev.flatlaf.extras.components.FlatTabbedPane flatTabbedPane1;
    private com.formdev.flatlaf.extras.components.FlatTextField flatTextField2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel lblLupa;
    private javax.swing.JPanel panelPrincipal;
    private Components.PanelRound panelRound2;
    private javax.swing.JPanel panellateral;
    private javax.swing.JPanel panelone;
    private javax.swing.JPanel panelr;
    private rojerusan.RSButtonIconI rSButtonIconI1;
    private rojerusan.RSPanelCircleImage rSPanelCircleImage1;
    private javax.swing.JLabel txtnombre;
    private javax.swing.JLabel txtrol;
    // End of variables declaration//GEN-END:variables
}
