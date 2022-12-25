public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.addBinary("1010", "1011"));
    }
}

class Solution {
    public String addBinary(String a, String b) {
        String [] aArray = a.split("");
        String [] bArray = b.split("");
        int indexA = aArray.length - 1;
        int indexB = bArray.length - 1;
        int inMemory = 0;
        StringBuilder result = new StringBuilder();

        while (indexA >= 0 || indexB >= 0){
            int temp;
            if (indexA>= 0 && indexB >= 0) {
                temp = Integer.parseInt(aArray[indexA], 2) + Integer.parseInt(bArray[indexB], 2) + inMemory;
            } else if (indexA >= 0 && indexB < 0) {
                temp = Integer.parseInt(aArray[indexA], 2) + inMemory;
            } else {
                temp = Integer.parseInt(bArray[indexB], 2) + inMemory;
            }

            switch (temp){
                case (0):
                    result.append(temp);
                    break;
                case (1):
                    result.append(temp);
                    inMemory = 0;
                    break;
                case (2):
                    result.append(0);
                    inMemory = 1;
                    break;
                case (3):
                    result.append(1);
                    inMemory = 1;
                    break;
            }
            indexA--;
            indexB--;
        }
        if (inMemory == 1){
            result.append(inMemory);
        }
        return result.reverse().toString();
    }
}