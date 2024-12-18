package sequentialprocessing;

class Runner1 extends Thread {
    public void execute() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Runner1: " + i);
        }
    }

    @Override
    public void run() {
        execute();
    }
}

class Runner2 extends Thread {
    public void execute() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Runner2: " + i);
        }
    }

    @Override
    public void run() {
        execute();
    }
}

public class App {
    public static void main(String[] args) {
        Thread t1 = new Runner1();
        Thread t2 = new Runner2();
        t1.start();
        t2.start();
        // we can wait for the thread to finish: join()
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Finished the tasks");
    }
}
