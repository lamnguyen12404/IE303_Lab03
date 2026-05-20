import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ProductCard extends RoundedPanel {

    private Product product;

    public ProductCard(Product product) {

        super(25, new Color(245,245,245));

        this.product = product;

        setPreferredSize(new Dimension(250, 300));

        setLayout(null);

        // TITLE
        JLabel title = new JLabel(shortText(product.getName(), 14));

        title.setBounds(15, 15, 220, 30);

        title.setFont(new Font("Arial", Font.BOLD, 18));

        // DESC
        JLabel desc = new JLabel(shortText(product.getDesc(), 26));

        desc.setBounds(15, 45, 220, 25);

        desc.setForeground(Color.GRAY);

        desc.setFont(new Font("Arial", Font.PLAIN, 13));

        // IMAGE
        ImageIcon icon = new ImageIcon(product.getImage());

        Image img = icon.getImage().getScaledInstance(
                180,
                180,
                Image.SCALE_SMOOTH
        );

        JLabel image = new JLabel(new ImageIcon(img));

        image.setBounds(30, 90, 180, 120);

        // BRAND
        JLabel brand = new JLabel("Adidas");

        brand.setBounds(15, 235, 100, 25);

        brand.setForeground(Color.GRAY);

        brand.setFont(new Font("Arial", Font.PLAIN, 14));

        // PRICE
        JLabel price = new JLabel(product.getPrice());

        price.setBounds(145, 225, 120, 40);

        price.setFont(new Font("Arial", Font.BOLD, 22));

        add(title);
        add(desc);
        add(image);
        add(brand);
        add(price);

        // HOVER EFFECT
        addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {

                setPanelColor(Color.WHITE);

                setBorder(BorderFactory.createLineBorder(
                        new Color(120,170,255),
                        2
                ));
            }

            @Override
            public void mouseExited(MouseEvent e) {

                setPanelColor(new Color(245,245,245));

                setBorder(null);
            }
        });
    }

    private String shortText(String text, int max) {

        if(text.length() <= max) {
            return text;
        }

        return text.substring(0, max) + "...";
    }
}