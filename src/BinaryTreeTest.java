import java.util.ArrayList;
import java.util.Random;
import java.util.stream.StreamSupport;

public class BinaryTreeTest {
    public static void main(String[] args) {
        TreeStructure BST = new BinaryTree();
        TreeNode root = root;
      
        System.out.println("------Testing BST------");
        BST.insert(50);
        BST.insert(20);
        BST.insert(10);
        BST.insert(30);
        BST.insert(60);
        BST.insert(80);
        BST.insert(55);

        
        System.out.println("-----------------------");
        System.out.println("Initial Max depth: " + BST.findMaxDepth());
        System.out.println("Initial Min depth: " +BST.findMinDepth());
        System.out.println("Initial size: " + BST.size());
        System.out.println(BST.getRoot());
        System.out.println("-----------------------");

        System.out.println("Inorder traversal: " + BST.inorder(BST.getRoot()));


        System.out.println("-----------------------");
        System.out.println("New max depth: " + BST.findMaxDepth());
        System.out.println("New min depth: " +BST.findMinDepth());
        System.out.println("new size: " + BST.size());
        System.out.println("-----------------------");

    } // End main
    
} // End class
