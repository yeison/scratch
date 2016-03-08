import java.util.Arrays;

/**
 * Created by yeison on 2/24/16.
 *
 * Naive QuickSort without randomization of pivots
 */
public class QuickSort {

    public static void main(String[] args){

        int[] test = {6, 2, 7, 1, 7, 1, 22, 6, 1, 66, 1, 2, 6, 71, 8 ,9, 0, 0};

        quickSort(test, 0, test.length-1);

        System.out.println(Arrays.toString(test));

    }

    public static void quickSort(int[] a, int start, int end){

        int n = end - start;

        if(n < 1) return;

        int pivot = partition(a, start, end);

        quickSort(a, start, pivot-1);

        quickSort(a, pivot+1, end);

    }

    /**
     * Assumes the pivot is the first element in the array a[start]
     */
    private static int partition(int[] a, int start, int end) {
        int i = start + 1;

        for (int j = start+1; j <= end; j++) {
            if(a[j] < a[start]){
                swap(a, i, j);
                i++;
            }
        }

        swap(a, start, i-1);

        return i-1;
    }

    private static void swap(int[] a, int i, int j) {
        if(i == j) return; // skip redundant swaps

        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}