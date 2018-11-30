package fibonacci.timer;

import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class FibonacciTimer {

    public static void main(String[] args) {

        long startTime;
        long endTime;
        long duration;
        int nthNumber;
        Scanner input = new Scanner(System.in);
        
        System.out.print("Nth number: ");
        nthNumber = Integer.parseInt(input.nextLine());
        System.out.println("Result: " + fibonacciDynamicOptimized(nthNumber) + "\n");

        startTime = System.nanoTime();
        fibonacciRecursive(nthNumber);
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        System.out.println("Top to bottom, recursive method time: " + duration + " nanoseconds");

        startTime = System.nanoTime();
        fibonacciRecursiveMemoization(nthNumber);
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        System.out.println("Top to bottom, recursive memoized method time: " + duration + " nanoseconds");

        startTime = System.nanoTime();
        fibonacciDynamic(nthNumber);
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        System.out.println("Bottom to top, dynamic method time: " + duration + " nanoseconds");

        startTime = System.nanoTime();
        fibonacciDynamicOptimized(nthNumber);
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        System.out.println("Bottom to top, dynamic optimized time: " + duration + " nanoseconds");
    }

    static int fibonacciRecursive(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    static int fibonacciRecursiveMemoization(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        if (map.containsKey(n)) {
            return map.get(n);
        }
        if (n == 0 || n == 1) {
            return n;
        }
        map.put(n, fibonacciRecursiveMemoization(n - 1) + fibonacciRecursiveMemoization(n - 2));
        return fibonacciRecursiveMemoization(n - 1) + fibonacciRecursiveMemoization(n - 2);
    }

    static int fibonacciDynamic(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        map.put(1, 1);
        for (int i = 2; i <= n; i++) {
            map.put(i, map.get(i - 1) + map.get(i - 2));
        }
        return map.get(n);
    }

    static int fibonacciDynamicOptimized(int n) {
        int a = 0;
        int b = 1;
        int fibonacci = 0;
        if (n == 0 || n == 1) {
            return n;
        }
        for (int i = 2; i <= n; i++) {
            fibonacci = a + b;
            a = b;
            b = fibonacci;
        }
        return fibonacci;
    }
    
}
