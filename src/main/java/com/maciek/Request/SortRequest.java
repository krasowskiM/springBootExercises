package com.maciek.Request;

/**
 * Created by Maciek on 2017-02-06.
 */
public class SortRequest {
    private int size;
    private String numbers;
    private String type;

    public SortRequest() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
