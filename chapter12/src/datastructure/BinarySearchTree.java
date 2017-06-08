package datastructure;

public class BinarySearchTree {
    public Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    private Node TreeSearch(int k, Node v) {
        if (v == null) {
            return v;
        }

        if (k > v.getData()) {
            return TreeSearch(k, v.getRight());
        } else if (k < v.getData()) {
            return TreeSearch(k, v.getLeft());
        }

        return v;
    }

    public boolean find(int n) {
        Node node = TreeSearch(n, this.root);
        if (node == null) {
            return false;
        } else {
            return true;
        }
    }

    public void insert(int value) {
        if (this.root == null) {
            root = new Node(value);
        }
        insertRecursive(value, root);
    }

    public Node insertRecursive(int value, Node node) {
        if (node == null) {
            Node newNode = new Node(value);
            return newNode;
        } else if (value < node.getData()) {
            Node ret = insertRecursive(value, node.getLeft());
            node.setLeft(ret);
            return node;
        } else if (value > node.getData()) {
            Node ret = insertRecursive(value, node.getRight());
            node.setRight(ret);
            return node;
        }

        return node;
    }

    public boolean delete(int value) {
        Node parent = root;
        Node current = root;
        boolean isLeftChild = false;

        while (current.getData() != value) {
            parent = current;
            if (current.getData() > value) {
                isLeftChild = true;
                current = current.getLeft();
            } else {
                isLeftChild = false;
                current = current.getRight();
            }
            if (current == null) {
                return false;
            }
        }

        // 자식이 1명도 없다
        if (current.getLeft() == null && current.getRight() == null) {
            if(isLeftChild) {
                parent.setLeft(null);
            } else {
                parent.setRight(null);
            }
        }

        // 자식이 1명만 있다
        else if (current.getLeft() == null) {
            if(current == root) {
                root = current.getRight();
            } else if(isLeftChild) {
                parent.setLeft(current.getRight());
            } else {
                parent.setRight(current.getRight());
            }
        } else if (current.getRight() == null) {
            if(current == root) {
                root = current.getLeft();
            } else if(isLeftChild) {
                parent.setLeft(current.getLeft());
            } else {
                parent.setRight(current.getLeft());
            }
        }

        // 자식이 2명 다 있다
        else if (current.getLeft() != null && current.getRight() != null) {
            Node successor = getSuccessor(current);
            if(current == root) {
                root = successor;
            } else if(isLeftChild) {
                parent.setLeft(successor);
            } else {
                parent.setRight(successor);
            }
            successor.left = current.left;
        }

        return true;
    }

    // 오른쪽 서브트리에서 가장 작은 노드를 리턴
    public Node getSuccessor(Node deleteNode) {
        Node successor = null;
        Node successorParent = null;
        Node current = deleteNode.getRight();

        while(current != null) {
            successorParent = successor;
            successor = current;
            current = current.getLeft();
        }

        if(successor != deleteNode.right) {
            successorParent.left = successor.right;
            successor.right = deleteNode.right;
        }

        return successor;
    }

    public void inOrderDisplay(Node node) {
        if(node != null) {
            inOrderDisplay(node.left);
            System.out.print(node.getData() + " ");
            inOrderDisplay(node.right);
        }
    }
}
