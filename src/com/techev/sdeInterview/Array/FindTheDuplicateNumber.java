package com.techev.sdeInterview.Array;

import java.util.HashSet;
import java.util.Set;

/*
 * 287. Find the Duplicate Number
 * https://leetcode.com/problems/find-the-duplicate-number/
 * 
 */
public class FindTheDuplicateNumber {

	public int findDuplicate(int[] nums) {
		// return findDuplicateUsingSet(nums);
		return findDuplicateUsingFloydTortoiseAndHare(nums);
	}

	private int findDuplicateUsingFloydTortoiseAndHare(int[] nums) {
		// This is similar to https://leetcode.com/problems/linked-list-cycle-ii/
		// Time complexity :- O(n)
		// Space complexity :- O(1)
		if (nums.length < 1)
			return -1;

		int slow = nums[0];
		int fast = nums[nums[0]];

		while (slow != fast) {
			slow = nums[slow];
			fast = nums[nums[fast]];
		}

		fast = 0;
		while (fast != slow) {
			fast = nums[fast];
			slow = nums[slow];
		}

		return fast;
	}

	private int findDuplicateUsingSet(int[] nums) {

		// Time complexity :- O(n)
		// Space complexity :- O(n)

		Set<Integer> seen = new HashSet<Integer>();

		for (int number : nums) {
			if (seen.contains(number))
				return number;
			else
				seen.add(number);
		}

		return -1;
	}

	public static void main(String[] args) {
		int input[] = { 1, 3, 4, 2, 2 };
		int input1[] = { 3, 1, 3, 4, 2 };

		FindTheDuplicateNumber duplicateItem = new FindTheDuplicateNumber();
		System.out.println(duplicateItem.findDuplicate(input));
		System.out.println(duplicateItem.findDuplicate(input1));

	}

}
