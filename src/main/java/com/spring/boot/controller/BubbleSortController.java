package com.spring.boot.controller;

import com.sort.bubble.BubbleSort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BubbleSortController {
    @RequestMapping("/bubble")
    public int[] bubbleSort(@RequestParam ("items") int[] items) {
        return new BubbleSort(items).sort();
    }
}
