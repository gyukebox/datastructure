package datastructure;

public class BinarySearchTree {
    public Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    private Node TreeSearch(int k, Node v) {
        if(v == null) {
            return v;
        }

        if(k > v.getData()) {
            return TreeSearch(k, v.getRight());
        } else if(k < v.getData()) {
            return TreeSearch(k, v.getLeft());
        }

        return v;
    }

    public boolean find(int n) {
        Node node = TreeSearch(n, this.root);
        if(node == null) {
            return false;
        } else {
            return true;
        }
    }

    public void insert(int value) {
        if(this.root == null) {
            root = new Node(value);
        }
        insertRecursive(value, root);
    }

    public Node insertRecursive(int value, Node node) {
        if(node == null) {
            Node newNode = new Node(value);
            return newNode;
        } else if(value < node.getData()) {
            Node ret = insertRecursive(value, node.getLeft());
            node.setLeft(ret);
            return ret;
        } else if(value > node.getData()) {
            Node ret = insertRecursive(value, node.getRight());
            node.setRight(ret);
            return ret;
        }

        return node;
    }
}
