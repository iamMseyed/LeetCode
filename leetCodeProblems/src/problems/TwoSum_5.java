/*
1. Two Sum
Solved
Easy
Topics
Companies
Hint

Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.
Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]

Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]

 

Constraints:

    2 <= nums.length <= 104
    -109 <= nums[i] <= 109
    -109 <= target <= 109
    Only one valid answer exists.

*/
import java.util.Scanner;
class Solution {
    public int[] twoSum(int[] nums, int target) {    
    	int size = nums.length;
    	int[] found= new int[2];
        for(int i=0;i<size-1;i++) {
        	for(int j = i+1;j<size;j++) {
        		if(nums[i]+nums[j] == target) {
        			found[0]=i;
        			found[1]=j;
        			break;
        		}
        	}
        }
        return found;
    }
}

public class TwoSum_5{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter size of the array:");
        int size = s.nextInt();
        if(size<2 || size>10000) {
        	System.err.println("Size valid from 2 to 10000 only");
        	System.exit(0);
        }
        
        int[] arr = new int[size];
        
        System.out.println("Enter "+(size)+ " elements: ");
        for(int i=0;i<size;i++) {
        	System.out.println("Element at "+(i+1) +" place: ");
        	arr[i]= s.nextInt();
        }

        System.out.println("Enter target int to count from array: ");
        int target = s.nextInt();
        
        int[] found = new Solution().twoSum(arr, target);
        int a = found[0];
        int b = found[1];
        if(a!=0 && b!=0) 
        	System.out.println("["+a+","+b+"]");
        else
        	System.err.println("No combination found to match the target!");
        
        s.close();
    }
}
