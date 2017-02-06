package com.maciek.Service;

/**
 * Created by Maciek on 2017-02-06.
 */

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SortingService {

    public Integer[] bubbleSort(int size, String numbers) {
        List<Integer> someNumbers = new ArrayList<>(size);
        boolean sorted = false;
        int temp;
        for (int i = 0; i < numbers.length(); i++) {
            char c = numbers.charAt(i);
            if (Character.isDigit(c)) {
                someNumbers.add(Character.getNumericValue(c));
            }
        }

        Integer[] array = someNumbers.toArray(new Integer[someNumbers.size()]);

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
        List<Integer> someNumbers = new ArrayList<>(size);
        int temp;
        for (int i = 0; i < numbers.length(); i++) {
            char c = numbers.charAt(i);
            if (Character.isDigit(c)) {
                someNumbers.add(Character.getNumericValue(c));
            }
        }

        Integer[] array = someNumbers.toArray(new Integer[someNumbers.size()]);

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
        List<Integer> someNumbers = new ArrayList<>(size);
        int temp, min, ind;
        for (int i = 0; i < numbers.length(); i++) {
            char c = numbers.charAt(i);
            if (Character.isDigit(c)) {
                someNumbers.add(Character.getNumericValue(c));
            }
        }

        Integer[] array = someNumbers.toArray(new Integer[someNumbers.size()]);

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
        List<Integer> someNumbers = new ArrayList<>(size);
        for (int i = 0; i < numbers.length(); i++) {
            char c = numbers.charAt(i);
            if (Character.isDigit(c)) {
                someNumbers.add(Character.getNumericValue(c));
            }
        }

        Integer[] array = someNumbers.toArray(new Integer[someNumbers.size()]);

        for(int i = 1; i < array.length; i++){
            int j = i;
            int toInsert = array[i];

            while ((j > 0) && (array[j-1] > toInsert)){
                array[j] = array[j-1];
                j--;
            }

            array[j] = toInsert;
        }

        return array;
    }

    }















