import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.addToArrayForm(new int[]{1, 2, 0, 0}, 34));
        System.out.println(solution.addToArrayForm(new int[]{2, 7, 4}, 181));
        System.out.println(solution.addToArrayForm(new int[]{2, 1, 5}, 806));
        System.out.println(solution.addToArrayForm(new int[]{1}, 35));
        System.out.println(solution.addToArrayForm(new int[]{0}, 35));
        System.out.println(solution.addToArrayForm(new int[]{0}, 1000));
    }
}

class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> results = new ArrayList<>();

        int inMemory = 0;

        for (int i = num.length - 1; i >= 0; i--) {
            int temp = num[i] + (k % 10) + inMemory;
            results.add(temp % 10);
            inMemory = temp / 10;
            k /= 10;
        }

        if (k > 0)
            inMemory += k;

        if (inMemory > 0 && inMemory < 10)
            results.add(inMemory);
        else if (inMemory > 0){
            while (inMemory > 0) {
                results.add(inMemory % 10);
                inMemory /= 10;
            }
        }

        Collections.reverse(results);
        return results;
    }
}