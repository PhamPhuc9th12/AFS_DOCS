package thread.stop;

public class ExampleThread {

    public static void main(String[] args)  {
        StopThreadImpl stopThread = new StopThreadImpl();
        Thread threadDemo = new Thread(stopThread);
        threadDemo.start();
        try {
            // Main thread will stop within 5 second and threadDemo will run when Main thread stopping
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // stop threadDemo through flag doStop in stopThread Object
        stopThread.doStop();
        try {
            threadDemo.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Main thread run............");
    }
}
