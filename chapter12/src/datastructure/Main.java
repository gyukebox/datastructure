package datastructure;

public class Main {

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(3);
        bst.insert(8);
        bst.insert(1);
        bst.insert(4);
        bst.insert(6);
        bst.insert(2);
        bst.insert(10);
        bst.insert(9);
        bst.insert(20);
        bst.insert(25);
        bst.insert(15);
        bst.insert(16);

        System.out.println("original tree : ");
        bst.inOrderDisplay(bst.root);
        System.out.println();

        System.out.println("check whether node with value 4 exists : " + bst.find(4));
        System.out.println("Delete node with no children(2) : " + bst.delete(2));
        bst.inOrderDisplay(bst.root);
        System.out.println();
        System.out.println("Delete node with one child(4) : " + bst.delete(4));
        bst.inOrderDisplay(bst.root);
        System.out.println();
        System.out.println("Delete node with two children(10) : " + bst.delete(10));
        bst.inOrderDisplay(bst.root);
        System.out.println();
    }
}
