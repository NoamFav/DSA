import java.util.Arrays;

public class CountingSort {
    private void countingSort(int[] array) {
        int min = minmax(array, true);
        int max = minmax(array, false);
        int range = max - min + 1;

        int[] count = new int[range];
        for (int v : array) {
            count[v - min]++;
        }

        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        int[] output = new int[array.length];
        for (int i = array.length - 1; i >= 0; i--) {
            output[count[array[i] - min] - 1] = array[i];
            count[array[i] - min]--;
        }

        // Copy the sorted elements back into the original array
        System.arraycopy(output, 0, array, 0, array.length);

    }

    private int minmax(int[] array, boolean isMin) {
        int value = isMin ? Integer.MAX_VALUE : Integer.MIN_VALUE;

        for (int v : array) {
            if (isMin) {
                if (value > v) {
                    value = v;
                }
            } else {
                if (value < v) {
                    value = v;
                }
            }
        }
        return value;
    }

    public static void main(String[] args) {
        CountingSort countingSort = new CountingSort();
        int[] array = {2,1,1,3,3,9,7,6,4,8,5,8,1,9,7};

        countingSort.countingSort(array);

        System.out.println(Arrays.toString(array));
    }
}