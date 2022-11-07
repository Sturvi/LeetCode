public class Main {
    public static void main(String[] args) {
        int a = 5;
        test(++a);
    }

    private static void test(int i) {
        i += 5 + i++;
        System.out.println(i);
    }
}