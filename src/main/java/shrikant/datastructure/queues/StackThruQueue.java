package shrikant.datastructure.queues;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by shrik on 4/15/2017.
 */
public class StackThruQueue {

    public static Queue<Integer> getQueue(){
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        return queue;
    }

    public static void print(Queue<Integer> queue) {
        if (queue.isEmpty() || queue == null){
            return;
        }
        while(!queue.isEmpty()){
            System.out.println(queue.poll());
        }
    }

    public static void main(String[] args) {

    }
}

class StackByQueue{

}
