package javalabs.lab4;

public interface Product {
    String MAKER = "My Corp";
    static final String PHONE = "555-123-4567";
    public int getPrice(int id);
    public void showName();
}
