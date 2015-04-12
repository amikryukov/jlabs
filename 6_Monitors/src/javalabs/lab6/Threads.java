package javalabs.lab6;

import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class Threads {
    public final static CopyOnWriteArrayList<Integer> wherehouse = new CopyOnWriteArrayList<>();

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

        synchronized (Threads.wherehouse) {
            while (isActive.get()) {

                try {
                    Thread.sleep(100L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (!Threads.wherehouse.isEmpty()) {
                    for(Integer i : Threads.wherehouse) {
                        System.out.println("Reader: " + i);
                    }
                    Threads.wherehouse.clear();
                    Threads.wherehouse.notifyAll();
                } else {
                    try {
                        Threads.wherehouse.wait();
                    } catch (InterruptedException e) {
                        break;
                    }
                }
            }
            Threads.wherehouse.notifyAll();
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

        synchronized (Threads.wherehouse) {
            while (isActive.get()) {
                // values from 0 to 9
                int generatedValue = random.nextInt(10);
                Threads.wherehouse.add(generatedValue);
                Threads.wherehouse.notifyAll();
                try {
                    Threads.wherehouse.wait();
                } catch (InterruptedException e) {
                    break;
                }
            }
            Threads.wherehouse.notifyAll();
        }
    }

    public void deActive() {
        isActive.set(false);
    }
}


