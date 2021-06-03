package task1;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Executor writer = new Executor("writer");
        Executor reader = new Executor("reader");

        for (int i = 0; i < 10; i++) {

            Thread t1 = new Thread(writer);
            Thread t2 = new Thread(reader);
            t1.start();
            t1.join();
            t2.start();
            t2.join();
        }
    }
}
