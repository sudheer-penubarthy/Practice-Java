package com.sudheer.leetcode;

import java.util.*;

/**
 * Class for Practice-Java project
 * Created by sudheer on 12/4/16.
 * https://leetcode.com/problems/two-sum/
 */
public class Assignment1 {
    public static void main(String[] args) {
        Assignment1 assignment1 = new Assignment1();
        Integer[] data = assignment1.generateData();
        long start = System.currentTimeMillis();
        assignment1.printResult(assignment1.twoSumApproach1(data, 121));
        System.out.println("time taken : " + (System.currentTimeMillis() - start));
        start = System.currentTimeMillis();
        assignment1.printResult(assignment1.twoSumApproach2(data, 121));
        System.out.println("time taken : " + (System.currentTimeMillis() - start));
    }

    private Integer[] generateData() {
        // Create an ordered list
        List<Integer> list = new ArrayList<Integer>();

        Random generator = new Random();
        for (int i = 1; i < 15000; i++) {
            list.add(generator.nextInt(100000));
        }

        // Shuffle it
        Collections.shuffle(list);

        // Get an Integer[] array
        return list.toArray(new Integer[list.size()]);
    }

    public int[] twoSumApproach1(Integer[] nums, int target) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int x = nums[i];
            for (int j = i + 1; j < length; j++) {
                int y = nums[j];
                if (x + y == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public int[] twoSumApproach2(Integer[] nums, int target) {
        int length = nums.length;
        HashMap<Integer, Integer> diffMap = new HashMap<Integer, Integer>(length);
        for (int i = 0; i < length; i++) {
            final int x = nums[i];
            int difference = target - x;
            if (diffMap.containsKey(x)) {
                return new int[]{i, diffMap.get(x)};
            } else {
                diffMap.put(difference, i);
            }
        }
        return null;
    }

    public void printResult(int[] result) {
        if (result != null) {
            System.out.println("Matching at (" + result[0] + ", " + result[1] + " )");
        } else {
            System.out.println("No match found");
        }

    }
}
