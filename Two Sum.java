/*
1. Two Sum
---------------------------------------
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
 
Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?


Hasing Aproach time O(n) space O(n);
-------------------------------------------------------
public class Solution {
   public static int[]twoSum(int arr[], int target) {
		int res[] = new int[2];
		int n = arr.length;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=0; i<n; i++) {
			if (map.containsKey(target-arr[i])) {
				res[1] = i;
				res[0] = map.get(target-arr[i]);
				return res;
			}
			map.put(arr[i], i);
		}
		return res;
   }
}

*/

public class Solution {
   public static int[]twoSum(int arr[], int target) {
       int[] temp = new int[arr.length];
       for(int i =0;i<arr.length;i++){
        temp[i]=arr[i];
      }
      Arrays.sort(temp);
      int n = arr.length;
      int i=0;
      int j= n-1;
      while(i<j){
        if(temp[i]+temp[j]==target){
          break;
        }
        else if(temp[i]+temp[j] <target){
          i++;
        }
        else if(temp[i]+temp[j] >target){
          j--;
        }
      }
      int firstindex=-1;
      int secondindex=-1;
      for(int k=0;k<arr.length;k++){
        if(firstindex == -1 && arr[k]==temp[i]){
          firstindex=k;
        }
        else if(secondindex == -1 && arr[k]==temp[j]){
          secondindex=k;
        }
      }
      int ans [] = new int[2];
      ans [0]= firstindex;
      ans[1]=secondindex;
      return ans;
   }
}
