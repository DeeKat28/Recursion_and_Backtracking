package com.pep.recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        // gss
//        Scanner sc = new Scanner(System.in);
//        String str = sc.nextLine();
//        ArrayList<String> subSequences = gss(str);
//        System.out.println(subSequences);

        // getKPC
//        Scanner sc = new Scanner(System.in);
//        String str = sc.nextLine();
//        ArrayList<String> kpc = getKPC(str);
//        System.out.println(kpc);

        // getStairPaths
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<String> paths = getStairPaths(n);
        System.out.println(paths);
    }

    public static ArrayList<String> gss(String str) {

        if (str.length() == 0) {
            ArrayList<String> ss = new ArrayList<String>();
            ss.add("");
            return ss;
        }


        ArrayList<String> al = gss(str.substring(1));

        ArrayList<String> subSequences = new ArrayList<String>();

        for (String s: al) {
            subSequences.add(s);
        }

        for (String s: al) {
            subSequences.add(str.charAt(0) + s);
        }

        return subSequences;
    }

    static String[] keypad = {".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};

    public static ArrayList<String> getKPC(String str) {

        if (str.length() == 0) {
            ArrayList<String> kpc = new ArrayList<String>();
            kpc.add("");
            return kpc;
        }

        ArrayList<String> al = getKPC(str.substring(1));

        ArrayList<String> kpc = new ArrayList<String>();

        for (String s: al) {
            for (int i = 0; i < keypad[str.charAt(0) - '0'].length(); i++) {
                kpc.add(keypad[str.charAt(0) - '0'].charAt(i) + s);
            }
        }
        return kpc;
    }

    public static ArrayList<String> getStairPaths(int n) {

        if (n == 0) {
            ArrayList<String> al = new ArrayList<String>();
            al.add("");
            return al;
        }

        if (n < 0) {
            ArrayList<String> al = new ArrayList<String>();
            return al;
        }

        ArrayList<String> al1 = getStairPaths(n-1);
        ArrayList<String> al2 = getStairPaths(n-2);
        ArrayList<String> al3 = getStairPaths(n-3);

        ArrayList<String> paths = new ArrayList<String>();

        for (String s1: al1) {
            paths.add(1 + s1);
        }
        for (String s2: al2) {
            paths.add(2 + s2);
        }
        for (String s3: al3) {
            paths.add(3 + s3);
        }

        return paths;
    }
}
