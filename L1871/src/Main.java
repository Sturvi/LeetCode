import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canReach("011010", 2, 3));
        System.out.println(solution.canReach("0110111110", 2, 3));
        System.out.println(solution.canReach("011101101110", 3, 4));

        try (Scanner scanner = new Scanner(new FileInputStream("L1871/src/test"));) {
            System.out.println(solution.canReach(scanner.nextLine(), 1, 49999));
            System.out.println(solution.canReach(scanner.nextLine(), 1, 50000));
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        }

    }
}

class Solution2 {
    boolean endFound;
    public boolean canReach(String s, int minJump, int maxJump) {
        if ((s.charAt(s.length()-1) - '0') == 1) return false;

        int count = 0;
        for (int i = 1; i < s.length(); i++) {
            if ((s.charAt(i) - '0') == 1) {
                count++;
            } else {
                count = 0;
            }
            if (maxJump-count > s.length() - i)
                break;
            if (count == maxJump)
                return false;
        }

        boolean [] beenHereBefore = new boolean[s.length()];
        beenHereBefore[0] = true;
        int maxZeroIndex = 0;

        for (int i = 0; i < beenHereBefore.length; i++) {
            boolean check = false;
            if (s.charAt(i) - '0' == 1)
                continue;

            if (beenHereBefore[i] && i + minJump < beenHereBefore.length){
                for (int j = Math.min(i + maxJump, beenHereBefore.length-1); j >= i + minJump; j--) {
                    if (!beenHereBefore[j] && s.charAt(j) - '0' == 0){
                        beenHereBefore [j] = true;
                        maxZeroIndex = Math.max(j, maxZeroIndex);
                    } else if (beenHereBefore[j]) {
                        break;
                    }
                }
            }
            if (beenHereBefore[beenHereBefore.length-1])
                return true;
            if (i >= maxZeroIndex)
                return false;
        }

        return false;
    }
}

class Solution  {
    public boolean canReach  (String s, int minJump, int maxJump) {
        int l = s.length();
        if(s.charAt(l-1) == '1')
            return false;
        boolean [] dp = new boolean [l];
        int cZeroCount = 0;
        dp[l-1] = true;
        int c = 1;
        for(int i = l-minJump-1 ;i>=0;i--){
            if(s.charAt(i) == '0' && c > 0)
                dp[i] = true;

            if(dp[i+minJump-1])
                c++;
            if(i+maxJump < l && dp[i+maxJump] == true)
                c--;
            if (c == 0){
                cZeroCount++;
            } else {
                cZeroCount = 0;
            }
            if (cZeroCount == maxJump)
                return dp[0];
        }
        return dp[0];
    }
}

class Solution3 {
    boolean endFound;
    public boolean canReach(String s, int minJump, int maxJump) {
        if ((s.charAt(s.length()-1) - '0') == 1) return false;

        int count = 0;
        for (int i = 1; i < s.length(); i++) {
            if ((s.charAt(i) - '0') == 1) {
                count++;
            } else {
                count = 0;
            }
            if (maxJump-count > s.length() - i)
                break;
            if (count == maxJump)
                return false;
        }


        String sArray [] = s.split("");
        boolean beenHereBefore [] = new boolean[sArray.length];
        beenHereBefore[0] = true;
        endFound = false;

        if (sArray [sArray.length-1].equals("1")) return false;

        findTheWay (sArray, 0, minJump, maxJump, beenHereBefore);

        return endFound;
    }

    private void findTheWay(String[] sArray, int index, int minJump, int maxJump, boolean[] beenHereBefore) {
        if (sArray.length - 1 - index >= minJump && sArray.length - 1 - index <= maxJump){
            endFound = true;
            return;
        }

        for (int i = maxJump; i >= minJump; i--) {
            if (endFound) return;
            if (index + i < sArray.length - 1 && !beenHereBefore[index + i] && !sArray[index+i].equals("1")){
                beenHereBefore[index + i] = true;
                findTheWay(sArray, index + i, minJump, maxJump, beenHereBefore);
            }
        }

    }
}