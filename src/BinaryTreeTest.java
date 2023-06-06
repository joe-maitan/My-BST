import java.util.ArrayList;
import java.util.Random;

public class BinaryTreeTest {
    public static void main(String[] args) {
        TreeStructure BST = new BinaryTree();
        // Random generator = new Random();
        ArrayList<Integer> remove = new ArrayList<>();

        System.out.println("------Testing BST------");
        System.out.println("Hello");
        // int num = 0;
        

        BST.insert(7); // the root
        BST.insert(10);
        BST.insert(4);
        BST.insert(8);
        BST.insert(9);
        BST.insert(12);

        // for (int i = 0; i < 10; i++) {
        //     num = generator.nextInt(100) + 1;
            
        //     if (num % 2 != 0) { // if the number is not even, add it to the remove list
        //         remove.add(num);
        //     }

        //     BST.insert(num);
        // } // End for loop

        System.out.println("-----------------------");
        System.out.println("Initial Max depth: " + BST.findMaxDepth());
        System.out.println("Initial Min depth: " +BST.findMinDepth());
        System.out.println("Initial size: " + BST.size());
        System.out.println("-----------------------");

        // for (int target : remove) {
        //     BST.remove(target);
        // }

        BST.remove(10);
        BST.remove(8);

        System.out.println("-----------------------");
        System.out.println("New max depth: " + BST.findMaxDepth());
        System.out.println("New min depth: " +BST.findMinDepth());
        System.out.println("new size: " + BST.size());
        System.out.println("-----------------------");

    } // End main
    
} // End class
