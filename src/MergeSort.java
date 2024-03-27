import java.util.Arrays;

public class MergeSort {
    private double[] mergeSort(double[] array) {
        if (array.length == 1) {
            return array;
        }
        int middle = array.length / 2;

        double[] left = Arrays.copyOfRange(array, 0, middle);
        double[] right =  Arrays.copyOfRange(array, middle, array.length);

        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left, right);
    }

    private double[] merge(double[] left, double[] right) {
        int leftIndex = 0;
        int rightIndex = 0;
        double[] merge = new double[left.length + right.length];
        int mergeIndex = 0;

        while ((leftIndex < left.length) && (rightIndex < right.length)) {
            if (left[leftIndex] < right[rightIndex]) {
                merge[mergeIndex] = left[leftIndex];
                leftIndex++;
            } else {
                merge[mergeIndex] = right[rightIndex];
                rightIndex++;
            }
            mergeIndex++;
        }

        while (leftIndex < left.length) {
            merge[mergeIndex] = left[leftIndex];
            leftIndex++;
            mergeIndex++;
        }

        while (rightIndex < right.length) {
            merge[mergeIndex] = right[rightIndex];
            rightIndex++;
            mergeIndex++;
        }

        return merge;
    }


    public static void main(String[] args) {
        MergeSort mergeSort =  new MergeSort();
        double[] array = {1,6,8,7,3,4,9,2,5};

        double[] merge = mergeSort.mergeSort(array);
        System.out.println(Arrays.toString(merge));
    }
}
