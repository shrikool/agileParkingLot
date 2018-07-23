package shrikant.datastructure.queues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseQueue {
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
        print(reverseQueueByStack(getQueue()));
    }

    public static Queue reverseQueueByStack(Queue<Integer> queue){
        if (queue == null || queue.isEmpty()){
            return queue;
        }

        Stack<Integer> stack = new Stack<Integer>();
        while(!queue.isEmpty()){
            stack.push(queue.poll());
        }
        while(!stack.isEmpty()){
            queue.offer(stack.pop());
        }
        return queue;
    }
}
