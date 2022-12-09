import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.letterCombinations("23"));
    }
}

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> temp = new ArrayList<String>();

        if (digits.length() == 0)
            return new ArrayList<String>();

        String[] digitsArray = digits.split("");
        List<String> list = nextNumberList(digitsArray[0]);

        for (int i = 1; i < digitsArray.length; i++) {
            List<String> nextNumberList = nextNumberList(digitsArray[i]);
            for (int j = 0; j < list.size(); j++) {
                for (int k = 0; k < nextNumberList.size(); k++) {
                    temp.add(list.get(j) + nextNumberList.get(k));
                }
            }
            list=new ArrayList<>(temp);
            temp.clear();
        }
        return list;
    }

    private List<String> nextNumberList (String number){
        switch (number){
            case ("2"):
                return new ArrayList<String> (Arrays.asList("a", "b", "c"));
            case ("3"):
                return new ArrayList<String> (Arrays.asList("d", "e", "f"));
            case ("4"):
                return new ArrayList<String> (Arrays.asList("g", "h", "i"));
            case ("5"):
                return new ArrayList<String> (Arrays.asList("j", "k", "l"));
            case ("6"):
                return new ArrayList<String> (Arrays.asList("m", "n", "o"));
            case ("7"):
                return new ArrayList<String> (Arrays.asList("p", "q", "r", "s"));
            case ("8"):
                return new ArrayList<String> (Arrays.asList("t", "u", "v"));
            case ("9"):
                return new ArrayList<String> (Arrays.asList("w", "x", "y", "z"));
            default:
                return new ArrayList<String>();
        }
    }
}