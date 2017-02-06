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
                if(array[i] > array[i+1]){
                    temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                    sorted = false;
                }
            }

        }

        return array;
    }
}
