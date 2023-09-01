public class BinaryTree implements TreeStructure {

    private TreeNode root = null;
    private int size = 0;

    public TreeNode search(TreeNode root, int target) {
        TreeNode current = root;

        while (current != null && current.data != target) {
            if (target < current.data) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        return current;
    } // End search()

    public TreeNode searchSuccessor(TreeNode removeNode) {
        TreeNode successor = null;
        TreeNode current = removeNode;
        boolean run = true;
        
        current = current.right;

        while (run) {
            if (current.left == null) {
                successor = current;
                return successor;
            } else {
                current = current.left;
            }
        } // End while loop

        return null;
    } // End searchSuccessor

    public void insert (Integer target) {
        TreeNode current = root;
        TreeNode newNode = new TreeNode(target);

        if (root == null) {
            root = newNode;
            root.timeStamp = System.nanoTime();
            size++;
            return;
        }

        while (current != null) {
            if (newNode.data == current.data) { // Handling duplicates
                return;
            } 

            if (newNode.data < current.data && current.left == null) { // new node is inserted on the left
                current.left = newNode;
                newNode.parent = current;
                newNode.timeStamp = System.nanoTime();
                size++;
                return;
            } else if (newNode.data > current.data && current.right == null) { // new node is inserted on the right
                current.right = newNode;
                newNode.parent = current;
                newNode.timeStamp = System.nanoTime();
                size++;
                return;
            } else if (newNode.data < current.data && current.left != null) {
                current = current.left;
            } else if (newNode.data > current.data && current.right != null) {
                current = current.right;
            }
        } // End while loop
    } // End insert()

    public boolean remove(Integer target) {
        TreeNode current = root;
        TreeNode removeNode = search(current, target);

        // Node we are trying to remove was not found 
        if (removeNode == null) {
            return false;
        } 

        // Case #1 - remove a node with no children
        if (removeNode.left == null && removeNode.right == null) {
            if (removeNode == root) {
                root = null;
                size--;
                return true;
            }

            if (removeNode.data < removeNode.parent.data) { // Go left
                removeNode.parent.left = null;
                removeNode.parent = null;
                removeNode = null;
                size--;
                return true;
            } else { // go right
                removeNode.parent.right = null;
                removeNode.parent = null;
                removeNode = null;
                size--;
                return true;
            }
        } // remove a node with no children

        // Case #2 - remove a node with one child
        if (removeNode.left == null || removeNode.right == null) {
            // The node we are removing is the root, and it has one child
            if (removeNode == root) {
                if (removeNode.left != null && removeNode.right == null) {
                    root = removeNode.left;
                    root.left = null;
                    removeNode.left.parent = null;
                    size--;
                    return true;
                } else if (removeNode.left != null && removeNode.right == null) {
                    root = removeNode.right;
                    root.right = null;
                    removeNode.right.parent = null;
                    size--;
                    return true;
                }
            }

            if (removeNode.data < removeNode.parent.data) { // go left
                if (removeNode.left != null && removeNode.right == null) { // We are removing a node with a left child
                    removeNode.parent.left = removeNode.left;
                    removeNode.left.parent = removeNode.parent;
                    removeNode.parent = null;
                    removeNode.left = null;
                    removeNode = null;
                    size--;
                    return true;
                } else { // We are removing a node with a right child
                    removeNode.parent.left = removeNode.right;
                    removeNode.right.parent = removeNode.parent;
                    removeNode.parent = null;
                    removeNode.right = null;
                    removeNode = null;
                    size--;
                    return true;
                }
            } else { // go right
                if (removeNode.left != null && removeNode.right == null) { // We are removing a node with a left child
                    removeNode.parent.right = removeNode.left;
                    removeNode.left.parent = removeNode.parent;
                    removeNode.parent = null;
                    removeNode.left = null;
                    removeNode = null;
                    size--;
                    return true;
                } else { // We are removing a node with a right child
                    removeNode.parent.right = removeNode.right;
                    removeNode.right.parent = removeNode.parent;
                    removeNode.parent = null;
                    removeNode.right = null;
                    removeNode = null;
                    size--;
                    return true;
                }
            }
        } // End if-else remove a node with one child

        // Case #3 - remove a node with two children
        if (removeNode.left != null && removeNode.right != null) {
            // Search for the successor for the replacement node. The smallest value in the tree's right subtree
            TreeNode successor = searchSuccessor(removeNode);
            
            if (removeNode == root) {
                if (removeNode.right == successor) {
                    root = successor;
                    successor.parent = null;
                    successor.left = removeNode.left;
                    removeNode.left.parent = successor;
                    successor.right = null;
                    removeNode = null;
                    size--;
                    return true;
                } else {
                    successor.parent.left = null;
                    root = successor;
                    successor.parent = null;
                    successor.right = removeNode.right;
                    removeNode.right.parent = successor;
                    successor.left = removeNode.left;
                    removeNode.left.parent = successor;
                    removeNode = null;
                    size--;
                    return true;
                }
            } // End if the remove node with two children is the root

            // Case if the successor is the immediate right child of the node we want to remove
            if (removeNode.right == successor) {
                if (removeNode.data < removeNode.parent.data) { // Removing a node on the left
                    removeNode.parent.left = successor;
                    successor.parent = removeNode.parent;
                    successor.left = removeNode.left;
                    removeNode.left.parent = successor;
                    successor.right = null;
                    removeNode = null;
                    size--;
                    return true;
                } else { // Removing a node on the right
                    removeNode.parent.right = successor;
                    successor.parent = removeNode.parent;
                    successor.left = removeNode.left;
                    removeNode.left.parent = successor;
                    successor.right = null;
                    removeNode = null;
                    size--;
                    return true;
                }
            } // End case if the successor is the immediate right child 

            if (successor.right != null) { // Successor has a right child
                if (removeNode.data < removeNode.parent.data) { // go left
                    successor.parent.left = successor.right;
                    successor.right.parent = successor.parent;
                    removeNode.parent.left = successor;
                    successor.parent = removeNode.parent;
                    successor.left = removeNode.left;
                    removeNode.left.parent = successor;
                    successor.right = removeNode.right;
                    removeNode.right.parent = successor;
                    removeNode = null;
                    size--;
                    return true;
                } else { // Go right
                    successor.parent.left = successor.right;
                    successor.right.parent = successor.parent;
                    removeNode.parent.right = successor;
                    successor.parent = removeNode.parent;
                    successor.left = removeNode.left;
                    removeNode.left.parent = successor;
                    successor.right = removeNode.right;
                    removeNode.right.parent = successor;
                    removeNode = null;
                    size--;
                    return true;
                }
            } // End the replacement case for the successor nodes

            if (removeNode.data < removeNode.parent.data) { // removing a node on the left
                    successor.parent.left = null;
                    removeNode.parent.left = successor;
                    successor.parent = removeNode.parent;
                    successor.left = removeNode.left;
                    removeNode.left.parent = successor;
                    successor.right = removeNode.right;
                    removeNode.right.parent = successor;
                    removeNode = null;
                    size--;
                    return true;
                } else { // removing a node on the right
                    successor.parent.left = null;
                    removeNode.parent.right = successor;
                    successor.parent = removeNode.parent;
                    successor.left = removeNode.left;
                    removeNode.left.parent = successor;
                    successor.right = removeNode.right;
                    removeNode.right.parent = successor;
                    removeNode = null;
                    size--;
                    return true;
                }    
        } // End case for two childrewn

       return false; 
    } // End remove()

    public long get(Integer target) {
        TreeNode find = search(root, target);

        if (find == null) {
            return -1;
        } else {
            return find.timeStamp;
        } // End if-else
    } // End get()

    public Integer maxDepth(TreeNode current) {
        if (current == null) {
            return 0;
        } 
        
        int left = maxDepth(current.left);
        int right = maxDepth(current.right);
        return Math.max(left, right) + 1;

        
    } // End maxDepth

    public Integer minDepth(TreeNode current) {
        if (current == null) {
            return 0;
        }

        if (current.left == null && current.right == null) {
            return 1;
        }

        if (current.left == null) {
            return minDepth(current.right) + 1;
        }

        if (current.right == null) {
            return minDepth(current.left) + 1;
        }

        return Math.min(minDepth(current.left), minDepth(current.right)) + 1;
    } // End minDepth

    public Integer findMaxDepth() {
        return maxDepth(root);
    } // End findMaxDepth()

    public Integer findMinDepth() {
        return minDepth(root);
    } // End findMinDepth()

    public Integer size() {
        return this.size;
    } // End size

    public void inorder(TreeNode root) {
        TreeNode current = root;
        
        if (current == null) {
            return;
        }

        inorder(current.left);
        System.out.print(current.data + " ");
        inorder(current.right);
    } // End inorder

    public void post_order(TreeNode root) {
        TreeNode current = root;
        
        if (current == null) {
            return;
        }

        post_order(current.left);
        post_order(current.right);
        System.out.print(current.data + " ");
    } // End post_order

    public void pre_order(TreeNode root) {
        TreeNode current = root;
        
        if (current == null) {
            return;
        }
        
        System.out.print(current.data + " ");
        pre_order(current.left);
        pre_order(current.right);
    } // End pre_order

    public TreeNode getRoot() {
        if (this.root == null) {
            throw new UnknownError("Root is null");
        } else {
            return this.root;
        }
    } // End getRoot

  
} // End BinaryTree class
