package shrikant.datastructure.linkedlist;

public class JoinedLinkedList {
    static Node fourth;
    static Node third;

    public static void main(String[] args) {
        Node headFirst = prepareFirstLinkedList();
        printLinkedList(headFirst);
        Node headSecond = prepareSecondLinkedList();
        printLinkedList(headSecond);

        Node concurrentNode = findConcurrentNode(headFirst, headSecond);
        System.out.println(concurrentNode.data);
    }

    private static Node findConcurrentNode(Node headFirst, Node headSecond) {
        if (headFirst == null || headSecond == null){
            return new Node("Invalid Node :: NULL", null);
        }

        int lenOne = countNodes(headFirst);
        int lenTwo = countNodes(headSecond);
        int diff = Math.abs(lenOne - lenTwo);
        Node startNode = getNodeAfterN(diff, lenOne >= lenTwo ? headFirst : headSecond);
        Node tempNode = lenOne <= lenTwo ? headFirst : headSecond;

        while(startNode != null && tempNode != null && startNode != tempNode){
            startNode = startNode.next;
            tempNode = tempNode.next;
        }

        return startNode;
    }

    private static Node getNodeAfterN(int diff, Node node) {
        while(node != null && diff > 0){
            node = node.next;
            diff--;
        }
        return node;
    }

    private static int countNodes(Node tempNode) {
        int lenLinkedList = 0;
        while(tempNode != null){
            lenLinkedList++;
            tempNode = tempNode.next;
        }
        return lenLinkedList;
    }

    private static Node prepareSecondLinkedList() {
        Node seven = new Node("7", third);
        Node six = new Node("6", seven);
        Node five = new Node("5", six);
        return five;
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

    public static Node prepareFirstLinkedList(){
        fourth = new Node("4", null);
        third = new Node("3", fourth);
        Node second = new Node("2", third);
        Node first = new Node("1", second);
        return first;
    }




}
