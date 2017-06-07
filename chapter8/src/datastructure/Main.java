package datastructure;

public class Main {

    public static void main(String[] args) {
	    Heap heap = new Heap();
	    heap.insert(1);
	    heap.insert(5);
	    heap.insert(11);
        heap.insert(21);
        heap.insert(15);
        heap.printAll();

        heap.remove();
        heap.printAll();
    }
}
