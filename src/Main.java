import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Main extends JFrame {

    private JLabel bigImage;
    private JLabel bigTitle;
    private JLabel bigPrice;
    private JLabel bigBrand;
    private JTextArea bigDesc;

    private ArrayList<Product> products = new ArrayList<>();

    public Main() {

        setTitle("Shoes Store");

        setSize(1500, 800);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        createData();

        JPanel root = new JPanel(new BorderLayout());

        root.setBackground(Color.WHITE);

        // LEFT PANEL

        JPanel leftPanel = new JPanel();

        leftPanel.setPreferredSize(new Dimension(400, 800));

        leftPanel.setBackground(Color.WHITE);

        leftPanel.setLayout(null);

        // BIG IMAGE
        bigImage = new JLabel();

        bigImage.setBounds(40, 80, 300, 180);

        // LINE
        JSeparator line = new JSeparator();

        line.setBounds(25, 310, 350, 1);

        // TITLE
        bigTitle = new JLabel();

        bigTitle.setBounds(25, 330, 350, 50);

        bigTitle.setFont(new Font("Arial", Font.BOLD, 28));

        // PRICE
        bigPrice = new JLabel();

        bigPrice.setBounds(25, 380, 200, 40);

        bigPrice.setFont(new Font("Arial", Font.BOLD, 22));

        // BRAND
        bigBrand = new JLabel("Adidas");

        bigBrand.setBounds(25, 420, 150, 30);

        bigBrand.setForeground(Color.GRAY);

        bigBrand.setFont(new Font("Arial", Font.PLAIN, 18));

        // DESC
        bigDesc = new JTextArea();

        bigDesc.setBounds(25, 460, 330, 120);

        bigDesc.setWrapStyleWord(true);

        bigDesc.setLineWrap(true);

        bigDesc.setEditable(false);

        bigDesc.setBackground(Color.WHITE);

        bigDesc.setForeground(Color.GRAY);

        bigDesc.setFont(new Font("Arial", Font.BOLD, 16));

        leftPanel.add(bigImage);
        leftPanel.add(line);
        leftPanel.add(bigTitle);
        leftPanel.add(bigPrice);
        leftPanel.add(bigBrand);
        leftPanel.add(bigDesc);

        // RIGHT PANEL

        JPanel productsPanel = new JPanel();

        productsPanel.setBackground(Color.WHITE);

        productsPanel.setLayout(new GridLayout(
                2,
                4,
                15,
                15
        ));

        productsPanel.setPreferredSize(new Dimension(1100, 650));

        for(Product p : products) {

            ProductCard card = new ProductCard(p);

            card.addMouseListener(new java.awt.event.MouseAdapter() {

                @Override
                public void mouseClicked(java.awt.event.MouseEvent e) {

                    animateChange(p);
                }
            });

            productsPanel.add(card);
        }

        JScrollPane scrollPane = new JScrollPane(productsPanel);

        scrollPane.setBorder(null);

        scrollPane.getViewport().setBackground(Color.WHITE);

        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        scrollPane.getVerticalScrollBar().setPreferredSize(
                new Dimension(8, 0)
        );

        root.add(leftPanel, BorderLayout.WEST);

        root.add(scrollPane, BorderLayout.CENTER);

        add(root);

        // DEFAULT PRODUCT
        showProduct(products.get(0));
    }

    // SHOW PRODUCT

    private void showProduct(Product p) {

        ImageIcon icon = new ImageIcon(p.getImage());

        Image img = icon.getImage().getScaledInstance(
                300,
                300,
                Image.SCALE_SMOOTH
        );

        bigImage.setIcon(new ImageIcon(img));

        bigTitle.setText(p.getName());

        bigPrice.setText(p.getPrice());

        bigDesc.setText(p.getDesc());
    }

    // ANIMATION 

    private void animateChange(Product p) {

        Timer timer = new Timer(5, null);
    
        final int[] x = {40};
    
        timer.addActionListener(e -> {
    
            x[0] -= 15;
    
            bigImage.setLocation(x[0], 60);
    
            // fade effect
            bigImage.setVisible(x[0] % 30 < 15);
    
            if(x[0] <= -350) {
    
                // đổi ảnh mới
                ImageIcon icon = new ImageIcon(p.getImage());
    
                Image img = icon.getImage().getScaledInstance(
                        300,
                        300,
                        Image.SCALE_SMOOTH
                );
    
                bigImage.setIcon(new ImageIcon(img));
    
                // bắt đầu từ bên phải
                x[0] = 450;
    
                Timer timer2 = new Timer(5, null);
    
                timer2.addActionListener(ev -> {
    
                    x[0] -= 15;
    
                    bigImage.setLocation(x[0], 60);
    
                    bigImage.setVisible(true);
    
                    if(x[0] <= 40) {
    
                        bigImage.setLocation(40, 60);
    
                        timer2.stop();
                    }
                });
    
                timer2.start();
    
                bigTitle.setText(p.getName());
    
                bigPrice.setText(p.getPrice());
    
                bigDesc.setText(p.getDesc());
    
                timer.stop();
            }
        });
    
        timer.start();
    }

    // DATA 

    private void createData() {

        products.add(new Product(
                "4DFWD PULSE SHOES",
                "$160.00",
                "This product is excluded from all promotional discounts and offers.",
                "src/images/img1.png"
        ));

        products.add(new Product(
                "FORUM MID SHOES",
                "$100.00",
                "This product is excluded from all promotional discounts and offers.",
                "src/images/img2.png"
        ));

        products.add(new Product(
                "SUPERNOVA SHOES",
                "$150.00",
                "NMD City Stock 2",
                "src/images/img3.png"
        ));

        products.add(new Product(
                "Adidas",
                "$160.00",
                "NMD City Stock 2",
                "src/images/img4.png"
        ));

        products.add(new Product(
                "Adidas",
                "$120.00",
                "NMD City Stock 2",
                "src/images/img5.png"
        ));

        products.add(new Product(
                "4DFWD PULSE SHOES",
                "$160.00",
                "This product is excluded from all promotional discounts and offers.",
                "src/images/img6.png"
        ));

        products.add(new Product(
                "4DFWD PULSE SHOES",
                "$160.00",
                "This product is excluded from all promotional discounts and offers.",
                "src/images/img1.png"
        ));

        products.add(new Product(
                "FORUM MID SHOES",
                "$100.00",
                "This product is excluded from all promotional discounts and offers.",
                "src/images/img2.png"
        ));
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new Main().setVisible(true);
        });
    }
}