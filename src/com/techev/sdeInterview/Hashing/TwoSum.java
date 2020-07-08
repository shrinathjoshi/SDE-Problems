package com.techev.sdeInterview.Hashing;

import java.util.HashMap;

public class TwoSum {

	public int[] twoSum(int[] nums, int target) {

		// return bruteForceApproach(nums, target);
		return optimizedTwoSum(nums, target);
	}

	private int[] optimizedTwoSum(int[] nums, int target) {

		// Time complexity :- O(n)
		// Space complexity :- O(n)

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if (map.containsKey(complement) && map.get(complement) != i) {
				return new int[] { map.get(complement), i };
			} else {
				map.put(nums[i], i);
			}
		}

		throw new IllegalArgumentException("No two Sum solution");
	}

	private int[] bruteForceApproach(int[] nums, int target) {
		// Time Complexity :- O(n2)
		// Space Complexity :- O(1)

		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] == target - nums[i]) {
					return new int[] { i, j };
				}
			}
		}
		throw new IllegalArgumentException("No two Sum solution");

	}

	public static void main(String[] args) {
		int nums[] = { 2, 7, 11, 15 }, target = 9;
		TwoSum twoSum = new TwoSum();
		int result[] = twoSum.twoSum(nums, target);
		printResult(result);
	}

	private static void printResult(int[] result) {
		for (int res : result)
			System.out.print(res + " ");
	}
}
