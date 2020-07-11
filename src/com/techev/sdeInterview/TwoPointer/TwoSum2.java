package com.techev.sdeInterview.TwoPointer;

public class TwoSum2 {
	public int[] twoSum(int[] numbers, int target) {

		// Two Pointer Approach
		int left = 0;
		int right = numbers.length - 1;

		while (left < right) {
			int sum = numbers[left] + numbers[right];
			if (sum == target)
				return new int[] { left + 1, right + 1 };
			else if (sum > target) {
				right--;
			} else
				left++;
		}

		throw new IllegalArgumentException("No solution");
	}
}
