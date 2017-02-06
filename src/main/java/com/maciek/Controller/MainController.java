package com.maciek.Controller;

import com.maciek.Request.SortRequest;
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
        long t1, t2;
        Integer[] sortedArray = new Integer[]{};
        t1 = System.currentTimeMillis();
        switch (sortRequest.getType()) {
            case "selection":
                sortedArray = sortingService.selectionSort(sortRequest.getSize(), sortRequest.getNumbers());
                break;
            case "bubble":
                sortedArray = sortingService.bubbleSort(sortRequest.getSize(), sortRequest.getNumbers());
                break;
            case "exchange":
                sortedArray = sortingService.exchangeSort(sortRequest.getSize(), sortRequest.getNumbers());
                break;
            case "insertion":
                sortedArray = sortingService.insertionSort(sortRequest.getSize(), sortRequest.getNumbers());
                break;
        }
        t2 = System.currentTimeMillis();
        return new SortResponse(sortRequest.getNumbers(), sortedArray, t2 - t1);
    }
}
