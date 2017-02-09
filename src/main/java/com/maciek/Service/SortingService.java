package com.maciek.Service;

/**
 * Created by Maciek on 2017-02-06.
 */

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SortingService {

    /**
     * Takes the input from user with numbers separated by space
     * and stores them in array.
     *
     * @param numbers string which contains the input.
     * @return array of numbers which will be used later.
     */
    private Integer[] convertToArray(String numbers) {
        String numberPartials = "";
        List<Integer> someNumbers = new ArrayList<>();
        for (int i = 0; i < numbers.length(); i++) {
            char c = numbers.charAt(i);
            if (Character.isDigit(c)) {
                numberPartials += c;
            } else if (c == ' ') {
                someNumbers.add(Integer.parseInt(numberPartials));
                numberPartials = "";
            }
        }

        if (!numberPartials.isEmpty()) {
            someNumbers.add(Integer.parseInt(numberPartials));
        }

        return someNumbers.toArray(new Integer[someNumbers.size()]);
    }

    /**
     * Merges two arrays which are input from the user
     * into one common array.
     *
     * @param array1 first input.
     * @param array2 second input.
     * @return merged array.
     */
    public Integer[] mergeArrays(String array1, String array2) {
        Integer[] arr1 = convertToArray(array1);
        Integer[] arr2 = convertToArray(array2);
        Integer[] mergedArray = new Integer[arr1.length + arr2.length];
        int arrayOneMaxInd = arr1.length;

        for (int i = 0; i < arr1.length; i++) {
            mergedArray[i] = arr1[i];
        }

        for (int j = 0; j < arr2.length; j++) {
            mergedArray[arrayOneMaxInd] = arr2[j];
            arrayOneMaxInd++;
        }

        return mergedArray;
    }

    /**
     * Sorts the array in a simple manner - comparing neighbouring elements
     * until the array is sorted.
     *
     * @param numbers input from user which is then converted to an array.
     * @return sorted array.
     */
    public Integer[] bubbleSort(String numbers) {
        boolean sorted = false;
        int temp;

        Integer[] array = convertToArray(numbers);

        while (!sorted) {
            sorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    sorted = false;
                }
            }

        }

        return array;
    }

    /**
     * Sorts the array by comparing values with separating
     *
     * @param numbers
     * @return
     */
    public Integer[] exchangeSort(String numbers) {
        int temp;
        Integer[] array = convertToArray(numbers);

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }

        return array;
    }

    public Integer[] selectionSort(String numbers) {
        int temp, min, ind;
        Integer[] array = convertToArray(numbers);

        for (int j = 0; j < array.length; j++) {
            min = array[j];
            ind = j;

            for (int i = j + 1; i < array.length; i++) {
                if (min > array[i]) {
                    min = array[i];
                    ind = i;
                }
            }

            temp = array[j];
            array[j] = min;
            array[ind] = temp;
        }

        return array;
    }

    public Integer[] insertionSort(String numbers) {
        Integer[] array = convertToArray(numbers);

        for (int i = 1; i < array.length; i++) {
            int j = i;
            int toInsert = array[i];

            while ((j > 0) && (array[j - 1] > toInsert)) {
                array[j] = array[j - 1];
                j--;
            }

            array[j] = toInsert;
        }

        return array;
    }

    public Integer[] shellSort(String numbers) {
        Integer[] array = convertToArray(numbers);

        int inner, outer, temp;
        int interval = 1;

        while (interval <= array.length / 3) {
            interval = interval * 3 + 1;
        }

        while (interval > 0) {
                for (outer = interval; outer < array.length; outer++) {
                    temp = array[outer];
                    inner = outer;

                    while (inner > interval - 1 && array[inner - interval] >= temp) {
                        array[inner] = array[inner - interval];
                        inner -= interval;
                    }

                    array[inner] = temp;
                }

                interval = (interval - 1) / 3;
            }


        return array;
    }

    private int partition(Integer[] array, int left, int right) {
        int i = left, j = right;
        int temp;
        int mid = array[(left + right) / 2];

        while (i <= j) {
            while (array[i] < mid) {
                i++;
            }
            while ((array[j] > mid)) {
                j--;
            }

            if (i <= j) {
                temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        return i;
    }

    private void quickSort(Integer[] array, int left, int right) {
        int ind = partition(array, left, right);
        if (left < ind - 1) {
            quickSort(array, left, ind - 1);
        }
        if (ind < right) {
            quickSort(array, ind, right);
        }
    }

    public Integer[] qSort(String numbers) {
        Integer[] array = convertToArray(numbers);
        int i = 0, j = array.length - 1;
        quickSort(array, i, j);

        return array;
    }
}













