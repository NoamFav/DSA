import java.util.Arrays;
import java.util.LinkedList;

public class BubbleSort {
    private void bubbleSort(double[] array) {
        double temp;
        boolean swapped;

        do {
            swapped = false;
            for (int currentIndex = 0; currentIndex < array.length - 1; currentIndex++) {
                if (array[currentIndex] > array[currentIndex + 1]) {
                    temp = array[currentIndex];
                    array[currentIndex] = array[currentIndex + 1];
                    array[currentIndex + 1] = temp;
                    swapped = true;
                }
            }
        } while (swapped);

    }

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        double[] array = {1,9,7,6,4,5,3,8,2};
        bubbleSort.bubbleSort(array);

        System.out.println(Arrays.toString(array));
    }
}
