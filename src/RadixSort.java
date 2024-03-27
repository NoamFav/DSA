import java.util.Arrays;

public class RadixSort {
    public void radixSort(int[] array, int n) {
        int m = getMax(array, n);

        for (int exp = 1; m / exp > 0; exp *= 10)
            countSort(array, n, exp);
    }

    private int getMax(int[] array, int n) {
        int mx = array[0];
        for (int i = 1; i < n; i++)
            if (array[i] > mx)
                mx = array[i];
        return mx;
    }

    private void countSort(int[] array, int n, int exp) {
        int[] output = new int[n];
        int i;
        int[] count = new int[10];
        Arrays.fill(count, 0);

        for (i = 0; i < n; i++)
            count[(array[i] / exp) % 10]++;

        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];

        for (i = n - 1; i >= 0; i--) {
            output[count[(array[i] / exp) % 10] - 1] = array[i];
            count[(array[i] / exp) % 10]--;
        }

        for (i = 0; i < n; i++)
            array[i] = output[i];
    }

    public static void main(String[] args) {
        RadixSort rs = new RadixSort();
        int[] array = {170, 45, 75, 90, 802, 24, 2, 66};
        int n = array.length;
        rs.radixSort(array, n);
        System.out.println(Arrays.toString(array));
    }
}