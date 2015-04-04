package javalabs.lab4;

public class Puzzle implements Present {
    @Override
    public int getAgeLimit() {
        return 8;
    }

    @Override
    public int getPrice(int id) {
        return 10;
    }

    @Override
    public void showName() {
        System.out.println("Puzzle");
    }
}
