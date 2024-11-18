/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 *
 * @author Abraham
 */
public class RoundedShadowPanel2 extends JPanel {
   private int roundTopLeft = 0;
    private int roundTopRight = 0;
    private int roundBottomLeft = 0;
    private int roundBottomRight = 0;

    private int shadowSize = 5;
    private Color shadowColor = new Color(0, 0, 0, 50); // Color de sombra negro con opacidad
    private int shadowOpacity = 50; // Opacidad de la sombra (0-255)

    private BufferedImage shadowImage;

    public int getRoundTopLeft() {
        return roundTopLeft;
    }

    public void setRoundTopLeft(int roundTopLeft) {
        this.roundTopLeft = roundTopLeft;
        repaint();
    }

    public int getRoundTopRight() {
        return roundTopRight;
    }

    public void setRoundTopRight(int roundTopRight) {
        this.roundTopRight = roundTopRight;
        repaint();
    }

    public int getRoundBottomLeft() {
        return roundBottomLeft;
    }

    public void setRoundBottomLeft(int roundBottomLeft) {
        this.roundBottomLeft = roundBottomLeft;
        repaint();
    }

    public int getRoundBottomRight() {
        return roundBottomRight;
    }

    public void setRoundBottomRight(int roundBottomRight) {
        this.roundBottomRight = roundBottomRight;
        repaint();
    }

    public int getShadowSize() {
        return shadowSize;
    }

    public void setShadowSize(int shadowSize) {
        this.shadowSize = shadowSize;
        createShadowImage(); // Vuelve a crear la imagen de sombra cuando se cambia el tamaño de la sombra
        repaint();
    }

    public Color getShadowColor() {
        return shadowColor;
    }

    public void setShadowColor(Color shadowColor) {
        this.shadowColor = shadowColor;
        createShadowImage(); // Vuelve a crear la imagen de sombra cuando se cambia el color de la sombra
        repaint();
    }

    public int getShadowOpacity() {
        return shadowOpacity;
    }

    public void setShadowOpacity(int shadowOpacity) {
        this.shadowOpacity = shadowOpacity;
        createShadowImage(); // Vuelve a crear la imagen de sombra cuando se cambia la opacidad de la sombra
        repaint();
    }

    public RoundedShadowPanel2() {
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs);

        if (shadowImage == null || shadowImage.getWidth() != getWidth() || shadowImage.getHeight() != getHeight()) {
            createShadowImage();
        }

        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Dibujar la sombra
        g2.drawImage(shadowImage, 0, 0, null);

        // Dibujar el panel redondeado encima de la sombra
        g2.setColor(getBackground());
        g2.fillRoundRect(shadowSize, shadowSize, getWidth() - 2 * shadowSize, getHeight() - 2 * shadowSize,
                roundTopLeft, roundTopLeft);

        g2.dispose();
    }

    private void createShadowImage() {
        try {
           shadowImage = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = shadowImage.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Dibujar la sombra con el nuevo color y opacidad
        int shadowOffset = shadowSize * 2;
        int shadowWidth = getWidth() - shadowOffset;
        int shadowHeight = getHeight() - shadowOffset;

        RoundRectangle2D rect = new RoundRectangle2D.Double(shadowSize, shadowSize, shadowWidth, shadowHeight,
                roundTopLeft, roundTopLeft);

        g2.setColor(new Color(shadowColor.getRed(), shadowColor.getGreen(), shadowColor.getBlue(), shadowOpacity));
        g2.fill(rect);

        g2.dispose();  
        } catch (Exception e) {
        }
       
    }
}
