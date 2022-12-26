public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.jump(new int[]{2,3,1,1,4}));
        System.out.println(solution.jump(new int[]{2,3,0,1,4}));
        System.out.println(solution.jump(new int[]{8,3,1,1,4}));
    }
}

class Solution {
    public int jump(int[] nums) {
        if (nums.length == 1) return 0;
        if (nums[0] == 0) return 0;
        if (nums[0] >= nums.length) return 1;

        int index = nums.length-1;
        int stepCount = 0;

        while (index > 0){
            int tempIndex = index;

            for (int i = index-1; i >= 0; i--) {
                if (nums[i] >= index - i){
                    tempIndex = i;
                }
            }

            if (tempIndex < index){
                index = tempIndex;
                stepCount++;
            } else {
                return 0;
            }
        }

        return stepCount;
    }
}