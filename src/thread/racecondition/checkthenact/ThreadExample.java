package thread.racecondition.checkthenact;

import thread.racecondition.checkthenact.BankAccount;

public class ThreadExample {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);

        Thread t1 = new Thread(() -> account.withdraw(900,"Thread1"));
        Thread t2 = new Thread(() -> account.withdraw(800,"Thread2"));
        Thread threadLambda = new Thread(
                () -> {
                    System.out.println("TestLambda to create thread");
                }
        );
        threadLambda.start();
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final balance: " + account.getBalance());
    }
}