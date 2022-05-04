package com.katas.fibonacciRecursive;

public class RecursiveFibonacciGenerator {

    //Not my solution
    public int generateFromElement(int n) {
        if (n <= 1)
            return n;
        return generateFromElement(n-1) + generateFromElement(n-2);
    }

}
