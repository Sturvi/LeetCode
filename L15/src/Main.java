import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
    }
}

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();

        Arrays.sort(nums);
        int listIndex = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1;
            int end = nums.length - 1;

            if ((i > 0 && nums[i] == nums[i - 1])) continue;

            while (start < end) {
                if ((end < nums.length-1 && nums[end] == nums[end+1])) {
                    --end;
                    continue;
                }
                if (start>i+1 && nums[start] == nums[start-1]) {
                    ++start;
                    continue;
                }
                if (start >= end) break;

                if (nums[i] + nums[start] + nums[end] == 0) {
                    list.add(new ArrayList<Integer>());
                    list.get(listIndex).add(nums[i]);
                    list.get(listIndex).add(nums[start]);
                    list.get(listIndex).add(nums[end]);
                    ++listIndex;
                    ++start;
                    --end;
                } else if (nums[i] + nums[start] + nums[end] > 0) {
                    --end;
                } else {
                    ++start;
                }
            }
        }
        return list;

    }
}