public class Main {
    public static void main(String[] args) {

        System.out.println(lengthOfLongestSubstring(""));
    }

    public static int lengthOfLongestSubstring(String s) {
        String[] mas=s.split("");
        int maxSum=0;
        if (mas.length==1 && mas[0].equals("")) return 1;
        int start=0;
        int end=1;
        int sum=1;
        while (end!=mas.length){
            boolean test=false;
            for (int i = start; i < end; i++) {
                if (mas[end].equals(mas[i])){
                    maxSum=(end-start)>maxSum?(end-start):maxSum;
                    start=i+1;
                    end=i+2;
                    test=true;
                    break;
                }
            }
            end=test?end:end+1;
            if (end==mas.length) maxSum=(end-start)>maxSum?(end-start):maxSum;
        }
        return maxSum;
    }
}