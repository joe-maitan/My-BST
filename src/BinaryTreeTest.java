import java.util.ArrayList;
import java.util.Random;

public class BinaryTreeTest {
    public static void main(String[] args) {
        TreeStructure BST = new BinaryTree();
        Random rand = new Random();
        ArrayList<Integer> remove = new ArrayList<>();

        System.out.println("------Testing BST------");
        int num = 0;

        while (BST.size() != 10) {
            num = rand.nextInt(20) + 1;
        
            if (num % 2 != 0) {
                remove.add(num);
            }

            BST.insert(num);
        }
        
        System.out.println("-----------------------");
        System.out.println("Initial Max depth: " + BST.findMaxDepth());
        System.out.println("Initial Min depth: " +BST.findMinDepth());
        System.out.println("Initial size: " + BST.size());
        System.out.println("-----------------------");


        System.out.println("-----------------------");
        System.out.println("New max depth: " + BST.findMaxDepth());
        System.out.println("New min depth: " +BST.findMinDepth());
        System.out.println("new size: " + BST.size());
        System.out.println("-----------------------");

    } // End main
    
} // End class
