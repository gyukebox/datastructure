package datastructure;

public class Heap {
    private int[] data;
    private int size;
    private int maximumSize;

    public Heap() {
        this.maximumSize = 127;
        this.data = new int[maximumSize];
        this.size = 0;
    }

    public Heap(int maximumSize) {
        this.maximumSize = maximumSize;
        if (maximumSize < 1) {
            this.maximumSize = 127;
        }
        this.data = new int[maximumSize];
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean isFull() {
        return this.size == this.maximumSize;
    }

    public void clear() {
        this.data = null;
        this.size = 0;
    }

    public void insert(int data) {
        if (isFull()) {
            System.out.println("Error : Heap is full");
        } else {
            this.data[this.size] = data;
            int pointer = this.size;
            this.size++;

            upHeapBubbling(pointer);
        }
    }

    private void upHeapBubbling(int pointer) {
        while (true) {
            if (pointer < 1) {
                break;
            } else if (data[pointer] >= data[(pointer - 1) / 2]) {
                break;
            } else {
                int temp = data[pointer];
                data[pointer] = data[(pointer - 1) / 2];
                data[(pointer - 1) / 2] = temp;

                pointer = (pointer - 1) / 2;
            }
        }
    }

    public int remove() {
        if(isEmpty()) {
            System.out.println("Error : Heap is Empty");
            return -1;
        }
        int ret = this.data[0];
        this.size--;
        this.data[0] = this.data[size];
        this.data[size] = 0;
        downHeapBubbling();
        return ret;
    }

    private void downHeapBubbling() {
        int pointer = 0;
        int childValue; // 1=left, 2=right

        while (true) {
            if (pointer * 2 + 2 >= size) {
                break;
            }

            if(data[pointer * 2 + 1] < data[pointer * 2 + 2]) {
                childValue = 1;
            } else {
                childValue = 2;
            }

            int temp = data[pointer];
            data[pointer] = data[2 * pointer + childValue];
            data[2 * pointer + childValue] = temp;

            pointer = pointer * 2 + childValue;
        }
    }

    public void printHeap() {
        System.out.print("[ ");
        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println("]");
    }
}
