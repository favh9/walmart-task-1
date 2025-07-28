import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/* This represents a list of tests that satisfies a list
*  of requirements */
public class MaxHeapTest {


    // 1) every node in a heap must be
    // greater than or equal to the values of its children
    // --
    @Test
    void testGreaterOrEqualToChildren() {
        int exp = 5;
        MaxHeap heap = new MaxHeap(exp);

        heap.insert(new Product("C", 25));
        heap.insert(new Product("B", 123));
        heap.insert(new Product("I", 123));
        heap.insert(new Product("A", 50));
        heap.insert(new Product("D", 23));
        heap.insert(new Product("G", 23));
        heap.insert(new Product("F", 34));
        heap.insert(new Product("E", 5));

        double[] expected = {123, 123, 50, 34, 25, 23, 23, 5};

        for (double e : expected) {
            Assertions.assertEquals(e, heap.popMax().getWeight(), 0.01);
        }
    }

    // 2) every parent node in the heap must have 2^x children
    // --
    // using the constructor MaxHeap(int exp), we define an array
    // with a total capacity of 2^x elements.

    // 3) the value of x must be a parameter of the heap's constructor
    // --
    // using constructor MaxHeap(int exp)

    // 4) the heap must implement an insert method
    // --
    // using insert(Product product)

    // 5) the heap must be implemented in Java
    // --

    // 6) the heap must be performant
    // --
    // limited storage by utilizing an array
    // following heap properties to achieve
    // popMax() and insert() takes O(log(n))

    // 7) a more descriptive variable than x
    // --
    // I chose exp, short for exponent, showing that we can
    // choose an exponential capacity

    // 8) test very small and large values of x
    // and 9) sneaky edge cases
    // --
    // the rest of these methods are made to test 8 and 9
    @Test
    void testLargeValuesOfX() {
        int exp = 26;
        MaxHeap heap = new MaxHeap(exp);
        int capacity = (int) Math.pow(2, exp);

        // inserts millions of records
        for (int i = 0; i < capacity; i++) {
            heap.insert(new Product("testLargeValuesOfX", 10));
        }
    }

    @Test
    void testInsertIntoEmptyHeap() {

        MaxHeap heap = new MaxHeap();

        Exception e = Assertions.assertThrows(RuntimeException.class, () -> {
            heap.insert(new Product("testInsert", 10));
        });

        String expected = "Heap needs space!";
        String actual = e.getMessage();

        Assertions.assertTrue(actual.contains(expected));
    }

    @Test
    void testMultipleUpwardSwaps() {
        int exp = 26;
        int capacity = (int) Math.pow(2,exp);
        MaxHeap heap = new MaxHeap(exp);

        // inserts millions of records minus one from capacity
        for (int i = 0; i < capacity-1; i++) {
            heap.insert(new Product("testLargeInsertAmount", 10));
        }

        // results in several swaps upwards to replace root
        heap.insert(new Product("largerThanRoot", 20));
    }

    @Test
    void testInsertAtFullCapacity() {
        int exp = 3;
        MaxHeap heap = new MaxHeap(exp);
        int capacity = (int) Math.pow(2, exp);
        int atCapacity = capacity + 1;

        Exception e = Assertions.assertThrows(RuntimeException.class, () -> {
            for (int i = 0; i < atCapacity; i++) {
                heap.insert(new Product("testCapacity", 10));
            }
        });

        String expected = "Heap needs space!";
        String actual = e.getMessage();

        Assertions.assertTrue(actual.contains(expected));


    }

    @Test
    void testPopWhenEmpty() {
        int exp = 1;
        MaxHeap heap = new MaxHeap(exp);

        Exception e = Assertions.assertThrows(RuntimeException.class, () -> {
            Product p = heap.popMax();
        });

        String expected = "Heap is empty!";
        String actual = e.getMessage();

        Assertions.assertTrue(actual.contains(expected));
    }

    @Test
    void testPopWithOneElement() {
        int exp = 1;
        MaxHeap heap = new MaxHeap(exp);

        heap.insert(new Product("testOneElement", 10));
        heap.popMax();

        int expected = 0;
        int actual = heap.getSize();

        Assertions.assertEquals(expected, actual);
    }
}
