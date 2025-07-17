import java.util.Arrays;

public class SelectionSort {
    
    public static void selectionSort(Comparable[] list) {
        int minIndex;
        Comparable nextSmallest;

        for(int unsortedStart = 0; unsortedStart < list.length - 1; unsortedStart++) {
            minIndex = unsortedStart;
            for(int curIndex = unsortedStart + 1; curIndex < list.length; curIndex++) {
                if(list[minIndex].compareTo(list[curIndex]) < 0) {
                    minIndex = curIndex;
                }
            }
            nextSmallest = list[minIndex];
            list[minIndex] = list[unsortedStart];
            list[unsortedStart] = nextSmallest;
        }
    }

}
