package com.maciek.Controller;

import com.maciek.Request.MergeRequest;
import com.maciek.Request.SortRequest;
import com.maciek.Response.MergeResponse;
import com.maciek.Response.SortResponse;
import com.maciek.Service.SortingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Maciek on 2017-02-06.
 */
@RestController
public class MainController {
    private final SortingService sortingService;

    @Autowired
    public MainController(SortingService sortingService) {
        this.sortingService = sortingService;
    }

    @RequestMapping(value = "/sort", method = RequestMethod.POST)
    public SortResponse sortNumbers(@RequestBody SortRequest sortRequest) {
        long t1 = 0L, t2 = 0L;
        Integer[] sortedArray = new Integer[]{};
        switch (sortRequest.getType()) {
            case "selection":
                t1 = System.currentTimeMillis();
                sortedArray = sortingService.selectionSort(sortRequest.getNumbers());
                t2 = System.currentTimeMillis();
                break;
            case "bubble":
                t1 = System.currentTimeMillis();
                sortedArray = sortingService.bubbleSort(sortRequest.getNumbers());
                t2 = System.currentTimeMillis();
                break;
            case "exchange":
                t1 = System.currentTimeMillis();
                sortedArray = sortingService.exchangeSort(sortRequest.getNumbers());
                t2 = System.currentTimeMillis();
                break;
            case "insertion":
                t1 = System.currentTimeMillis();
                sortedArray = sortingService.insertionSort(sortRequest.getNumbers());
                t2 = System.currentTimeMillis();
                break;
            case "quick":
                t1 = System.currentTimeMillis();
                sortedArray = sortingService.qSort(sortRequest.getNumbers());
                t2 = System.currentTimeMillis();
                break;
            case "shell":
                t1 = System.currentTimeMillis();
                sortedArray = sortingService.shellSort(sortRequest.getNumbers());
                t2 = System.currentTimeMillis();
                break;
        }
        return new SortResponse(sortRequest.getNumbers(), sortedArray, t2 - t1);
    }

    @RequestMapping(value = "/merge", method = RequestMethod.POST)
    public MergeResponse mergeArrays(@RequestBody MergeRequest mergeRequest){
        return new MergeResponse(sortingService.mergeArrays(mergeRequest.getArrayOne(), mergeRequest.getArrayTwo()));
    }

}
