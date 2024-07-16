package thread.joinExample;

public class JoinMethodDemo {

    public static void main(String[] args) {
        Thread thread1 = new Thread(
                () -> {
                    System.out.println("Thread 1 running........");
                }
        );
        Thread thread2 = new Thread(
                () -> {
                    System.out.println("Thread 2 running........");
                }
        );
        thread1.start();
        thread2.start();
        // use join to make thread 1, and thread 2 run successfully, when thread1 and thread 2 end up
        // then main thread will run, if don't use, main thread will run first
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Main thread running.............");

    }


}
