public class BinaryTreeTest {
    public static void main(String[] args) {
        TreeStructure BST = new BinaryTree();
      
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
        System.out.println("-----------------------");

        System.out.println("Inorder Traversal:");
        BST.inorder(BST.getRoot());
        System.out.println();
        System.out.println("Preorder Traversal:");
        BST.pre_order(BST.getRoot());
        System.out.println();
        System.out.println("Postorder Traversal:");
        BST.post_order(BST.getRoot());
        System.out.println();


        System.out.println("-----------------------");
        System.out.println("New max depth: " + BST.findMaxDepth());
        System.out.println("New min depth: " +BST.findMinDepth());
        System.out.println("new size: " + BST.size());
        System.out.println("-----------------------");

    } // End main
    
} // End class
