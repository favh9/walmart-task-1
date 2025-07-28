/*
 *  This class represents the Max Heap data structure.
 *  We use an array to limit memory usage. The order is based
 *  on how much each product weighs.
*/

public class MaxHeap {

    private Product[] productArr;

    private int capacity;
    private int size;

    public MaxHeap() {
        capacity = 0;
        size = 0;
    }

    public MaxHeap(int exp) {
        capacity = (int)(Math.pow(2, exp));
        productArr = new Product[capacity];
        size = 0;
    }

    /* Inserts a product into the heap and "floats" it upward if needed */
    public void insert(Product p) {

        if (capacity == size) {
            throw new RuntimeException("Heap needs space!");
        }
        size++;
        int index = size-1;

        productArr[index] = p;

        // float the new product upstream if its parent is smaller than it
        while (index > 0 && productArr[parent(index)].getWeight() <
                productArr[index].getWeight()) {
            swap(index, parent(index));
            index = parent(index);
        }

    }

    /* Extracts the largest product from the heap while keeping its properties */
    public Product popMax() {

        if (size == 0) {
            throw new RuntimeException("Heap is empty!");
        }

        // swap first with last, decrement size
        swap(0, size-1);
        size--;

        // float the new root down
        maxHeapify(0);

        return productArr[size];
    }

    /*------------------*/
    /* Helper Functions */
    /*------------------*/

    public int parent(int i) {
        return (i - 1) / 2;
    }

    public int leftChild(int i) {
        return i * 2 + 1;
    }

    public int rightChild(int i) {
        return i * 2 + 2;
    }

    public void swap(int i, int j) {
        Product tmp = productArr[i];
        productArr[i] = productArr[j];
        productArr[j] = tmp;
    }

    /* floats the product downstream until it respects the max-heap property --
    *  being larger than its children */
    public void maxHeapify(int i) {
        int left = leftChild(i);
        int right = rightChild(i);
        int largest = i;

        // check if left exists and if it is larger than the largest index
        if (left < size && productArr[left].getWeight() >
                productArr[largest].getWeight()) {
            largest = left;
        }

        // check if right exists and if it is larger than the largest index
        if (right < size && productArr[right].getWeight()
                > productArr[largest].getWeight()) {
            largest = right;
        }

        if (largest != i) {
            swap(i, largest);
            maxHeapify(largest);
        }
    }

    // uses popMax() to extract the largest product and displays
    // its value
    public void printMaxHeap() {

        System.out.println("Displaying in order! (largest to smallest)");

        while (size != 0) {
            Product p = popMax();
            System.out.println(p);
        }
    }

    public Product peek() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty!");
        }
        return productArr[0];
    }

    /*---------------------*/
    /* GETTERS AND SETTERS */
    /*---------------------*/

    public Product[] getProductArr() {
        return productArr;
    }

    public void setProductArr(Product[] productArr) {
        this.productArr = productArr;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}


