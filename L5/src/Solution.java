public class Solution {

    public String longestPalindrome (String s){
        if (s.length() == 1) return s;

        String sArray[] = s.split("");
        int startPoint = 0;
        int endPoint = 0;

        for (int i = 0; i < sArray.length; i++) {
            int tempEnd=0;

            if (sArray.length - i > endPoint - startPoint) {
                for (int j = sArray.length - 1; j > i; j--) {
                    if (sArray[i].equals(sArray[j]) && endPoint - startPoint < j - i) {
                        int s1=i;
                        int e=j;
                        while (s1<=e){
                            if (sArray[s1].equals(sArray[e])){
                                if (s1 == e || e-s1 == 1){
                                    startPoint = i;
                                    endPoint = j;
                                    break;
                                }
                                s1++;
                                e--;
                            } else break;
                        }
                    }

                }
            } else break;
        }

        if (startPoint == 0 && endPoint == 0) return sArray[0];

        s = sArray[startPoint];

        for (int i = startPoint+1; i <= endPoint; i++) {
            s += sArray[i];
        }

        return s;
    }
}
