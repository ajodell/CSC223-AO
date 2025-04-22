package csc223.ad;

public class BinarySearchTree {
    
    // Node class for use only within BinarySearchTree
    class Node {
    
        protected Node right;
        protected Node left;
        protected int data;
    
        public Node(int data) {
            this.left = null;
            this.data = data;
            this.right = null;
        }
    }

    Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    // Insert a new node into the tree while maintaining BST order
    public void insert(int value) {
        // First check if the root is null
        if (this.root == null) {
            this.root = new Node(value);
        }
        else {
            insert(value, this.root);
        }
    }

    // Helper function for public function insert
    private Node insert(int value, Node curr) {
        // If an empty node is found, make a new one
        if (curr == null) {
            return new Node(value);
        }

        // If the value is less than the current, check the left
        if (value <= curr.data) {
            curr.left = insert(value, curr.left);
        }

        // If the value is greater than the current, check the right
        if (value > curr.data) {
            curr.right = insert(value, curr.right);
        }
        return curr;
    }

    // Deletes a value from the tree while maintaining BST order
    public BinarySearchTree delete(int value) {
        if (this.root == null) {
            return this;
        }
        this.root = delete(value, this.root);
        return this;
    }

    // Helper function for public function delete
    private Node delete(int value, Node curr) {
        // If the node isn't found, return null
        if (curr == null) {
            return null;
        }
        // If the value is less than current, go left
        if (value < curr.data) {
            curr.left = delete(value, curr.left);
        }
        // If the value is greater than current, go right
        if (value > curr.data) {
            curr.right = delete(value, curr.right);
        }
        // If the value matches current
        if (value == curr.data) {

            // If the left is null, return the right
            // Handles case of no children as well
            if (curr.left == null) {
                return curr.right;
            }
            // If the right is null, return the left
            if (curr.right == null) {
                return curr.left;
            }
            // Search for the successor node and use it to replace
            int oldVal = curr.data;
            curr.data = findSuccessor(curr.right, curr.data);
            curr.right = delete(oldVal, curr.right);
            return curr;
        }
        return curr;
    }

    // Helper function for private function delete; returns the value of the inorder successor of a given node
    private int findSuccessor(Node curr, int mainData) {
        if (curr.left == null) {
            int successorData = curr.data;
            curr.data = mainData;
            return successorData;
        }
        return findSuccessor(curr.left, mainData);
    }

    // Returns a bool depending on whether a value is in the tree
    public boolean search(int value) {
        return search(value, this.root);
    }

    // Helper function for public function search
    private boolean search(int value, Node curr) {
        // If the node is null
        if (curr == null) {
            return false;
        }
        // If the value is less than the current, check the left
        if (value < curr.data) {
            return search(value, curr.left);
        }
        // If the value is greater than the current, check the right
        if (value > curr.data) {
            return search(value, curr.right);
        }
        return true;
    }

    // Changes any given value in the tree while maintaining BST order
    public void update(int oldValue, int newValue) {
        delete(oldValue);
        insert(newValue);
    }

    // Returns a string of the inorder contents of the tree
    public String inorder() {
        return inorder(this.root);
    }

    // Helper function for public function inorder
    private String inorder(Node current) {
        if (current == null) {
            return "";
        }
        return inorder(current.left) + current.data + inorder(current.right);
    }

    // Converts a sorted array into a binary search tree
    public Node sortedArrayToBST(int[] values) {
        BinarySearchTree result = new BinarySearchTree();
        return sortedArrayToBST(result, values, 0);
    }

    // Helper function for public function sortedArrayToBST
    private Node sortedArrayToBST(BinarySearchTree result, int[] values, int count) {
        // When the list has been fully run through
        if (count == (values.length)) {
            return result.root;
        }
        // If more items still need to be inserted
        // Counter starts in the middle, progressing toward the end and jumping
        // to the beginning when the end is reached
        int midpoint = values.length / 2;
        if ((midpoint + count) < values.length) {
            result.insert(values[midpoint + count]);
        }
        else {
            // Provides calculation adjustments to counter location
            if ((values.length % 2) == 1) {
                result.insert(values[count - (midpoint + 1)]);
            }
            result.insert(values[count - midpoint]);
        }
        return sortedArrayToBST(result, values, count + 1);
    }

    // Locates the smallest common ancestor between any two nodes
    public int lowestCommonAncestor(int p, int q) {
        return Math.min(lowestCommonAncestor(p, this.root), lowestCommonAncestor(q, this.root));
    }

    // Helper function for public function lowestCommonAncestor
    private int lowestCommonAncestor(int value, Node curr) {
        // If the value is less than curr
        if (value < curr.data) {
            return Math.min(curr.data, lowestCommonAncestor(value, curr.left));
        }
        // If the value is greater than curr
        if (value > curr.data) {
            return Math.min(curr.data, lowestCommonAncestor(value, curr.right));
        }
        return curr.data;
    }
}