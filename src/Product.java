public class Product {

    private String name;
    private String price;
    private String desc;
    private String image;

    public Product(String name, String price, String desc, String image) {
        this.name = name;
        this.price = price;
        this.desc = desc;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getDesc() {
        return desc;
    }

    public String getImage() {
        return image;
    }
}