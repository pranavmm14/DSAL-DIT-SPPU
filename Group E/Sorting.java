/*
SPPU Computer Engineering DSA Lab 
Group E
Experiment Sr. No. - 21

Implement the Heap/Shell sort algorithm implemented in Java demonstrating 
heap/shell data structure with modularity of programming language
*/
import java.util.Arrays;

public class Sorting {
    public static void main(String[] args) {
        int[] arr = { 10, 5, 3, 8, 6, 2, 1, 4, 7, 9 };

        System.out.println("Original Array: " + Arrays.toString(arr));

        // Heap Sort
        heapSort(arr);
        System.out.println("Array after Heap Sort: " + Arrays.toString(arr));

        // Shell Sort
        shellSort(arr);
        System.out.println("Array after Shell Sort: " + Arrays.toString(arr));
    }

    public static void heapSort(int[] arr) {
        int n = arr.length;

        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // Heap sort
        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    public static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest])
            largest = left;

        if (right < n && arr[right] > arr[largest])
            largest = right;

        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, n, largest);
        }
    }

    public static void shellSort(int[] arr) {
        int n = arr.length;

        // Start with a large gap and reduce it
        for (int gap = n / 2; gap > 0; gap /= 2) {
            // Perform insertion sort within each gap
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j = i;

                while (j >= gap && arr[j - gap] > temp) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }

                arr[j] = temp;
            }
        }
    }
}
