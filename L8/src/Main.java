import javax.print.CancelablePrintJob;

public class Main {
    public static void main(String[] args) {
String s="2147483646";
        //s=s.replaceAll("([^-\\d ])*", "").trim().replaceAll(" +-?[\\d]+", "");
        //System.out.println(s);
        System.out.println(myAtoi(s));

    }

    public static int myAtoi(String s) {
        s=s.trim();
        if (s.length()==0) return 0;
        if (s.length()==1 && !Character.isDigit(s.charAt(0))) return 0;
        int i=0;
        int sign=1;
        if (s.charAt(0)=='-' || s.charAt(0)=='+' ) {
            sign=s.charAt(0)=='-'?-1:1;
            i++;
        }
        int intS=0;
        int k=0;
        while (i<s.length()){
            if (Character.isDigit(s.charAt(i))){
                if (intS>(Integer.MAX_VALUE-(s.charAt(i) - '0')) / 10){
                    return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
                }
                intS=(intS*10)+s.charAt(i) - '0';
                i++;
            }
            else return intS*sign;
        }
        return intS*sign;
    }
}