package lesson4;

public class Assignment2 {
    public static void main(String[] args) {
        Integer res1 = 9;
        Integer res2 = 20;

        Thread t1 = new Thread(() -> {
            synchronized (res1) {
                System.out.println("Locked res1: " + res1);

                try {
                    Thread.sleep(100);
                } catch (InterruptedException ignored) {}

                synchronized (res2) {
                    System.out.println("Locked res2: " + res2);
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (res2) {
                System.out.println("Locked res2: " + res2);

                try {
                    Thread.sleep(100);
                } catch (InterruptedException ignored) {}

                synchronized (res1) {
                    System.out.println("Locked res1: " + res1);
                }
            }
        });

        t1.start();
        t2.start();
    }
}
