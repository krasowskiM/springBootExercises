package com.maciek.Response;

/**
 * Created by Maciek on 2017-02-06.
 */
public class SortResponse {
    private String beforeSort;
    private Integer[] sortedArray;

    public SortResponse(String beforeSort, Integer[] sortedArray) {
        this.beforeSort = beforeSort;
        this.sortedArray = sortedArray;
    }

    public String getBeforeSort() {
        return beforeSort;
    }

    public void setBeforeSort(String beforeSort) {
        this.beforeSort = beforeSort;
    }

    public Integer[] getSortedArray() {
        return sortedArray;
    }

    public void setSortedArray(Integer[] sortedArray) {
        this.sortedArray = sortedArray;
    }
}
