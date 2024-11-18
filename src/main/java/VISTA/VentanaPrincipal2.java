/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VISTA;

import com.formdev.flatlaf.FlatLightLaf;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.util.TimerTask;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



/**
 *
 * @author Abraham
 */
public class VentanaPrincipal2 extends  JFrame{
 private Timer dragTimer; // Temporizador para detectar arrastre prolongado
    private boolean isDraggingToTop = false;
    private Point initialClick;
    private final int SNAP_MARGIN = 10; // Margen para ajuste
    private final int MAX_DRAG_TIME = 1000; // 1 segundo
    private final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // Tamaño de la pantalla

    public VentanaPrincipal2() {
        // Configurar JFrame
        setUndecorated(true); // Sin decoraciones
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);

        // Agregar movimiento de la ventana
        addDragFeature();

        // Hacer visible
        setVisible(true);
    }

    private void addDragFeature() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                initialClick = e.getPoint();
                isDraggingToTop = false;

                // Iniciar un temporizador para detectar arrastre prolongado
                if (dragTimer != null) {
                    dragTimer.stop(); // Detener el temporizador anterior si existe
                }
                dragTimer = new Timer(MAX_DRAG_TIME, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        isDraggingToTop = true; // Después de 1 segundo, marcar como "arrastre hacia arriba"
                        dragTimer.stop(); // Detener el temporizador
                    }
                });
                dragTimer.setRepeats(false); // Asegurarse de que se ejecute solo una vez
                dragTimer.start();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (dragTimer != null) {
                    dragTimer.stop();
                }

                // Maximizar si se arrastra hacia el borde superior por más de 1 segundo
                if (isDraggingToTop && getY() <= SNAP_MARGIN) {
                    setBounds(0, 0, screenSize.width, screenSize.height);
                } else {
                    // Asegurarse de que la ventana permanezca dentro de los márgenes
                    int x = Math.max(SNAP_MARGIN, Math.min(getX(), screenSize.width - getWidth() - SNAP_MARGIN));
                    int y = Math.max(SNAP_MARGIN, Math.min(getY(), screenSize.height - getHeight() - SNAP_MARGIN));
                    setLocation(x, y);
                }
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int thisX = getLocation().x;
                int thisY = getLocation().y;

                // Determinar nueva posición
                int xMoved = e.getX() - initialClick.x;
                int yMoved = e.getY() - initialClick.y;

                int newX = thisX + xMoved;
                int newY = thisY + yMoved;

                // Asegurarse de que la ventana no traspase los límites
                newX = Math.max(SNAP_MARGIN, Math.min(newX, screenSize.width - getWidth() - SNAP_MARGIN));
                newY = Math.max(SNAP_MARGIN, Math.min(newY, screenSize.height - getHeight() - SNAP_MARGIN));

                // Actualizar la posición de la ventana
                setLocation(newX, newY);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VentanaPrincipal2());
    }
}
