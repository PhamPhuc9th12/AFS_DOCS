package thread.demoInstance;

public class CounterThread extends Thread{

    public Counter counter = null;
    public CounterThread(Counter counter){
        this.counter = counter;
    }

    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName()+":");
        for(int i = 0; i < 10; i ++){
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.print(i+ " + ");
            counter.add(i);
        }
        System.out.println("Final result is :" + counter.getCount());
    }
}
