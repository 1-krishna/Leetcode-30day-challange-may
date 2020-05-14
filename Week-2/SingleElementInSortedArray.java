/*
You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once. Find this single element that appears only once.

 

Example 1:

Input: [1,1,2,3,3,4,4,8,8]
Output: 2
Example 2:

Input: [3,3,7,7,10,11,11]
Output: 10
 

Note: Your solution should run in O(log n) time and O(1) space.
 */

class Solution {
    public int singleNonDuplicate(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        if(nums[nums.length-1] != nums[nums.length-2])
            return nums[nums.length-1];
        if(nums[0] != nums[1])
            return nums[0];
        int low = 0;
        int high = nums.length-1;
        int mid;
        while(low<high){
            mid = (low+high)/2;
            if(mid-1 < 0 || mid+1 >= nums.length)
                return nums[mid];
            if(nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1])
                return nums[mid];
            if(nums[mid] == nums[mid-1] && (mid)%2 == 0)
                high = mid;
            if(nums[mid] == nums[mid-1] && (mid)%2 != 0)
                low = mid;
            if(nums[mid] == nums[mid+1] && (mid)%2 == 0)
                low = mid;
            if(nums[mid] == nums[mid+1] && (mid)%2 != 0)
                high = mid;
        }
        return -1;
    }
}