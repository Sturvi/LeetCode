import java.util.ArrayList;


class Solution {
    public String convert(String s, int numRows) {
        if (numRows==0) return s;

        ArrayList<ArrayList<String>> arrayList = new ArrayList<ArrayList<String>>();
        for (int i = 0; i < numRows; i++) {
            arrayList.add(new ArrayList<String>());
        }

        int j = 0;
        boolean up = true;
        for (int i = 0; i < s.length(); i++) {
            arrayList.get(j).add(Character.toString(s.charAt(i)));
            if (j == numRows - 1)
                up = false;
            else if (j == 0) {
                up = true;
            }
            j = up ? ++j : --j;
        }
        s = "";
        for (int i = 0; i < numRows; i++) {
            for (int k = 0; k < arrayList.get(i).size(); k++) {
                s += arrayList.get(i).get(k);
            }
        }
        return s;
    }
}