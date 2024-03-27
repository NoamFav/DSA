import java.util.Arrays;

public class BubbleSort {
    private double[] bubbleSort(double[] array) {
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

        return array;
    }

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        double[] array = {1,9,7,6,4,5,3,8,2};
        double[] sorted = bubbleSort.bubbleSort(array);

        System.out.println(Arrays.toString(sorted));
    }
}
