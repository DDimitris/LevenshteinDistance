package ui;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Image;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JPanel;

/**
 * JPanel which supports background image, custom opacity, rounded corners
 * and border line.
 */
public class BackgroundedPanel extends JPanel {
    
    protected java.awt.Composite comp;
    
    private float alpha = 1f;
    private boolean colorIsNull;
    private Image backImage;
    private Color borderLine;
    private boolean rounded;
    protected int arcWidth = 12;
    protected int arcHeight = 12;
    
    private boolean fillTopLeft, fillTopRight, fillBottomLeft, fillBottomRight;
    
    {
        setOpaque(false);
        alpha = 1f;
        comp = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
    }
    
    public BackgroundedPanel() {
    }

    public BackgroundedPanel(LayoutManager layout) {
        super(layout);
    }

    public BackgroundedPanel(LayoutManager layout, boolean isDoubleBuffered) {
        super(layout, isDoubleBuffered);
    }

    public BackgroundedPanel(float alpha, Image backImage) {
        this.alpha = alpha;
        this.backImage = backImage;
    }

    public BackgroundedPanel(float alpha, Color backColor, Image backImage, boolean rounded) {
        this.alpha = alpha;
        colorIsNull = backColor == null;
        setBackground(backColor);
        this.backImage = backImage;
        this.rounded = rounded;
        comp = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
        setBackground(backColor);
    }

    public Color getBorderLine() {
        return borderLine;
    }

    public void setBorderLine(Color borderLine) {
        this.borderLine = borderLine;
    }
    
    public void setCornerFills(boolean topLeft, boolean topRight,
            boolean bottomLeft, boolean bottomRight) {
        fillTopLeft = topLeft;
        fillTopRight = topRight;
        fillBottomLeft = bottomLeft;
        fillBottomRight = bottomRight;
        repaint();
    }
    
    public void setAlpha(float alpha) {
        this.alpha = alpha;
        comp = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
        repaint();
    }

    public float getAlpha() {
        return alpha;
    }

    public boolean isRounded() {
        return rounded;
    }

    public void setRounded(boolean rounded) {
        this.rounded = rounded;
        repaint();
    }
    
    public void setBackImage(Image backImage) {
        this.backImage = backImage;
        repaint();
    }

    public Image getBackImage() {
        return backImage;
    }

    @Override
    public void setBackground(Color bg) {
        super.setBackground(bg);
        colorIsNull = bg == null;
        repaint();
    }

    @Override
    public void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);
        
        Insets insets;
        if (getBorder() != null) {
            insets = getInsets();
        } else {
            insets = new Insets(0, 0, 0, 0);
        }
        java.awt.Graphics2D g2
        = (java.awt.Graphics2D) g;
        java.awt.Composite oldComp = g2.getComposite();
        g2.setComposite(comp);
        int x = insets.left,
            y = insets.top,
            width = getWidth()-insets.right-insets.left,
            height = getHeight()-insets.bottom-insets.top;
        if (!colorIsNull || getBorderLine() != null) {
            if (rounded) {
                Area ar = new Area(new RoundRectangle2D.Float(x, y, width-1, height-1, arcWidth, arcHeight));
                Rectangle corner = new Rectangle();
                if (fillTopLeft) {
                    corner.setBounds(x, y, arcWidth, arcHeight);
                    ar.add(new Area(corner));
                }
                if (fillTopRight) {
                    corner.setBounds(width-1-arcWidth, y, arcWidth, arcHeight);
                    ar.add(new Area(corner));
                }
                if (fillBottomLeft) {
                    corner.setBounds(x, height-1-arcHeight, arcWidth, arcHeight);
                    ar.add(new Area(corner));
                }
                if (fillBottomRight) {
                    corner.setBounds(width-1-arcWidth, height-1-arcHeight, arcWidth, arcHeight);
                    ar.add(new Area(corner));
                }
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                if (!colorIsNull) {
                    g2.setColor(getBackground());
                    g2.fill(ar);
                }
                if (borderLine != null) {
                    g2.setColor(borderLine);
                    g2.draw(ar);
                }
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
                
            } else {
                if (!colorIsNull) {
                    g2.setColor(getBackground());
                    g2.fillRect(x, y, width-1, height-1);
                }
                if (borderLine != null) {
                    g2.setColor(borderLine);
                    g2.drawRect(x, y, width-1, height-1);
                }
            }
        }
        g2.setComposite(oldComp);
        if (backImage != null) {
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.drawImage(backImage,
                    x, y, width, height,
                    0, 0, backImage.getWidth(null), backImage.getHeight(null),
                    null);
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
        }
//        g.dispose();
    } 
           
}