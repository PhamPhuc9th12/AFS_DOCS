package thread.create;

public class ThreadExtend extends Thread{

    public void run(){
        System.out.println(Thread.currentThread().getName());
        System.out.println("test demo create thread by extend Thread class!!!");
        System.out.println("================================================");
    }

    public ThreadExtend(String name) {
        super(name);
    }
}
