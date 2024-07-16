package thread.deadlockExample;

import java.util.Objects;

public class DeadLockTest {
    public static void main(String[] args) throws InterruptedException {
        Object lockPhu = new Object();
        Object lockPhuc = new Object();
        final String lan = "Lan";
        // t1 tries to lock resource1 then resource2
        Thread t1 = new Thread() {
            public void run() {
                synchronized (lockPhu) {
                    System.out.println("Phú đến nhà, rủ Phúc đi chơi");
                    System.out.println("waiting...........");
                    try { Thread.sleep(1000);} catch (Exception e) {}

                    synchronized (lockPhuc) {
                        System.out.println("đi chơi");
                    }
                }
            }
        };

        // t2 tries to lock resource2 then resource1
        Thread t2 = new Thread() {
            public void run() {
                synchronized (lockPhuc) {
                    System.out.println("Phúc đến nhà Phú, rủ Phú đi học");
                    System.out.println("waiting.............");
                    try { Thread.sleep(1000);} catch (Exception e) {}

                    synchronized (lockPhu) {
                        System.out.println("đi học");
                    }
                }
            }
        };


        t1.start();
        t2.start();
    }
}
