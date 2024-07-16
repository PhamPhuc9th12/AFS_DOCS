package thread.synchronizedexample;

public class DemoRaceContidtionSynchronized {
    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public void incrementBlock(){
        synchronized (this){
            count++;
        }
    }
    // method decrement use with synchronized block
    public synchronized void decrement() {
        count--;
    }

    // method decrementBlock use synchronized block
    public void decrementBlock(){
        synchronized (this){
            count--;
        }
    }

    public int getCount() {
        return count;
    }

    public static void main(String[] args) {
        DemoRaceContidtionSynchronized counter = new DemoRaceContidtionSynchronized();

        Runnable incrementTask = () -> {
            for (int i = 0; i < 1000; i++) {
                counter.incrementBlock();
            }
        };

        Runnable decrementTask = () -> {
            for (int i = 0; i < 1000; i++) {
                counter.decrementBlock();
            }
        };

        Thread threadDemo1 = new Thread(incrementTask);
        Thread threadDemo2 = new Thread(decrementTask);

        threadDemo1.start();
        threadDemo2.start();

        try {
            threadDemo1.join();
            threadDemo2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final count: " + counter.getCount());
    }
}
