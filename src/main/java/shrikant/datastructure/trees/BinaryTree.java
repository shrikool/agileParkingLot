package shrikant.datastructure.trees;

/**
 * Created by shrikant.
 */
class BinaryTree {
    //                  8
    //                 7  9
    //                3 4  10 11
    public static Node createTree() {
        Node nodeThree = new Node(3, null, null);
        Node nodeFour = new Node(4, null, null);
        Node nodeTen = new Node(10, null, null);
        Node nodeEleven = new Node(11, null, null);
        Node nodeSeven = new Node(7, nodeThree, nodeFour);
        Node nodeNine = new Node(9, nodeTen, nodeEleven);
        Node nodeEight = new Node(8, nodeSeven, nodeNine);

        return nodeEight;
    }


}