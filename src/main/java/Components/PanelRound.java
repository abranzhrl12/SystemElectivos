package Components;

import Components.ShadowRenderer;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public class PanelRound extends JPanel {
    
    private int roundTopLeft = 0;
    private int roundTopRight = 0;
    private int roundBottomLeft = 0;
    private int roundBottomRight = 0;

    private int shadowSize = 5;
    private Color shadowColor = new Color(0, 0, 0, 50); // Color de sombra con opacidad
    private int shadowOpacity = 50; // Opacidad de la sombra (0-255)

    private BufferedImage shadowImage;

    private int cornerRadius = 25; // Radio de redondeo de los bordes
    private Color borderColor = new Color(0,0,0,10); // Color del borde por defecto
    private int borderWidth = 1; // Ancho del borde por defecto
    
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
    repaint();
}

    public void setShadowColor(Color shadowColor) {
        this.shadowColor = shadowColor;
        repaint();
    }


  
   public Color getShadowColor() {
        return shadowColor;
    }
    public int getShadowOpacity() {
        return shadowOpacity;
    }

    public void setShadowOpacity(int shadowOpacity) {
        this.shadowOpacity = shadowOpacity;
        repaint();
    }
    
    
    public PanelRound() {
        setOpaque(false);
    }

 

    public int getCornerRadius() {
        return cornerRadius;
    }

    public void setCornerRadius(int cornerRadius) {
        this.cornerRadius = cornerRadius;
        repaint();
    }

    public Color getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
        repaint();
    }

    public int getBorderWidth() {
        return borderWidth;
    }

    public void setBorderWidth(int borderWidth) {
        this.borderWidth = borderWidth;
        repaint();
    }

//    public PanelRound() {
//        setOpaque(false);
//    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs);
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Dibuja la sombra
        if (shadowImage == null || shadowImage.getWidth() != getWidth() || shadowImage.getHeight() != getHeight()) {
            createShadowImage();
        }
        g2.drawImage(shadowImage, 0, 0, null); // Dibuja la sombra en la posición inicial (0, 0)

        // Dibuja el borde redondeado
        Stroke oldStroke = g2.getStroke();
        g2.setStroke(new BasicStroke(borderWidth));
        g2.setColor(borderColor);
        g2.drawRoundRect(borderWidth / 2, borderWidth / 2,
                getWidth() - borderWidth, getHeight() - borderWidth,
                cornerRadius, cornerRadius);

        // Dibuja el panel redondeado
        g2.setColor(getBackground());
        g2.fillRoundRect(borderWidth, borderWidth,
                getWidth() - 2 * borderWidth, getHeight() - 2 * borderWidth,
                cornerRadius, cornerRadius);

        g2.setStroke(oldStroke); // Restaura el stroke original
        g2.dispose();
    }

private void createShadowImage() {
    shadowImage = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
    Graphics2D g2 = shadowImage.createGraphics();
    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

    // Calcula las dimensiones del área de la sombra
    int shadowWidth = getWidth() - shadowSize * 2;
    int shadowHeight = getHeight() - shadowSize * 2;

    // Crea una forma redondeada para la sombra
    RoundRectangle2D.Float shadowRect = new RoundRectangle2D.Float(
            shadowSize, shadowSize, shadowWidth, shadowHeight,
            getRoundTopLeft(), getRoundTopLeft()); // Utiliza los mismos radios que el panel

    // Dibuja la sombra con los bordes redondeados
    g2.setColor(new Color(shadowColor.getRed(), shadowColor.getGreen(), shadowColor.getBlue(), shadowOpacity));
    g2.fill(shadowRect);

    g2.dispose();
}
    private Shape createRoundTopLeft() {
        int width = getWidth();
        int height = getHeight();
        int roundX = Math.min(width, roundTopLeft);
        int roundY = Math.min(height, roundTopLeft);
        Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, roundX, roundY));
        area.add(new Area(new Rectangle2D.Double(roundX / 2, 0, width - roundX / 2, height)));
        area.add(new Area(new Rectangle2D.Double(0, roundY / 2, width, height - roundY / 2)));
        return area;
    }

    private Shape createRoundTopRight() {
        int width = getWidth();
        int height = getHeight();
        int roundX = Math.min(width, roundTopRight);
        int roundY = Math.min(height, roundTopRight);
        Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, roundX, roundY));
        area.add(new Area(new Rectangle2D.Double(0, 0, width - roundX / 2, height)));
        area.add(new Area(new Rectangle2D.Double(0, roundY / 2, width, height - roundY / 2)));
        return area;
    }

    private Shape createRoundBottomLeft() {
        int width = getWidth();
        int height = getHeight();
        int roundX = Math.min(width, roundBottomLeft);
        int roundY = Math.min(height, roundBottomLeft);
        Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, roundX, roundY));
        area.add(new Area(new Rectangle2D.Double(roundX / 2, 0, width - roundX / 2, height)));
        area.add(new Area(new Rectangle2D.Double(0, 0, width, height - roundY / 2)));
        return area;
    }

    private Shape createRoundBottomRight() {
        int width = getWidth();
        int height = getHeight();
        int roundX = Math.min(width, roundBottomRight);
        int roundY = Math.min(height, roundBottomRight);
        Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, roundX, roundY));
        area.add(new Area(new Rectangle2D.Double(0, 0, width - roundX / 2, height)));
        area.add(new Area(new Rectangle2D.Double(0, 0, width, height - roundY / 2)));
        return area;
    }
    
 
   
}
