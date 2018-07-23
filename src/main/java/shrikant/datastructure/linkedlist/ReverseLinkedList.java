package shrikant.datastructure.linkedlist;

/**
 * Created by shrik on 4/10/2017.
 */
class Node{
    public String data;
    public Node next;

    public Node(String data, Node nextNode) {
        this.data = data;
        this.next = nextNode;
    }
}

public class ReverseLinkedList {
    static Node fourth;

    public static void main(String[] args) {
        Node head = prepareNode();
        printLinkedList(head);
        Node node = recursiveReverse(head);
        printLinkedList(fourth);
    }

    public static void printLinkedList(Node head){
        System.out.println("--------");
        while(head!= null){
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println("");
        System.out.println("--------");
    }

    public static Node prepareNode(){
        fourth = new Node("4", null);
        Node third = new Node("3", fourth);
        Node second = new Node("2", third);
        Node first = new Node("1", second);
        return first;
    }

    private static Node recursiveReverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node tempNode = head.next;
        head.next = null;
        Node someNode = recursiveReverse(tempNode);
        someNode.next = head;
        return head;
    }


}
