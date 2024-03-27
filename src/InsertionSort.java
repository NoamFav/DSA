import java.util.Arrays;

public class InsertionSort {
    private void insertionSort(double[] array) {
        for(int i = 1 ; i < array.length; i++) {
            double temp = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > temp) {
                array[j + 1] = array[j];
                j--;
            }
            array[j+1] = temp;
        }
    }

    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();

        double[] array = {1,7,9,6,4,3,8,2,0,5};

        insertionSort.insertionSort(array);

        System.out.println(Arrays.toString(array));
    }
}
