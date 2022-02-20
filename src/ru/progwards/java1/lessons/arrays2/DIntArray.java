package ru.progwards.java1.lessons.arrays2;

import java.util.Arrays;

public class DIntArray {
    private int[] nums;

    public DIntArray() {
        //nums = new int[0];
    }

    public void add(int num) {
        if (nums == null) {
            int[] numsNew = new int[1];
            numsNew[0] = num;
            nums = numsNew;
        }
        else {
            int[] numsNew = new int[nums.length + 1];
            System.arraycopy(nums, 0, numsNew, 0, nums.length);
            numsNew[nums.length] = num;
            nums = numsNew;
        }
    }

    public void atInsert(int pos, int num) {
        if (nums == null) {
            int[] numsNew = new int[1];
            numsNew[0] = num;
            nums = numsNew;
        }
        else if (nums.length - 1 < pos) {
            int[] numsNew = new int[nums.length + 1];
            System.arraycopy(nums, 0, numsNew, 0, nums.length);
            numsNew[nums.length] = num;
            nums = numsNew;
        } else {
            int[] numsNew = new int[nums.length + 1];
            System.arraycopy(nums, 0, numsNew, 0, pos);
            numsNew[pos] = num;
            System.arraycopy(nums, pos, numsNew, pos + 1, nums.length - pos);
            nums = numsNew;
        }

    }

    public void atDelete(int pos) {
        int[] numsNew = new int[nums.length - 1];
        if (nums.length - 1 < pos) {
            System.arraycopy(nums, 0, numsNew, 0, nums.length - 1);
        } else {
            System.arraycopy(nums, 0, numsNew, 0, pos);
            System.arraycopy(nums, pos + 1, numsNew, pos, nums.length - pos - 1);
        }
        nums = numsNew;
    }

    public int at(int pos) {
        if (nums.length - 1 < pos) {
            return Integer.MIN_VALUE;
        }
        return nums[pos];
    }

    public static void main(String[] args) {
        DIntArray arr = new DIntArray();
        arr.add(5);
        arr.add(3);
        arr.add(2);
        arr.add(1);
        arr.add(4);
        System.out.println(Arrays.toString(arr.nums));
        arr.atInsert(1, 0);
        System.out.println(Arrays.toString(arr.nums));
        arr.atDelete(4);
        System.out.println(Arrays.toString(arr.nums));
        System.out.println(arr.at(5));
    }
}
