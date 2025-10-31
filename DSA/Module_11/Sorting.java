package DSA.Module_11;

import java.util.Comparator;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;

import java.lang.Math;

/**
 * Your implementation of various divide & conquer sorting algorithms.
 */

public class Sorting {

    /**
     * Implement merge sort.
     *
     * It should be:
     * out-of-place
     * stable
     * not adaptive
     *
     * Have a worst case running time of: O(n log n)
     * And a best case running time of: O(n log n)
     *
     * You can create more arrays to run merge sort, but at the end, everything
     * should be merged back into the original T[] which was passed in.
     *
     * When splitting the array, if there is an odd number of elements, put the
     * extra data on the right side.
     *
     * Hint: You may need to create a helper method that merges two arrays
     * back into the original T[] array. If two data are equal when merging,
     * think about which subarray you should pull from first.
     *
     * You may assume that the passed in array and comparator are both valid
     * and will not be null.
     *
     * @param <T>        Data type to sort.
     * @param arr        The array to be sorted.
     * @param comparator The Comparator used to compare the data in arr.
     */
    public static <T> void mergeSort(T[] arr, Comparator<T> comparator) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if(arr.length <= 1) {
            return;
        }
        int len = arr.length;
        int midIdx = len / 2;
        T[] left = (T[]) new Object[midIdx];
        for(int i = 0; i < midIdx; i++) {
            left[i] = arr[i];
        }
        T[] right = (T[]) new Object[len - midIdx];
        int rightIdx = 0;
        for(int i = midIdx; i < len; i++) {
            right[rightIdx] = arr[i];
            rightIdx++;
        }
        mergeSort(left, comparator);
        mergeSort(right, comparator);
        int i = 0, j = 0, k = 0;
        while(i < left.length && j < right.length) {
            if(comparator.compare(left[i], right[j]) <= 0) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        while(i < left.length) {
            arr[k++] = left[i++];
        }
        while(j < right.length) {
            arr[k++] = right[j++];
        }
    }

    /**
     * Implement LSD (least significant digit) radix sort.
     *
     * It should be:
     * out-of-place
     * stable
     * not adaptive
     *
     * Have a worst case running time of: O(kn)
     * And a best case running time of: O(kn)
     *
     * Feel free to make an initial O(n) passthrough of the array to
     * determine k, the number of iterations you need.
     *
     * At no point should you find yourself needing a way to exponentiate a
     * number; any such method would be non-O(1). Think about how how you can
     * get each power of BASE naturally and efficiently as the algorithm
     * progresses through each digit.
     *
     * You may use an ArrayList or LinkedList if you wish, but it should only
     * be used inside radix sort and any radix sort helpers. Do NOT use these
     * classes with merge sort. However, be sure the List implementation you
     * choose allows for stability while being as efficient as possible.
     *
     * Do NOT use anything from the Math class except Math.abs().
     *
     * You may assume that the passed in array is valid and will not be null.
     *
     * @param arr The array to be sorted.
     */
    public static void lsdRadixSort(int[] arr) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if(arr.length <= 1) {
            return;
        }
        int max = 0;
        for(int num : arr) {
            if(Math.abs(num) > max) {
                max = Math.abs(num);
            }
        }
        LinkedList<Integer>[] buckets = new LinkedList[19];
        for(int i = 0; i < 19; i++) {
            buckets[i] = new LinkedList<>();
        }
        int place = 1;
        while(max / place > 0) {
            for(int num : arr) {
                int digit = (num / place) % 10;
                buckets[digit + 9].add(num);
            }
            int idx = 0;
            for(int i = 0; i < 19; i++) {
                while(!buckets[i].isEmpty()) {
                    arr[idx++] = buckets[i].removeFirst();
                }
            }
            place *= 10;
        }
        int[] tmp = new int[arr.length];
        int idx = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                tmp[idx++] = arr[i];
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0) {
                tmp[idx++] = arr[i];
            }
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = tmp[i];
        }
    }
}