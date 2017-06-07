package datastructure;

public class Heap {
    private int[] data;
    private int size;
    private int maximumSize;

    public Heap() {
        this.maximumSize = 127;
        this.size = 0;
        this.data = new int[maximumSize];
    }

    public Heap(int maximumSize) {
        if (maximumSize < 1) {
            this.maximumSize = 127;
        } else {
            this.maximumSize = maximumSize;
        }
        this.size = 0;
        this.data = new int[maximumSize];
    }

    private boolean isEmpty() {
        return size == 0;
    }

    private boolean isFull() {
        return this.size == this.maximumSize;
    }

    public void clear() {
        this.size = 0;
        this.data = null;
    }

    void insert(int newValue) {
        int pointer;
        if (isFull()) {
            System.out.println("Error : 이미 차있습니다");
        } else {
            data[size] = newValue;
            pointer = size;
            size++;

            //up-heap bubbling
            while (pointer > 0 && data[pointer] < data[(pointer - 1) / 2]) {
                int temp = data[pointer];
                data[pointer] = data[(pointer - 1) / 2];
                data[(pointer - 1) / 2] = temp;

                pointer = (pointer - 1) / 2;
            }
        }
    }

    int remove() {
        int retValue;
        if (isEmpty()) {
            System.out.println("Error : 이미 비어 있습니다");
            return 0;
        } else {
            retValue = data[0];
            size--;
            data[0] = data[size];
            data[size] = 0;
            downBubbling();
            return retValue;
        }
    }

    private void downBubbling() {
        int pointer = 0;
        int childValue;

        while (pointer * 2 + 2 < size) {
            if (data[pointer * 2 + 1] < data[pointer * 2 + 2]) {
                childValue = 1;
            } else {
                childValue = 2;
            }

            int temp = data[pointer];
            data[pointer] = data[pointer * 2 + childValue];
            data[pointer * 2 + childValue] = temp;
            pointer = pointer * 2 + childValue;
        }
    }

    void printAll() {
        int pointer = 0;
        while (pointer < size) {
            System.out.print(data[pointer] + " ");
            pointer++;
        }
        System.out.println();
    }
}
