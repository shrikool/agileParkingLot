//package shrikant.concurrentcollections;
//
//import java.util.Queue;
//import java.util.concurrent.ArrayBlockingQueue;
//import java.util.concurrent.BlockingQueue;
//import java.util.concurrent.DelayQueue;
//
//public class BlockingQueueDemo {
//
//    // Blocking methods
//    // Operations       Throw Exceptions    Special Values      Blocks        Block With Timeout
//    // Insert           add(E)              offer(o)            put(E)          offer(E, timeout, timeunit)
//    // Delete           remove(E)           poll(o)             take(E)         poll(timeout, timeunit)
//    // Examine          element(E)          peek()
//    public static void main(String[] args) {
////        Queue queue = new ArrayBlockingQueue(2);
//        Queue queue = new DelayQueue();
//        Producer producer = new Producer(queue);
//        Thread producerThread = new Thread(producer);
//        Consumer consumer = new Consumer(queue);
//        Thread consumerThread = new Thread(consumer);
//        System.out.println("Starting the producer thread");
//        producerThread.start();
//        System.out.println("Starting the consumer thread");
//        consumerThread.start();
//
//        try {
//            Thread.sleep(80000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public boolean transferMoneyWithTryLock(Account fromAccount,
//                                            Account toAccount, float amount) throws InsufficientAmountException, InterruptedException {
//
//// we are defining a stopTime
//        long stopTime = System.nanoTime() + 5000;
//        while (true) {
//            if (fromAccount.lock.tryLock()) {
//                try {
//                    if (toAccount.lock.tryLock()) {
//                        try {
//                            if (amount > fromAccount.getCurrentAmount()) {
//                                throw new InsufficientAmountException(
//                                        "Insufficient Balance");
//                            } else {
//                                fromAccount.debit(amount);
//                                toAccount.credit(amount);
//                            }
//
//                        } finally {
//                            toAccount.lock.unlock();
//                        }
//                    }
//
//                } finally {
//                    fromAccount.lock.unlock();
//                }
//            }
//            if (System.nanoTime() < stopTime)
//                return false;
//
//            Thread.sleep(100);
//        }//while
//    }
//}
//
//
//class Producer implements Runnable {
//    private Queue queue;
//
//    public Producer(Queue queue) {
//        this.queue = queue;
//    }
//
//
//    @Override
//    public void run() {
//        for (int i = 0; i <= 10; i++) {
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("Producer produced " + i);
//            queue.offer(i);
//        }
//    }
//}
//
//class Consumer implements Runnable {
//    public Queue queue;
//
//    public Consumer(Queue queue) {
//        this.queue = queue;
//    }
//
//
//    @Override
//    public void run() {
//        while (true) {
//            if (!queue.isEmpty()) {
//                System.out.println("Consumer consumed " + queue.poll());
//            }
//        }
//    }
//}