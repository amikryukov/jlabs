package javalabs.lab2;

public class MonthArray {

    private final static String HOW_TO_USE = "Should have only one integer parameter that lies in [1; 12]";

    // array that contains all 12 months with days number.
    private final static Month[] MONTHS = new Month[] {
            new Month("January", 31),
            new Month("February", 28),
            new Month("March", 31),
            new Month("April", 30),
            new Month("May", 31),
            new Month("June", 30),
            new Month("July", 31),
            new Month("August", 31),
            new Month("September", 30),
            new Month("October", 31),
            new Month("November", 30),
            new Month("December", 31)
    };

    public static void main(String[] args) {
        // check argument
        if (args.length != 1) {
            System.err.println(HOW_TO_USE);
            return;
        }

        try {
            Integer monthsNum = Integer.valueOf(args[0]) - 1;
            Month month = MONTHS[monthsNum];

            System.out.println(String.format("%s has %d days.", month.name, month.days));
        } catch (NumberFormatException e) {
            System.err.println(HOW_TO_USE);
        }
    }

    private static class Month {
        String name;
        int days;

        public Month(String name, int days) {
            this.name = name;
            this.days = days;
        }
    }
}


