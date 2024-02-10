package exercise1;

class ThreadSafeSingletonExample {

    private static ThreadSafeSingletonExample instance;
    private String message;

    private ThreadSafeSingletonExample() {
        // Private constructor to prevent instantiation
        message = "Thread-Safe Singleton instance.";
    }

    public static ThreadSafeSingletonExample getInstance() {
        if (instance == null) {
            synchronized (ThreadSafeSingletonExample.class) {
                if (instance == null) {
                    instance = new ThreadSafeSingletonExample();
                }
            }
        }
        return instance;
    }

    public void displayMessage() {
        System.out.println(message);
    }
}

public class ThreadSafeSingletonClient {

    public static void main(String[] args) {
        // Create multiple threads, each trying to access the Singleton instance
        int numThreads = 5;

        for (int i = 0; i < numThreads; i++) {
            Thread thread = new Thread(() -> {
                ThreadSafeSingletonExample singleton = ThreadSafeSingletonExample.getInstance();
                singleton.displayMessage();
            });
            thread.start();
        }
    }
}