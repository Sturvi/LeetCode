import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}

class Solution {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        Integer j = null;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                j = 1;
                continue;
            }
            if (j == null && nums[i]>0) return 1;
            if (j != null && j==nums[i]) continue;

            if (j != null && j + 1 != nums[i]) return j + 1;
            else if (j!=null) j++;
        }

        return j == null ? 1 : ++j;

    }
}