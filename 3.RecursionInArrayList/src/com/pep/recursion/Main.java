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
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        ArrayList<String> paths = getStairPaths(n);
//        System.out.println(paths);

        // getMazePaths
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//        ArrayList<String> mazePaths = getMazePaths(0, 0, n-1, m-1);
//        System.out.println(mazePaths);

        // getMazePathsWithJumps
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<String> mazePaths = getMazePathsWithJumps(0, 0, n-1, m-1);
        System.out.println(mazePaths);

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

    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
        if (sc == dc && sr == dr) {
            ArrayList<String> path = new ArrayList<String>();
            path.add("");
            return path;
        } else if (sc > dc || sr > dr) {
            return new ArrayList<String>();
        }

        ArrayList<String> paths = new ArrayList<String>();

        ArrayList<String> hMoves = getMazePaths(sr, sc + 1, dr, dc);
        for (String path : hMoves) {
            paths.add("h" + path);
        }
        ArrayList<String> vMoves = getMazePaths(sr + 1, sc, dr, dc);
        for (String path : vMoves) {
            paths.add("v" + path);
        }

        return paths;
    }

    public static ArrayList<String> getMazePathsWithJumps(int sr, int sc, int dr, int dc) {

        if (sc == dc && sr == dr) {
            ArrayList<String> path = new ArrayList<String>();
            path.add("");
            return path;
        } else if (sc > dc || sr > dr) {
            return new ArrayList<String>();
        }

        ArrayList<String> paths = new ArrayList<String>();

        int  step = 1;
        int limit = Math.max(dc, dr);
        while (step <= limit) {
            ArrayList<String> hMoves = getMazePathsWithJumps(sr, sc + step, dr, dc);
            ArrayList<String> vMoves = getMazePathsWithJumps(sr + step, sc, dr, dc);
            ArrayList<String> dMoves = getMazePathsWithJumps(sr + step, sc + step, dr, dc);

            for (String s: hMoves)
                paths.add("h" + step + s);
            for (String s: vMoves)
                paths.add("v" + step  + s);
            for (String s: dMoves)
                paths.add("d" + step  + s);

            step++;
        }

        return paths;
    }
}
