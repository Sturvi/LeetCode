class Main {
    public int[] twoSum(int[] nums, int target) {
        int[] f = new int[2];

        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i]+nums[j]==target) {
                    f[0]=i;
                    f[1]=j;
                    return f;
                }
            }
        }
        return f;

    }

    public int[] twoSum(int[] numbers, int target) {
        int[] f = new int[2];
        int i=0, j= numbers.length-1;
        while (i<=j){
            if (numbers[i]+numbers[j]>target){
                j--;
            } else if (numbers[i]+numbers[j]<target) {
                i++;
            } else {
                f[0]=i+1;
                f[1]=j+1;
                return f;
            }
        }
        return f;
    }
}