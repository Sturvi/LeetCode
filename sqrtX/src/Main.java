class Main {
    public static void main(String[] args) {
        System.out.println(mySqrt(0));
    }

    public static int mySqrt(int x) {
        if (x==0) return 0;
        long i=x;
        do {
            i = i / 2;
        } while (i*i>=x);
        while (i*i<=x){
            i++;
        }
        return (int) i-1;
    }
}