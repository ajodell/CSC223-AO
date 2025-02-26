package csc223.ad;

public class BinaryTree implements Tree {

    TreeNode root;

    public BinaryTree() {
        this.root = null;
    }
    
    // Gets the levelorder traversal of the tree
    public String levelorder() {
        
        String contents = "";
        if (this.root == null) {
            return contents;
        }

        LinkedListQueue queue = new LinkedListQueue();
        queue.enqueue(this.root);

        while (queue.isEmpty() == false) {
            TreeNode current = queue.dequeue();
            contents = contents + current.data;
            if (current.left != null) {
                queue.enqueue(current.left);
            }
            if (current.right != null) {
                queue.enqueue(current.right);
            }
        }
        return contents;
    }

    // Get the preorder traversal of the tree: root -> left -> right
    public String preorder() {
        return preorder(this.root);
    }

    // Helper function for public function preorder
    private String preorder(TreeNode current) {
        if (current == null) {
            return "";
        }
        return current.data + preorder(current.left) + preorder(current.right);
    }

    // Get the inorder traversal of the tree: left -> root -> right
    public String inorder() {
        return inorder(this.root);
    }

    // Helper function for public function inorder
    private String inorder(TreeNode current) {
        if (current == null) {
            return "";
        }
        return inorder(current.left) + current.data + inorder(current.right);
    }

    // Get the postorder traversal of the tree: left -> right -> root
    public String postorder() {
        return postorder(this.root);
    }

    // Helper function for public function postorder
    private String postorder(TreeNode current) {
        if (current == null) {
            return "";
        }
        return postorder(current.left) +  postorder(current.right) + current.data;
    }

    // Insert an item into the tree using level order traversal to 
    // find the correct position. If the tree is empty, inserts at root
    public void insert(char item) {
        
        // Makes a root node if there is none
        if (this.root == null) {
            this.root = new TreeNode(item);
            return;
        }
        
        // Queue setup
        LinkedListQueue queue = new LinkedListQueue();
        queue.enqueue(this.root);
        
        // Checks to see if any of the nodes are missing items
        while (queue.isEmpty() == false) {
            TreeNode current = queue.dequeue();
            // Checks if current's left node is full
            if (current.left == null) {
                current.left = new TreeNode(item);
                return;
            }
            // Checks if current's right node is full
            if (current.right == null) {
                current.right = new TreeNode(item);
                return;
            }
            queue.enqueue(current.left);
            queue.enqueue(current.right);
        }
    }

    // Check if the tree contains an item
    public boolean search(char item) {

        if (this.root == null) {
            return false;
        }
        
        LinkedListQueue queue = new LinkedListQueue();
        queue.enqueue(this.root);

        while (queue.isEmpty() == false) {
            TreeNode current = queue.dequeue();
            if (current.data == item) {
                return true;
            }
            if (current.left != null) {
                queue.enqueue(current.left);
            }
            if (current.right != null) {
                queue.enqueue(current.right);
            } 
        }
        return false;
    }

    // Get the number of nodes in the tree
    public int size() {
        return size(this.root);
    }

    // Helper function for public function size
    private int size(TreeNode current) {
        if (current == null) {
            return 0;
        }
        return size(current.left) + size(current.right) + 1;
    }

    // Check if the tree is empty
    public boolean isEmpty() {
        return (this.root == null);
    }

    // Get the height of the tree (number of nodes along the 
    // longest path from the root node down to the farthest leaf node)
    public int height() {
        return this.height(this.root);
    }

    // Helper function for public function height
    private int height(TreeNode current) {
        if (current == null) {
            return 0;
        }

        int lheight = this.height(current.left);
        int rheight = this.height(current.right);
        
        if (lheight > rheight) {
            return lheight + 1;
        }
        if (rheight > lheight) {
            return rheight + 1;
        }
        return lheight + 1;
    }

}
