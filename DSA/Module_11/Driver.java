package DSA.Module_11;

public class Driver {
    public static void main(String[] args) {
        int[] arr = {-311, -785, -796, -796, -800, 151, 258, 258, 543, 543};
        Sorting.lsdRadixSort(arr);
        for(int n : arr) {
            System.out.print(n + " ");
        }
        System.out.printf("\n");

        int[] arr1 = {-9, Integer.MIN_VALUE, Integer.MIN_VALUE};
        Sorting.lsdRadixSort(arr1);
        for(int n : arr1) {
            System.out.print(n + " ");
        }
        System.out.printf("\n");
    }
}
