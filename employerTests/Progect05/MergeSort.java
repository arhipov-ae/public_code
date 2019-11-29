import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) 
        var source = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 9};
        System.out.println("Original array:" + Arrays.toString(source));
        mergeSort(source, 0, source.length - 1);
        System.out.println("Sorted array: " + Arrays.toString(source));
    }

    private static void mergeSort(int[] a, int lo, int hi) {

        if (hi <= lo)
            return;
        int mid = lo + (hi - lo) / 2;
        mergeSort(a, lo, mid);
        mergeSort(a, mid + 1, hi);

        int[] buf = Arrays.copyOf(a, a.length);

        if (hi + 1 - lo >= 0) System.arraycopy(a, lo, buf, lo, hi + 1 - lo);

        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {

            if (i > mid) {
                a[k] = buf[j];
                j++;
            } else if (j > hi) {
                a[k] = buf[i];
                i++;
            } else if (buf[j] < buf[i]) {
                a[k] = buf[j];
                j++;
            } else {
                a[k] = buf[i];
                i++;
            }
        }
    }
}
