package Question.overridestartmethod;

public class ChildClass extends Thread{

//    @Override
//    public void start(){
//        System.out.println("Override start method");
//    }

    // We can override start method, but if u don't use super.start(), it will run as normal method, when you
    // use super.start(), it will create a new thread and add more activity
    @Override
    public void start(){
        super.start();
        System.out.println("Override start method");
    }


    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName());
        System.out.println("Method running...........");
    }
}
