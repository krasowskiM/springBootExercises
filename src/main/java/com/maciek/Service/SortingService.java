package com.maciek.Service;

/**
 * Created by Maciek on 2017-02-06.
 */

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SortingService {

    private Integer[] convertToArray(int size, String numbers) {
        String numberPartials = "";
        List<Integer> someNumbers = new ArrayList<>(size);
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

    public Integer[] bubbleSort(int size, String numbers) {
        boolean sorted = false;
        int temp;

        Integer[] array = convertToArray(size, numbers);

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

    public Integer[] exchangeSort(int size, String numbers) {
        int temp;
        Integer[] array = convertToArray(size, numbers);

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

    public Integer[] selectionSort(int size, String numbers) {
        int temp, min, ind;
        Integer[] array = convertToArray(size, numbers);

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

    public Integer[] insertionSort(int size, String numbers) {
        Integer[] array = convertToArray(size, numbers);

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

    private int partition(Integer[] array, int left, int right){
        int i = left, j = right;
        int temp;
        int mid = array[(left + right) / 2];

        while (i <= j){
            while(array[i] < mid){
                i++;
            }
            while ((array[j] > mid)){
                j--;
            }

            if(i <= j){
                temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        return i;
    }

    private void quickSort(Integer[] array, int left, int right){
        int ind = partition(array, left, right);
        if(left < ind - 1){
            quickSort(array, left, ind - 1);
        }
        if(ind < right){
            quickSort(array, ind, right);
        }
    }

    public Integer[] qSort(int size, String numbers) {
        Integer[] array = convertToArray(size, numbers);
        int i = 0, j = array.length - 1;
        quickSort(array, i, j);

        return array;
    }
}













