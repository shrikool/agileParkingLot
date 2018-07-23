package shrikant.concurrentcollections;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class TwoThreadsToPrintNumberInASequence {
    public static void main(String[] args) {
        PrintingActivity printingActivity = new PrintingActivity();
        Thread threadOne = new Thread(new Task(printingActivity, true));
        Thread threadTwo = new Thread(new Task(printingActivity, false));
        threadOne.start();
        threadTwo.start();
    }
}


class PrintingActivity {
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void printEvenNumber(int number) {
        try {
            lock.lock();

            if (number % 2 == 0) {
                System.out.println(number + " || Current Thread" + Thread.currentThread());
                condition.signalAll();
            } else {
                condition.await();
            }

        } catch (InterruptedException e) {
        } finally {
            lock.unlock();
        }
    }

    public void printOddNumber(int number) {
        try {
            lock.lock();
            if (number % 2 == 1) {
                System.out.println(number + " || Current Thread" + Thread.currentThread());
                condition.signalAll();
            } else {
                condition.await();
            }
        } catch (InterruptedException e) {
        } finally {
            lock.unlock();
        }
    }
}

class Task implements Runnable {
    private PrintingActivity printingActivity;
    private boolean isEven;

    public Task(PrintingActivity printingActivity, boolean isEven) {
        this.printingActivity = printingActivity;
        this.isEven = isEven;
    }

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (isEven) {
                printingActivity.printEvenNumber(i);
            } else {
                printingActivity.printOddNumber(i);
            }
        }
    }
}
