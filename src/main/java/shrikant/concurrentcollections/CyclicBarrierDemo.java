package shrikant.concurrentcollections;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    public static void main(String[] args){
        CyclicBarrier cyclicBarrierOne = new CyclicBarrier(2, new Runnable() {
            @Override
            public void run() {
                System.out.println("This is cyclic barrier one");
            }
        });

        CyclicBarrier cyclicBarrierTwo = new CyclicBarrier(2, new Runnable() {
            @Override
            public void run() {
                System.out.println("This is cyclic barrier two");
            }
        });

        Runnable firstThread  = new Runnable() {
            @Override
            public void run() {
                new SomeTask(cyclicBarrierOne, cyclicBarrierTwo).doSomeWork();;
            }
        };


        Runnable secondThread = new Runnable() {
            @Override
            public void run() {
                new SomeTask(cyclicBarrierOne, cyclicBarrierTwo).doSomeWork();
            }
        };

        Thread tOne = new Thread(firstThread);
        Thread tTwo = new Thread(secondThread);

        tOne.start();
        tTwo.start();

    }
}

class SomeTask{
    CyclicBarrier cyclicBarrierOne;
    CyclicBarrier cyclicBarrierTwo;

    public SomeTask(CyclicBarrier cyclicBarrierOne, CyclicBarrier cyclicBarrierTwo){
        this.cyclicBarrierOne = cyclicBarrierOne;
        this.cyclicBarrierTwo = cyclicBarrierTwo;
    }

    public void doSomeWork(){
        System.out.println("Some work has been started." + Thread.currentThread().getName());

        System.out.println("Waiting for the Cyclic barrier one for thread " + Thread.currentThread().getName());
        try {
            cyclicBarrierOne.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Executing the code after the cyclic barrier one");

        System.out.println("Waiting for the Cyclic barrier two for thread " + Thread.currentThread().getName());

        try {
            cyclicBarrierTwo.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Job finished");

    }
}
