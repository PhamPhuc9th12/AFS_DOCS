package thread.demoInstance;

public class Example {

    public static void main(String[] args) throws InterruptedException {
        // khi 2 thread truy cap vao 2 object khac nhau
        Counter counter = new Counter();
        Counter counter1 = new Counter();
        Thread threadA = new CounterThread(counter);
        Thread threadB = new CounterThread(counter1);

        threadA.start();
        threadA.join();
        threadB.start();
        // khi 2 thread truy cap vao cung 1 object
//        Counter counter = new Counter();
//        Thread threadA = new CounterThread(counter);
//        Thread threadB = new CounterThread(counter);

//        threadA.start();
//        threadA.join();
//        threadB.start();
    }
}
