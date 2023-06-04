import java.util.Arrays;

public class MathUtils {


    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }
    public int multiply(int a, int b) {
        return a * b;
    }
    public int divide(int a, int b) {
        return a / b;
    }

    public double computeCircleArea(double radius) {


        return Math.PI * radius * radius;
    }

//    int[] arr = {1,2,3,4,5,6,7,8,9,10};
//    int[] arr = new int[3];

    public static int binarySearch(int[] arr, int target) {
//        arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                System.out.println(arr[mid]);
                return arr[mid];
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static int[] mergesort(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }

        int mid = arr.length / 2;
        int[] left = mergesort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergesort(Arrays.copyOfRange(arr, mid, arr.length));
        return merge(left, right);
    }

    public static int[] merge(int[] left, int[] right) {
        int[] merged = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                merged[k++] = left[i++];
            } else {
                merged[k++] = right[j++];
            }
        }

        while (i < left.length) {
            merged[k++] = left[i++];
        }
        while (j < right.length) {
            merged[k++] = right[j++];
        }
//        System.out.println(merged.de());
        System.out.println(Arrays.toString(merged));
        return merged;
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        binarySearch(arr, 90);
//        int[] array = {10, 70, 50, 66, 20, 89, 32, 30, 40, 87, 50, 675, 60, 70, 329, 80, 76, 87, 90, 456, 100};
        int[] array = {675, 60, 70, 329, 80};
        mergesort(array);
    }


}
