package ru.progwards.java1.lessons.arrays1;

public class Matrix {
    private int[][] dualArray;

    public Matrix(int[][] matrix) {
        dualArray = matrix;
    }

    public int maxInRow(int num) {
        int maxNum = Integer.MIN_VALUE; // почему бы не взять первое число в строке и сравнивать с ним?
        // Операций меньше гораздо.
        for (int i : dualArray[num]) {
            if (i > maxNum)
                maxNum = i;
        }
        return maxNum;
    }

    public int maxInCol(int num) {
        int maxNum = Integer.MIN_VALUE;
        for (int i = 0; i < dualArray.length; i++) {
            if (dualArray[i].length > num) {
                if (dualArray[i][num] > maxNum) {
                    maxNum = dualArray[i][num];
                }
            }
        }
        return maxNum;
    }

    public int max() {
        int maxNum = Integer.MIN_VALUE;
        for (int i = 0; i < dualArray.length; i++) {
            if (maxInRow(i) > maxNum) {
                maxNum = maxInRow(i);
            }
        }
        return maxNum;
    }

    public boolean isMatrix() {
        int len = dualArray[0].length;
        for (int i = 1; i < dualArray.length; i++) {
            if (dualArray[i].length != len) {
                return false;
            }
        }
        return true;
    }

    public int[][] transposition() {
        if (!isMatrix())
            return null;
        int[][] arr;
        arr = new int[dualArray[0].length][dualArray.length];
        for (int i = 0; i < dualArray.length; i++) {
            for (int j = 0; j < dualArray[i].length; j++) {
                arr[j][i] = dualArray[i][j];
            }
        }
        return arr;
    }

    public int[][] getDualArray() {
        return dualArray;
    }

    public static void printDualArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(" " + arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {6, 7, 8, 9, 10, 11, 12};
        int[] c = {4, 5};
        int[] d = {45, 6, 7, 8, 9};
        int[] e = {4, 5, 9, 10, 2};
        int[] f = {6, 7, 8, 9, 10};
        int[] g = {11, 12, 13, 14, 15};
        int[][] matr = {a, b, c};
        int[][] matr1 = {a, d, e};
        Matrix matr2 = new Matrix(matr1);
        Matrix newArr = new Matrix(matr);
        //printDualArray(newArr.getDualArray());
        //System.out.println(newArr.maxInRow(1));
        //System.out.println(newArr.maxInCol(5));
        //System.out.println(newArr.max());
        //System.out.println(newArr.isMatrix());
        printDualArray(matr2.getDualArray());
        System.out.println(matr2.isMatrix());
        printDualArray(matr2.transposition());
    }
}
