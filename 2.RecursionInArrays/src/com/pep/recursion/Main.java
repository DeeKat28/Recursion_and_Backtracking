package com.pep.recursion;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // printIncreasing
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        printIncreasing(arr, 0);
        System.out.println();
        printDecreasing(arr, 0);
        System.out.println();
        System.out.println(maxArray(arr, 0));

        int d = sc.nextInt();
        System.out.println(firstIndex(arr, 0, d));
        System.out.println(lastIndex(arr, arr.length - 1, d));

        for (int x: allIndices(arr, d, 0, 0)){
            System.out.println(x);
        }
    }

    public static void printIncreasing(int[] arr, int index) {

        if (index == arr.length) {
            return;
        }
        System.out.print(arr[index] + " ");
        printIncreasing(arr, index + 1);

    }

    public static void printDecreasing(int[] arr, int index) {

        if (index == arr.length) {
            return;
        }

        printDecreasing(arr, index + 1);
        System.out.print(arr[index] + " ");

    }

    public static int maxArray(int[] arr, int index) {

        if (index == arr.length) {
            return Integer.MIN_VALUE;
        }

        return Math.max(arr[index], maxArray(arr, index + 1));

    }

    public static int firstIndex(int[] arr, int index, int d) {

        if (index == arr.length) {
            return -1;
        }

        if (arr[index] == d) {
            return index;
        }

        return firstIndex(arr, index + 1, d);

    }

    public static int lastIndex(int[] arr, int index, int d) {

        if (index < 0) {
            return -1;
        }

        if (arr[index] == d) {
            return index;
        }

        return lastIndex(arr, index - 1, d);

    }

    public static int[] allIndices(int[] arr, int x, int index, int counter) {

        if (index == arr.length) {
            return new int[counter];
        }

        if (arr[index] == x) {
            counter++;
        }

        int[] indices = allIndices(arr, x, index + 1, counter);

        if (arr[index] == x) {
            indices[counter - 1] = index;
        }

        return indices;
    }
}
