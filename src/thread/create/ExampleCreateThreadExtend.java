package thread.create;

public class ExampleCreateThreadExtend {
    public static void main(String[] args) {
        // create by extend class ( ThreadExtend Class)
        Thread threadExtend = new ThreadExtend("Thread extend Thread class");
//        threadExtend.start(); // if start() thread two times, it will throw exceptions
        threadExtend.start();

        // create by implements Runnable
        ThreadImplementation instance1 = new ThreadImplementation();
        Thread threadImplement = new Thread(instance1,"Thread Implements Runnable");
        threadImplement.start();

        //create by using lambda expression
        Thread threadByLambda1 = new Thread(
                () -> {
                    for(int i = 0; i< 10 ; i++){
                        System.out.println(Thread.currentThread().getName()+ ": "+ i +" ");
                    }
                }
        );
        Thread threadByLambda2 = new Thread(
                () -> {
                    for(int i = 0; i< 10 ; i++){
                        System.out.println(Thread.currentThread().getName()+ ": "+ i +" ");
                    }
                }
        );
        threadByLambda1.start();
        threadByLambda2.start();
        try {
            threadImplement.join();
            threadExtend.join();
            threadByLambda1.join();
            threadByLambda2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Main continuing do something.....................");
    }

}
