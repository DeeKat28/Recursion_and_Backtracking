package com.pep.recursion;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        // printIncreasing
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        printIncreasing(n);

        // printDecreasing
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        printDecreasing(n);

        // pdi
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        pdi(n);

        // pid
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        pid(n, 1);

        // power-linear
//        Scanner sc = new Scanner(System.in);
//        int x = sc.nextInt();
//        int n = sc.nextInt();
//        System.out.println(power(x, n));

        // power_log
//        Scanner sc = new Scanner (System.in);
//        int x = sc.nextInt();
//        int n = sc.nextInt();
//        System.out.println(power_log(x, n));

        // pzz
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        pzz(n);

        // toh
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int t1 = sc.nextInt();
//        int t2 = sc.nextInt();
//        int t3 = sc.nextInt();
//        toh(n, t1, t2, t3);
    }

    public static void printIncreasing(int n){
        if (n == 0) {
            return;
        }
        printIncreasing(n-1);
        System.out.println(n);
    }

    public static void printDecreasing(int n){
        if (n == 0) {
            return;
        }
        System.out.println(n);
        printDecreasing(n-1);
    }

    public static void pdi(int n){
        if (n == 0) {
            return;
        }
        System.out.println(n);
        pdi(n-1);
        System.out.println(n);
    }

    public static void pid(int n, int current_n){
        if (n < current_n) {
            return;
        }
        System.out.println(current_n);
        pid(n, current_n + 1);
        System.out.println(current_n);
    }

    public static int power(int x, int n){
        // base condition
        if (n == 0) {
            return 1;
        }

        // recursive call with change in params
        return x * power(x, n - 1);
    }

    public static int power_log(int x, int n){
        if (n == 0) {
            return 1;
        }

        int xtnb2 = power_log(x, n/2);
        int xtn = xtnb2 * xtnb2;

        if (n % 2 != 0) {
            xtn = xtn * x;
        }

        return xtn;
    }

    public static void pzz(int n){
        if (n == 0) {
            return;
        }

        System.out.print(n + " ");
        pzz(n-1);
        System.out.print(n + " ");
        pzz(n-1);
        System.out.print(n + " ");

    }

    public static void toh(int n, int t1id, int t2id, int t3id){

        if (n == 0) {
            return;
        }

        toh(n-1, t1id, t3id, t2id);

        System.out.println(n + "[" + t1id + " -> " + t2id + "]");

        toh(n - 1, t3id, t2id, t1id);

    }
}
