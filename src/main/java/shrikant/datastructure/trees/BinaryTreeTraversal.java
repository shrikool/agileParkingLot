package shrikant.datastructure.trees;

import java.util.Stack;

/**
 * Created by shrikant.
 */
public class BinaryTreeTraversal {

    public static void main(String[] args) {
        Node root = BinaryTree.createTree();
//        nonRecursivePreOrderTravesal(root);
//        nonRecursiveInOrderTraversal(root);
        nonRecursivePostOrderTraversal(root);
    }

    public static void nonRecursivePreOrderTravesal(Node root) {
        // root left right
        Stack<Node> unProcessedRoots = new Stack<Node>();
        Node traversalNode = root;
        while (traversalNode != null || !unProcessedRoots.isEmpty()) {
            if (traversalNode != null) {
                System.out.println(traversalNode.getData());
                if (traversalNode.getRight() != null)
                    unProcessedRoots.push(traversalNode.getRight());
                traversalNode = traversalNode.getLeft();
            } else {
                traversalNode = unProcessedRoots.pop();
            }
        }
    }

    public static void nonRecursiveInOrderTraversal(Node root) {
        // left root right
        //                  8
        //                 7  9
        //                3 4  10 11

        Stack<Node> unprocessedNodes = new Stack<Node>();
        Node traveller = root;

        // there is only one way to do this kind of traversing
        // i.e. in order traversing

        while (true) {
            // go to the extreme left and then push each and every node
            // in the stack
            while (traveller != null) {
                unprocessedNodes.push(traveller);
                traveller = traveller.getLeft();
            }
            if (unprocessedNodes.isEmpty())
                break;
            traveller = unprocessedNodes.pop();
            System.out.println(traveller.getData());
            traveller = traveller.getRight();
        }

    }

    public static void nonRecursivePostOrderTraversal(Node root) {
        // left right root
        //                  8
        //                 7  9
        //                3 4  10 11
        //  3 4 7 10 11 9 8
        Stack<Node> unprocessedNodes = new Stack<Node>();
        Node traveller = root;
        boolean cameFromRight = false;
        while (true) {
            while (traveller != null) {
                unprocessedNodes.push(traveller);
                traveller = traveller.getLeft();
            }
            if (unprocessedNodes.isEmpty()) {
                break;
            }
            traveller = unprocessedNodes.peek();
            if (traveller.getRight() != null && cameFromRight == false) {
                traveller = traveller.getRight();
            } else {
                traveller = unprocessedNodes.pop();
                System.out.println(traveller.getData());
                cameFromRight = !unprocessedNodes.isEmpty() && (traveller == unprocessedNodes.peek().getRight());
                // first condition is to stop the exception when we are on the root node of the tree
                // second condition tries to check the node on the stack , but when we are on the root node
                // we won't be having any node on the stack and the second condition will result in the exception
                traveller = null;
            }
        }

    }
}



