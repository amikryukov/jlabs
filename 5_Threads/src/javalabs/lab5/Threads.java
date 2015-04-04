package javalabs.lab5;

import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class Threads {
    public static CopyOnWriteArrayList<Integer> wherehouse = new CopyOnWriteArrayList<>();

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Start Writer");
        Writer writer = new Writer();
        writer.start();

        System.out.println("Start Reader");
        Reader reader = new Reader();
        reader.start();


        Thread.sleep(5000L);
        writer.deActive();
        reader.deActive();
    }
}

class Reader extends Thread {
    private AtomicBoolean isActive = new AtomicBoolean(true);

    @Override
    public void run() {

        int size = 0;
        while (isActive.get()) {

            // read only new products
            int currentWherehouseSize = Threads.wherehouse.size();
            for (int i = size; i < currentWherehouseSize; i++ ) {
                System.out.println("Reader: " + Threads.wherehouse.get(i));
            }

            size = currentWherehouseSize;
            try {
                Thread.sleep(100L);
            } catch (InterruptedException e) {
                System.err.println("Reader was interrupted");
                break;
            }
        }
    }

    public void deActive() {
        isActive.set(false);
    }
}

class Writer extends Thread {

    private AtomicBoolean isActive = new AtomicBoolean(true);
    private Random random = new Random(System.currentTimeMillis());

    @Override
    public void run() {

        while (isActive.get()) {
            // values from 0 to 9
            int generatedValue = random.nextInt(10);
            Threads.wherehouse.add(generatedValue);
            System.out.println("Writer: just wrote " + generatedValue);

            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                System.err.println("Writer was interrupted");
                break;
            }
        }
    }

    public void deActive() {
        isActive.set(false);
    }
}


