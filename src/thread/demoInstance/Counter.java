package thread.demoInstance;

public class Counter {
    long count = 0;

    public synchronized void add(long value){
        this.count += value;
    }

    public long getCount() {
        return count;
    }
}
