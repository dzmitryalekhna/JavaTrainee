package by.alekhna.service.impl;

import by.alekhna.entity.CustomArray;
import by.alekhna.service.ArraySortService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArraySortServiceImpl implements ArraySortService {

    static Logger logger = LogManager.getLogger();

    @Override
    public void quickSort(CustomArray customArray) {
        logger.info("Array BEFORE quick sort  = {}", customArray.getIntArray());
        int[] array = customArray.getIntArray();
        if (array == null || array.length == 0) {
            return;
        }
        quickSort(array, 0, array.length - 1);
        logger.info("Array AFTER quick sort  = {}", customArray.getIntArray());
    }

    private void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }

    private int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, high);
        return i + 1;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    @Override
    public void shakeSort(CustomArray customArray) {
        int[] array = customArray.getIntArray();
        if (array == null || array.length == 0) {
            return;
        }

        int start = 0;
        int end = array.length - 1;
        boolean swapped;

        do {
            swapped = false;

            // Forward pass (left to right)
            for (int i = start; i < end; i++) {
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                    swapped = true;
                }
            }
            end--;

            if (!swapped) {
                break;
            }

            swapped = false;

            // Backward pass (right to left)
            for (int i = end; i > start; i--) {
                if (array[i] < array[i - 1]) {
                    swap(array, i, i - 1);
                    swapped = true;
                }
            }
            start++;

        } while (swapped);
    }
}