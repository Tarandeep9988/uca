public class MergeSort {
    public static void sort(int[] a, int l, int r, int[] aux) {
        if (l > r) return; 
        int mid = l + (r - l) / 2;
        sort(a, l, mid, aux);
        sort(a, mid + 1, r, aux);
        merge(a, l, r, aux);
    }
    private static void merge(int[] a, int l, int r, int[] aux) {
        int mid = l + (r - l) / 2;
        // complete this rest function
        
    }
}
