public interface TreeStructure {
    
    /* five base methods needed to implement */
    public void insert(Integer num);
    public boolean remove(Integer num);
    public long get(Integer num);
    public Integer findMaxDepth();
    public Integer findMinDepth();
    
    
    public Integer size();
    
    /* methods for the three different traversals of a BST.
    * and a .getRoot() method to help with them.
    */
    public void inorder(TreeNode root);
    public void post_order(TreeNode root);
    public void pre_order(TreeNode root);
    public TreeNode getRoot();

} // End TreeStructure interface
