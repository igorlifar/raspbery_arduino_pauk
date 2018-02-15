package pack;

import java.util.ArrayList;

/**
 * @author lifar
 */
public class TestMain {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        ArrayList<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 16; i++) {
            int finalI = i;
            Thread thread = new Thread(() -> {
                try {
                    Thread.sleep(1000 * finalI);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(String.format("Thread #%d", finalI));
            });
            thread.start();
            threads.add(thread);
        }

        threads.forEach(x -> {
            try {
                x.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
