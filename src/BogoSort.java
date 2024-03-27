import java.util.Arrays;
import java.util.Random;

public class BogoSort {
    private void bogoSort(double[] array) {
        while(!isSorted(array)) {
            shuffle(array);
        }
    }

    private boolean isSorted(double[] array) {
        for(int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i+1]) {
                return false;
            }
        }
        return true;
    }

    private void shuffle(double[] array) {
        Random rand = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            swap(array, i, j);
        }
    }
    private static void swap(double[] arr, int i, int j) {
        double temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        BogoSort bogoSort = new BogoSort();
        double[] array =  {6,2,7,9,4,8,5,3,1,0};
        bogoSort.bogoSort(array);

        System.out.println(Arrays.toString(array));
    }
}
