import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.plusOne(new int[] {1,2,3})));
        System.out.println(Arrays.toString(solution.plusOne(new int[] {4,3,2,1})));
        System.out.println(Arrays.toString(solution.plusOne(new int[] {4,3,9,9})));
        System.out.println(Arrays.toString(solution.plusOne(new int[] {9})));
    }
}

class Solution {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length-1; i >= 0; i--) {
            digits[i]++;
            if (digits[i]<10)
                return digits;
            else {
                digits[i]=0;
            }
        }

        int[] digits2 = new int[digits.length+1];
        digits2[0] = 1;
        for (int i = 1; i < digits2.length; i++) {
            digits2[i] = digits[i-1];
        }

        return digits2;
    }
}