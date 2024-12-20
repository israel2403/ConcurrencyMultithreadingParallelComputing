package sequentialprocessing;

class WorkerThread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }
}

public class App {
    public static void main(String[] args) {
        Thread t = new Thread(new WorkerThread());
        t.setPriority(Thread.MAX_PRIORITY);
        t.start();
        System.out.println("This is in the main thread...");
    }
}
