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
        Integer[] sortedArray = sortingService.bubbleSort(sortRequest.getSize(), sortRequest.getNumbers());
        return new SortResponse(sortRequest.getNumbers(), sortedArray);
    }
}