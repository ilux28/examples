package sort;

public class BoobleSort {

    public int[] sorting(int[] array) {
        boolean needSorted = true;
        while (needSorted) {
            for (int i = 0; i < array.length; i++) {
                needSorted = false;
                if (array[i] > array[i + 1]) {
                    SwapService.swap(array, i, i + 1);
                    needSorted = true;
                }
            }
        }
        return array;
    }
}
