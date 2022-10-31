public class Main {
    public static void main(String[] args) {
        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }

    public static int maxArea(int[] height) {
        int i=0;
        int j=height.length-1;
        int maxSum=0;
        while (i<j){
            int sum=Math.min(height[i], height[j])*(j-i);
            maxSum=sum>maxSum?sum:maxSum;
            if (height[i]>height[j])
                j--;
            else
                i++;
        }
        return maxSum;
    }

    public static int trap(int[] height) {
        int start=0;
        int end=1;
        int maxSum=0;
        int sum=0;
        while (end< height.length-1){
            if (height[start]>height[end]){
                end++;
            }
            if (height[start]<=height[end]) {
                for (int i = start+1; i < end; i++) {
                    sum+=height[start]-height[i];
                }
                start=end;
                end++;
                maxSum+=sum;
                sum=0;
            }
            if (end== height.length-1){
                start++;
                end=start+1;
            }
        }
        return maxSum;
    }
}