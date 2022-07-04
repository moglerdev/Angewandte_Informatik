package aufgabe07;

import java.awt.color.ICC_ProfileRGB;
import java.awt.image.renderable.RenderableImage;
import java.lang.reflect.Array;
import java.util.Arrays;

public class QuickSort {
    private static boolean withThreeMedian = true;
    private static final int nCountInsertionSort = 100;

    private static <T extends Comparable<T>> void swap (T[] data, int a, int b) {
        var tmp = data[a];
        data[a] = data[b];
        data[b] = tmp;
    }

    private static <T extends Comparable<T>> void threeMedian (T[] data, int start, int end) {
        var middle = (start + end) / 2;
        swap(data, middle, end);
    }

    private static <T extends Comparable<T>> void  insertionSort(T[] data, int start, int end) {
        for (int i = start; i <= end; ++i) {
            for (int k = i - 1; k >= start; --k) {
                if (data[k].compareTo(data[k + 1]) > 0) {
                    T temp = data[k];
                    data[k] = data[k + 1];
                    data[k + 1] = temp;
                } else
                    break;
            }
        }
    }

    private static <T extends Comparable<T>> int quickSort(T[] data, int start, int end) {
        int res = 1;

        if (end - start < nCountInsertionSort) {
            insertionSort(data, start, end);
        }
        else if (end > start) {
            if (withThreeMedian)
                threeMedian(data, start, end);

            int part = partition(data, start, end);

            res += quickSort(data, start, part - 1);
            res += quickSort(data, part + 1, end);
        }
        return res;
    }

    private static <T extends Comparable<T>> int partition(T[] data, int start, int end) {
        int cur_start = start - 1;
        int cur_end = end;

        T pivot = data[end];
        while (true) {
            // data[cur_start] < pivot => -1
            do ++cur_start; while (data[cur_start].compareTo(pivot) < 0);
            // data[cur_end] > pivot => 1
            do --cur_end; while (data[cur_end].compareTo(pivot) > 0 && start < cur_end);

            if (cur_start >= cur_end)
                break;

            swap(data, cur_start, cur_end);
        }
        // Pivot Element (ganz rechts / am Ende) mit Wert in der Mitte tauschen
        swap(data, cur_start, end);

        return cur_start;
    }

    public static <T extends Comparable<T>> int quicksort(T[] data, boolean withThreeMedian) {
        QuickSort.withThreeMedian = withThreeMedian;
        return quickSort(data, 0, data.length - 1);
    }
}
