package lesson4.Assignment1;

public class Singleton {
    private static Singleton instance;
    private static volatile boolean initialized;

    public static Singleton getInstance() {
        if (!initialized) {
            synchronized (Singleton.class) {
                if (!initialized) {
                    instance = new Singleton();
                    initialized = true;
                }
            }
        }

        return instance;
    }

    private Singleton() {}
}
