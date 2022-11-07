public class Main {
    public static void main(String[] args) {
        int end = 10;
        boolean test = false;
        end=test?end:++end;
        System.out.println(end);
        int end2 = 10;
        end2=test?end2:end2+1;
        System.out.println(end2);
    }
}