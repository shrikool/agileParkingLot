package shrikant.datastructure.trees;

/**
 * Created by shrikant.
 */
public class DiameterOfBinaryTree {

    public static void main(String[] args) {
        int diameter = Diameter.findDiameter(BinaryTree.createTree());
        System.out.println("Diameter of the tree is : " + diameter);
        System.out.println("Value of some variable is : " + Diameter.someVariable);
    }

}

class Diameter{
    public static int someVariable = 0;
    public static int findDiameter(Node root){
        if (root == null)
            return 0;
        int left = findDiameter(root.getLeft());
        int right = findDiameter(root.getRight());
        if (left + right > someVariable)
            someVariable = left + right;
        return Math.max(left, right) + 1;
    }
}