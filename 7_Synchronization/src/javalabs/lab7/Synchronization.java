package javalabs.lab7;

import java.util.concurrent.atomic.AtomicInteger;

public class Synchronization {

    private static final String USAGE = "Should have 2 arguments, " +
            "first - number of threads, second - number of lines to print";

    private static volatile AtomicInteger line = new AtomicInteger(0);
    private static final AtomicInteger position = new AtomicInteger(0);

    public static void main(String[] args) {
        try {
            if (args.length != 2) {
                // dummy
                throw new NumberFormatException();
            }
            final int threadsCount = Integer.parseInt(args[0]);
            final int linesNumber = Integer.parseInt(args[1]);

            if(linesNumber < 1 || threadsCount < 1) {
                throw new NumberFormatException();
            }

            for (int i = 0; i < threadsCount; i++) {
                final int poss = i;
                new Thread(
                        new Runnable() {

                            private int pos = poss;

                            @Override
                            public void run() {
                                while (line.get() < linesNumber) {
                                    synchronized (position) {
                                        while (position.get() != pos) {
                                            try {
                                                position.wait();
                                            } catch (InterruptedException e) {
                                                // do nothing
                                            }
                                        }
                                        System.out.print(pos);
                                        sleep(100);

                                        // process end of line
                                        if (position.get() < threadsCount - 1) {
                                            System.out.print(", ");
                                            sleep(100);
                                            position.incrementAndGet();

                                            position.notifyAll();
                                            if (line.get() >= linesNumber - 1) {
                                                break;
                                            }
                                        } else {
                                            System.out.print("\n");
                                            sleep(100);

                                            position.set(0);

                                            position.notifyAll();
                                            if (line.get() >= linesNumber - 1) {
                                                break;
                                            }
                                            line.incrementAndGet();
                                        }
                                    }
                                }
                            }
                        }
                ).start();
            }

        } catch (NumberFormatException e) {
            System.err.println(USAGE);
        }
    }

    /**
     * Sleep mils milliseconds; return on interrupt
     * @param mils milliseconds to sleep
     */
    static void sleep(long mils) {
        try {
            Thread.sleep(mils);
        } catch (InterruptedException e) {
            // do nothing
        }
    }
}
