package shrikant.datastructure.trees;

public class TreeHelper {
    public static void main(String[] args) {
        System.out.println("Data value 4 is found ::" + searchInTree(BinaryTree.createTree(), 4));
        System.out.println("Data value 427 is found ::" + searchInTree(BinaryTree.createTree(), 427));

        System.out.println("Max value in the tree is ::" + findMax(BinaryTree.createTree()));
    }

    public static Node searchInTree(Node root, int data){
        if (root== null)
            return null;
        if (root.getData() == data)
            return root;
        Node leftResult = searchInTree(root.getLeft(), data);
        Node rightResult = searchInTree(root.getRight(), data);
        if (leftResult != null)
            return leftResult;
        if (rightResult != null)
            return rightResult;
        return null;
    }

    public static int findMax(Node root){
        if (root == null)
            return 0;
        int leftMax = findMax(root.getLeft());
        int rightMax = findMax(root.getRight());

        return Math.max(root.getData(), Math.max(leftMax, rightMax));
    }

}
