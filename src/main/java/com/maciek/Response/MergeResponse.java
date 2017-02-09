package com.maciek.Response;

/**
 * Created by Maciek on 2017-02-09.
 */
public class MergeResponse {
    private Integer[] mergedArray;

    public MergeResponse(Integer[] mergedArray) {
        this.mergedArray = mergedArray;
    }

    public Integer[] getMergedArray() {
        return mergedArray;
    }

    public void setMergedArray(Integer[] mergedArray) {
        this.mergedArray = mergedArray;
    }
}
