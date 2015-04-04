package javalabs.lab4;

public class Application {

    public static void main(String[] args) {
        Product[] products = getProducts();
        System.out.println("Products with age limit:");
        for(Product product : products) {
            if (product instanceof Present) {
                product.showName();
                System.out.println("\t" + ((Present) product).getAgeLimit());
            }
        }
    }

    public static Product[] getProducts() {
        return new Product[] {
                new Book(), new Puzzle(), new Shoe(), new Toy()
        };
    }
}
