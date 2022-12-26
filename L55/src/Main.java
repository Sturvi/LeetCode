public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(solution.canJump(new int[]{3, 2, 1, 0, 4}));
        System.out.println(solution.canJump(new int[]{2, 0}));
        System.out.println(solution.canJump(new int[]{1,0,1,0}));
        System.out.println(solution.canJump(new int[]{2, 5, 0, 0, 1, 3, 0, 0, 1}));
        System.out.println(solution.canJump(new int[]{2, 5, 0, 0, 1, 2, 0, 0, 1}));
    }
}

class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) return true;
        if (nums[0] == 0) return false;
        int index = nums.length - 1;

        int tempIndex = index - 1;
        int needStep = 1;

        while (index > 0 && tempIndex >= 0) {
            if (nums[tempIndex] >= needStep) {
                index = tempIndex;
                tempIndex--;
                needStep = 1;
                continue;
            }
            tempIndex--;
            needStep++;
            if (tempIndex < 0) return false;
        }

        return true;
    }
}