package javalabs.lab4;

class Shoe implements Product {
    public int getPrice(int id) {
        if (id == 1)
            return(5);
        else
            return(10);
    }
    public void showName() {
        System.out.println("I'm a shoe!");
    }
}