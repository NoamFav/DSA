import java.util.Arrays;

public class QuickSort {
    private void quickSort(double[] array) {
        quickSortRec(array, 0, array.length - 1);
    }
    private void quickSortRec(double[] array, int low, int high) {
        if (low < high) {
            int part = partition(array, low, high);

            quickSortRec(array, low, part - 1);
            quickSortRec(array, part + 1, high);
        }
    }

    private int partition(double[] array, int low, int high) {
        double pivot = array[high];
        double temp;
        int i = low-1;
        for(int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;

                temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        double[] array = {5,7,6,9,1,3,4,8,0};

        quickSort.quickSort(array);

        System.out.println(Arrays.toString(array));
    }
}
