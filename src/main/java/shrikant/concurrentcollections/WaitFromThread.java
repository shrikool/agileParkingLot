package shrikant.concurrentcollections;

/**
 * Created by shrikant.
 */
public class WaitFromThread {
    public static void main(String[] args) {
        String lock = "hello";
        Runnable runnable = new MyThread(lock);
        Thread newThread = new Thread(runnable);
        newThread.start();

        try {
            System.out.println("thread.sleep called");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("hello");
        synchronized (lock) {
            lock.notify();
        }
    }
}

class MyThread implements Runnable {
    private String lock;

    MyThread(String lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            System.out.println("In my thread.....");
            try {
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("in my thread post lock.wait");
        }
    }
}

