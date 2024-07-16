package thread.racecondition.checkthenact;

class BankAccount {
    private int balance;

    public BankAccount(int balance) {
        this.balance = balance;
    }

    public void withdraw(int amount, String nameThread) {
        System.out.println("Current balance: " + balance);
        synchronized (this) {
            if (balance >= amount) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                balance -= amount;
                System.out.println(nameThread + "rut so tien:" + amount);
            } else {
                System.out.println("Balance doesn't enough");
            }
        }
    }

    public int getBalance() {
        return balance;
    }
}
