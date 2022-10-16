package sorting;

import java.util.Arrays;

public class SortingAlgorithms {


    /**
     * INSTRUCTIONS
     * You must implement all of the sorting algorithms below. Feel free to add any helper methods that you may need,
     * but make sure they are private, as to not be accessed outside of this class.
     * <p>
     * You must also store the sorted arrays into their own individual database tables (Selection Sort should be stored
     * in table `selection_sort`, Insertion Sort should be stored in table `insertion_sort`)
     */

    long executionTime = 0;

    public static void printSortedArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public int[] selectionSort(int[] array) {
        final long startTime = System.currentTimeMillis();

        for (int i = 0; i < array.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min])
                    min = j;
            }

            int temp = array[min];
            array[min] = array[i];
            array[i] = temp;
        }

        final long endTime = System.currentTimeMillis();
        this.executionTime = endTime - startTime;

        return array;
    }

    public int[] insertionSort(int[] array) {
        final long startTime = System.currentTimeMillis();
        for (int i = 1; i < array.length; i++) {
            int tmp = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > tmp) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = tmp;
        }

        final long endTime = System.currentTimeMillis();
        this.executionTime = endTime - startTime;

        return array;
    }

    public int[] bubbleSort(int[] array) {
        int temp;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }

        }
        System.out.println(Arrays.toString(array));
        return array;
    }

    public int[] mergeSort(int[] array) {
        //Check if the array contains a single value
        if (array.length <= 1) {
            return array;
        }
        int midPoint = (array.length) / 2;
        int[] left = new int[midPoint];
        int[] right;
        // check if the array.length is an even number
        if (array.length % 2 == 0) {
            right = new int[midPoint];
        } else {
            right = new int[midPoint + 1];
        }//populate the R & L arrays
        for (int i = 0; i < midPoint; i++) {
            left[i] = array[i];
        }
        for (int j = 0; j < right.length; j++) {
            right[j] = array[midPoint + j];
        }
        int[] result = new int[array.length];

        left = mergeSort(left);
        right = mergeSort(right);
        result = merge(left, right);

        return result;
    }

    // Helper method
    private static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int leftPointer = 0;
        int rightPointer = 0;
        int resultPointer = 0;

        while (leftPointer < left.length || rightPointer < right.length) {
            if (leftPointer < left.length && rightPointer < right.length) {
                if (left[leftPointer] < right[rightPointer]) {
                    result[resultPointer++] = left[leftPointer++];

                } else {
                    result[resultPointer++] = right[rightPointer++];
                }
            } else if (leftPointer < left.length) {
                result[resultPointer++] = left[leftPointer++];
            } else if (rightPointer < right.length) {
                result[resultPointer++] = right[rightPointer++];
            }
        }
        return result;
    }

    //QuickSort


    public int[] heapSort(int[] array) {
        // IMPLEMENT HERE
        int len = array.length;

        for (int i = len / 2 - 1; i >= 0; i--) {
            heapify(array, len, i);
        }

        for (int i=len-1; i>=0; i--)
        {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            heapify(array, i, 0);
        }
        return array;
    }
    private void heapify(int[] array, int N, int i) {
        int largestAtIndex = i;
        // finding the left child element to the parent element
        int leftChild = 2 * i + 1;
        // finding the right child element to the parent element
        int rightChild = 2 * i + 2;

        if (leftChild < N && array[leftChild] > array[largestAtIndex]) {
            largestAtIndex = leftChild;
        }
        if (rightChild < N && array[rightChild] > array[largestAtIndex]) {
            largestAtIndex = rightChild;
        }
        if (largestAtIndex != i) {
            int temp = array[i];
            array[i] = array[largestAtIndex];
            array[largestAtIndex] = temp;

            heapify(array, N, largestAtIndex);
        }
    }

    public int[] quickSort(int[] array) {
        // IMPLEMENT HERE
        final long startTime = System.currentTimeMillis();
        // check the method below quicksort
        quickSort(array, 0, array.length - 1);

        final long endTime = System.currentTimeMillis();
        this.executionTime = endTime - startTime;
        return array;
    }

    public int[] quickSort(int[] array, int low, int high) {
        if (low >= high) {
            return array;
        }
        int startPointer = low;
        int endPointer = high;
        int midpoint = startPointer + (endPointer - startPointer) / 2, pivot = array[midpoint];

        while (startPointer <= endPointer) {

            while (array[startPointer] < pivot) {
                startPointer++;
            }
            while (array[endPointer] > pivot) {
                endPointer--;
            }
            if (startPointer <= endPointer) {
                int temp = array[startPointer];
                array[startPointer] = array[endPointer];
                array[endPointer] = temp;
                startPointer++;
                endPointer--;
            }
        }

        quickSort(array, low, endPointer);
        quickSort(array, startPointer, high);
        return array;
    }

    public int[] bucketSort(int[] array) {
        //implement here

        return array;
    }

    public int[] shellSort(int[] array) {
        //implement here

        return array;
    }
}
