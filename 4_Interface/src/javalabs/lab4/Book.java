package javalabs.lab4;

class Book implements Product {
    public int getPrice(int id) {
        if (id == 1)
            return(20);
        else
            return(30);
    }
    public void showName() {
        System.out.println("I'm a book!");
    }
}