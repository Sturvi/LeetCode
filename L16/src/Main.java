import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.threeSumClosest(new int[]{0, 3, 97, 102, 200}, 300));
    }
}

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length == 3) return nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);

        Integer temporarySum = nums[0] + nums[1] + nums[nums.length-1];


        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1;
            int end = nums.length - 1;

            if (i>0 && nums[i] == nums[i-1]) continue;

            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (sum > target) {
                    --end;
                    temporarySum = Math.abs(target - sum) < Math.abs(target - temporarySum) ? sum : temporarySum;
                } else if (sum < target) {
                    ++start;
                    temporarySum = Math.abs(target - sum) < Math.abs(target - temporarySum) ? sum : temporarySum;
                } else return sum;
            }
        }
        return temporarySum;
    }
}

