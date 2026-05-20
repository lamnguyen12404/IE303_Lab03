import javax.swing.*;
import java.awt.*;

public class RoundedPanel extends JPanel {

    private int radius;
    private Color bgColor;

    public RoundedPanel(int radius, Color bgColor) {

        this.radius = radius;
        this.bgColor = bgColor;

        setOpaque(false);
    }

    public void setPanelColor(Color color) {
        this.bgColor = color;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON
        );

        g2.setColor(bgColor);

        g2.fillRoundRect(
                0,
                0,
                getWidth(),
                getHeight(),
                radius,
                radius
        );

        g2.dispose();

        super.paintComponent(g);
    }
}