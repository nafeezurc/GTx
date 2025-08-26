import java.util.NoSuchElementException;

/**
 * Your implementation of a MinHeap.
 */
public class MinHeap<T extends Comparable<? super T>> {

    /**
     * The initial capacity of the MinHeap.
     *
     * DO NOT MODIFY THIS VARIABLE!
     */
    public static final int INITIAL_CAPACITY = 13;

     /*
     * Do not add new instance variables or modify existing ones.
     */
    private T[] backingArray;
    private int size;

    /**
     * This is the constructor that constructs a new MinHeap.
     *
     * Recall that Java does not allow for regular generic array creation,
     * so instead we cast a Comparable[] to a T[] to get the generic typing.
     */
    public MinHeap() {
        //DO NOT MODIFY THIS METHOD!
        backingArray = (T[]) new Comparable[INITIAL_CAPACITY];
    }

    /**
     * Adds an item to the heap. If the backing array is full (except for
     * index 0) and you're trying to add a new item, then double its capacity.
     *
     * Method should run in amortized O(log n) time.
     *
     * @param data The data to add.
     * @throws java.lang.IllegalArgumentException If the data is null.
     */
    public void add(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if(data == null) throw new IllegalArgumentException("Data can not be null");
        if(size + 1 == backingArray.length) { // if we're already at capacity, need to double size of backingArray
            T[] newArr = (T[]) new Comparable[backingArray.length*2];
            for(int i = 1; i < backingArray.length; i++) {
                newArr[i] = backingArray[i];
            }
            backingArray = newArr;
        }
        size++;
        backingArray[size] = data;
        heapifyUp(size);
    }

    private void heapifyUp(int index) {
        if(index == 0 || index/2 == 0) return;
        if(backingArray[index/2].compareTo(backingArray[index]) > 0) {
            T tmp = backingArray[index/2];
            backingArray[index/2] = backingArray[index];
            backingArray[index] = tmp;
            heapifyUp(index/2 > 0 ? index/2 : 0);
        }
    }

    /**
     * Removes and returns the min item of the heap. As usual for array-backed
     * structures, be sure to null out spots as you remove. Do not decrease the
     * capacity of the backing array.
     *
     * Method should run in O(log n) time.
     *
     * @return The data that was removed.
     * @throws java.util.NoSuchElementException If the heap is empty.
     */
    public T remove() {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if(backingArray[1] == null) throw new NoSuchElementException("Heap is empty");
        T res = backingArray[1];
        backingArray[1] = backingArray[size];
        backingArray[size] = null;
        size--;
        heapifyDown(1);
        return res;
    }

    private void heapifyDown(int index) {
        int leftIndex = 2*index;
        int rightIndex = 2*index + 1;
        if(leftIndex > backingArray.length || backingArray[leftIndex] == null) return;
        boolean leftOrRight = false; // false means left higher priority, true means right higher priority
        if(rightIndex < backingArray.length && backingArray[rightIndex] != null) {
            leftOrRight = backingArray[leftIndex].compareTo(backingArray[rightIndex]) > 0 ? true : false;
        }
        int targetIndex = leftOrRight == false ? leftIndex : rightIndex; // sets which child we look at
        
        if(backingArray[index].compareTo(backingArray[targetIndex]) < 0) return;
        else {
            T tmp = backingArray[targetIndex];
            backingArray[targetIndex] = backingArray[index];
            backingArray[index] = tmp;
            heapifyDown(targetIndex);
        }
    }

    /**
     * Returns the backing array of the heap.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The backing array of the list
     */
    public T[] getBackingArray() {
        // DO NOT MODIFY THIS METHOD!
        return backingArray;
    }

    /**
     * Returns the size of the heap.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The size of the list
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }
    
    // do not submit these, testing purposes only
    public void setBackingArray(T[] newArr) {
        size = 0;
        backingArray = newArr;
        for(int i = 0; i < backingArray.length; i++) {
            if(backingArray[i] != null) size++;
        }
    }
}
