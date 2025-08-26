import java.lang.reflect.Array;
import java.util.Arrays;

public class Driver {
    
    public static void main(String[] args) {
        MinHeap<Integer> heap = new MinHeap<>();
        heap.setBackingArray(new Integer[]{null, 1, 2, 3, 4, 5, 6, 7, 8, 9});
        System.out.println("Initial heap: " + Arrays.toString(heap.getBackingArray()));
        heap.add(0);
        System.out.println("Heap after adding 0: " + Arrays.toString(heap.getBackingArray()));
        heap.setBackingArray(new Integer[]{null, 0, 1, 2, 4, 3, 5, 7, 6, 8, 9, 10});
        System.out.println("Resetting heap for remove case: " + Arrays.toString(heap.getBackingArray()));
        heap.remove();
        System.out.println("Heap after removing: " + Arrays.toString(heap.getBackingArray()));
    }

}
