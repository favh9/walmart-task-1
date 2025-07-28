public class Main {
    public static void main(String[] args) {

        MaxHeap heap = new MaxHeap(5);
        heap.insert(new Product("F", 23));
        heap.insert(new Product("C", 33));
        heap.insert(new Product("B", 12));
        heap.insert(new Product("D", 64));
        heap.insert(new Product("F", 13));
        heap.insert(new Product("X", 79));
        heap.insert(new Product("L", 54));
        heap.insert(new Product("Z", 78));

        heap.printMaxHeap(); // uses popMax()
    }
}