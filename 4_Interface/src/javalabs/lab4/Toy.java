package javalabs.lab4;

public class Toy implements Present {
    @Override
    public int getAgeLimit() {
        return 3;
    }

    @Override
    public int getPrice(int id) {
        return 5;
    }

    @Override
    public void showName() {
        System.out.println("Toy");
    }
}
