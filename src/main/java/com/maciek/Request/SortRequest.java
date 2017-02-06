package com.maciek.Request;

/**
 * Created by Maciek on 2017-02-06.
 */
public class SortRequest {
    private int size;
    private String numbers;

    public SortRequest() {
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setNumbers(String numbers) {
        this.numbers = numbers;
    }

    public int getSize() {
        return size;
    }

    public String getNumbers() {
        return numbers;
    }
}
