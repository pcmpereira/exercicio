package com.altice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LabseqController {

    private Map<Integer, Integer> cache = new HashMap<>();

    @GetMapping("/labseq/{n}")
    public int getLabSeqValue(@PathVariable int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Número não pode ser negativo!");
        }

        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 0;
        } else if (n == 3) {
            return 1;
        }

        if (cache.containsKey(n)) {
            return cache.get(n);
        }

        int value = getLabSeqValue(n - 4) + getLabSeqValue(n - 3);
        cache.put(n, value);
        return value;
    }
}