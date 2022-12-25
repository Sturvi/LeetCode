public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.multiply("2", "3"));
        System.out.println(solution.multiply("123", "456"));
    }
}


class Solution {
    public String multiply(String num1, String num2) {
        int indexNum1 = num1.length()-1;
        int indexNum2 = num2.length()-1;
        int inMemory = 0;
        StringBuilder result = new StringBuilder();

        while (indexNum1 >=0 || indexNum2 >= 0 || inMemory > 0) {
            int fistNumber = indexNum1 >= 0 ? num1.charAt(indexNum1) - '0' : 0;
            int secondNumber = indexNum2 >= 0 ? num2.charAt(indexNum2) - '0' : 0;

            int tempSum = fistNumber * secondNumber + inMemory;
            result.append(tempSum % 10);
            inMemory = tempSum / 10;

            indexNum1--;
            indexNum2--;
        }

        return result.reverse().toString();
    }
}