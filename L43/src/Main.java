import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.multiply("2", "3"));
        System.out.println(solution.multiply("123", "456"));
        System.out.println(solution.multiply("913555555555555555555555555555555555555555555555555544444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444555555555555555555553", "0"));
        System.out.println(solution.multiply("123456789", "987654321"));
        System.out.println(solution.multiply("1234523425645645645353456789", "984534563654635623563567654321"));
    }
}

class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")){
            return "0";
        }
        if (num1.equals("1")){
            return num2;
        }
        if (num2.equals("1")){
            return num1;
        }

        ArrayList<String> multiplicationResults = new ArrayList<>();

        for (int i = 0; i < num2.length(); i++) {
            multiplicationResults.add(intermediateMultiplication(num1, i, num2.charAt(num2.length() - i - 1) - '0'));
        }

        String result = "0";

        for (int i = 0; i < multiplicationResults.size(); i++) {
            result = sum (result, multiplicationResults.get(i));
        }

        return result;
    }

    private String sum(String num1, String num2) {
        int indexNum1 = num1.length()-1;
        int indexNum2 = num2.length()-1;
        int inMemory = 0;
        StringBuilder result = new StringBuilder();

        while (indexNum1 >=0 || indexNum2 >= 0 || inMemory > 0) {
            int fistNumber = indexNum1 >= 0 ? num1.charAt(indexNum1) - '0' : 0;
            int secondNumber = indexNum2 >= 0 ? num2.charAt(indexNum2) - '0' : 0;

            int tempSum = fistNumber + secondNumber + inMemory;
            result.append(tempSum % 10);
            inMemory = tempSum / 10;

            indexNum1--;
            indexNum2--;
        }

        return result.reverse().toString();
    }

    private String intermediateMultiplication(String num1, int numberOfZeros, int num2) {
        int inMemory = 0;
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < numberOfZeros; i++) {
            result.append("0");
        }

        for (int i = num1.length()-1; i >= 0 ; i--) {
            int temp = ((num1.charAt(i) - '0') * num2) + inMemory;
            result.append(temp % 10);
            inMemory = temp / 10;
        }

        if (inMemory > 0)
            result.append(inMemory);

        return result.reverse().toString();
    }
}