package javalabs.lab4;

class Store {
    static Shoe hightop;
    static Book using_java;
    public static void init() {
        hightop = new Shoe();
        using_java = new Book();
    }

    public static void main(String argv[]) {
        init();
        orderInfo(hightop);
        orderInfo(using_java);
    }
    public static void orderInfo(Product item) {
        item.showName();
        System.out.println("To order from " +   item.MAKER + " call " + item.PHONE + ".");
                System.out.println("Each item costs $" + item.getPrice(1));
    }
}