class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;

        String number = String.valueOf(x);

        int j = number.length()-1;
        int i = 0;

        while (i < j){
            if (number.charAt(i) != number.charAt(j)) return false;
            ++i;
            --j;
        }
        return true;
    }
}