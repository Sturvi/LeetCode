public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestCommonPrefix(new String[]{"sdfsdfc","sdfsdfc","sdfsdfc"}));
    }
}

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1)
            return strs[0];

        String[] firstWord = strs[0].split("");

        String longestPrefix = "";

        int index = 0;
        String tempPrefix = firstWord[index];
        boolean test = true;
        String prefix = "";

        while (test) {
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].indexOf(tempPrefix) != 0) {
                    test = false;
                    break;
                }
            }

            if ((index == firstWord.length-1) && test){
                if (longestPrefix.length() < tempPrefix.length()) {
                    longestPrefix = tempPrefix;
                }
                break;
            }

            if (test) {
                prefix = tempPrefix;
                tempPrefix += firstWord[index+1];
                index++;
            }

            if (!test){
                if (longestPrefix.length() < tempPrefix.length()) {
                    longestPrefix = prefix;
                }
                break;
            }

        }
        return longestPrefix;
    }
}
