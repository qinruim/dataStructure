package practice.techPractice.sort;

public class Utils {
    public static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    public static void swapInt(int i, int j) {
        int t = i;
        i = j;
        j = t;
    }

}
