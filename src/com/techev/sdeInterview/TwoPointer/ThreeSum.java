package com.techev.sdeInterview.TwoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/*
 * Problem Link :-https://leetcode.com/problems/3sum/
 * 
 * 
 */
public class ThreeSum {

	public List<List<Integer>> threeSum(int[] nums) {

		Random random = new Random();
		float probability = random.nextFloat();
		if (probability > 0.5)
			return threeSumUsingTwoPointerApproach(nums);
		else
			return threeSumUsingSetAndTwoPointerApproach(nums);
	}

	private List<List<Integer>> threeSumUsingSetAndTwoPointerApproach(int[] nums) {
		// Time complexity :- O(n2)
		// Space complexity :- O(n)

		Set<List<Integer>> set = new HashSet<>();
		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 2; i++) {

			int left = i + 1;
			int right = nums.length - 1;

			while (left < right) {
				int sum = nums[left] + nums[right] + nums[i];
				if (sum == 0) {
					set.add(Arrays.asList(nums[i], nums[left++], nums[right--]));

				} else if (sum > 0) {
					right--;
				} else
					left++;
			}

		}

		return new ArrayList<>(set);
	}

	private List<List<Integer>> threeSumUsingTwoPointerApproach(int[] nums) {
		// Time complexity :- O(n2)
		// Space complexity :- O(n) (based on Sorting Algorithm)

		List<List<Integer>> result = new ArrayList<List<Integer>>();

		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 2; i++) {

			if (i > 0 && nums[i] == nums[i - 1])
				continue;

			int target = -nums[i];
			int left = i + 1;
			int right = nums.length - 1;

			while (left < right) {
				if (nums[left] + nums[right] == target) {
					result.add(Arrays.asList(nums[i], nums[left++], nums[right--]));
					while (left < nums.length && nums[left] == nums[left - 1])
						left++;
					while (right >= 0 && nums[right] == nums[right + 1])
						right--;

				} else if (nums[left] + nums[right] > target) {
					right--;
				} else
					left++;
			}

		}

		return result;
	}

	public static void main(String[] args) {
		int nums[] = { -1, 0, 1, 5, -1, -4 };

		// int nums[] = { 0, 0, 0 };

		ThreeSum threeSum = new ThreeSum();
		List<List<Integer>> result = threeSum.threeSum(nums);
		System.out.println(result);
	}

}
