package sort;

public class SwapService {
    public static int[] swap(int[] array, int a, int b) {
        int  tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
        return array;
    }
}
