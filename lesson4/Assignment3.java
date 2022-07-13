package lesson4;

import java.util.Vector;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class Assignment3 {
    public static void main(String[] args) {
        Vector<Integer> buffer = new Vector<>();
        buffer.ensureCapacity(100);
        AtomicInteger count = new AtomicInteger();

        Thread producer = new Thread(() -> {
            while (true) {
                int value = ThreadLocalRandom.current().nextInt();

                synchronized (buffer) {
                    int cur = count.get();
                    if (cur < 100) {
                        buffer.add(value);
                        count.set(cur + 1);
                    }
                }
            }
        });

        Thread consumer = new Thread(() -> {
            while (true) {
                int next;
                synchronized (buffer) {
                    int cur = count.get();
                    if (cur <= 0) continue;

                    next = buffer.remove(buffer.size() - 1);
                    count.set(cur - 1);
                }

                System.out.println("Consumed '" + next + "' from producer!");
            }
        });

        producer.start();
        consumer.start();
    }
}
