public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}

class Solution {
    public int removeDuplicates(int[] nums) {
        for (int i = 1; i < nums.length-1; i++) {
            if (nums[i] == nums[i-1])
                nums[i] = nums[i+1];
        }
        return nums[0];
    }
}