package thread.stop;

public class StopThreadImpl implements Runnable{
    private boolean stop = false;

    public synchronized void doStop(){
         stop = true;
    }

    public synchronized boolean keepRunning(){
        return !stop;
    }
    public void run() {
        while (keepRunning()){
            System.out.println("Thread running...........");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
//private  boolean running = true;
//
//    public void run() {
//        while (keepRunning()) {
//            System.out.println("Thread đang chạy...");
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                Thread.currentThread().interrupt(); // Khôi phục trạng thái interrupt
//                System.out.println("Thread bị gián đoạn");
//            }
//        }
//        System.out.println("Thread đã dừng.");
//    }
//
//    public synchronized void stop() {
//        running = false;
//    }
//    public synchronized boolean keepRunning() {
//        return running = true;
//    }
}
