public class Main {
    public static void main(String[] args) {
        int x = 1534236469;

        System.out.println(reverse(x));


    }

    public static int reverse(int x) {
        String str = String.valueOf(x);
        if (str.charAt(0) == '-') {
            str = str.replaceAll("-", "");
            String temp = new StringBuilder(str).reverse().toString();
            str = "-" + temp;
        } else {
            String temp = new StringBuilder(str).reverse().toString();
            str = temp;
        }
        long temp = Long.parseLong(str);
        if (temp == (int) temp)
            return (int) temp;
        return 0;
    }
}