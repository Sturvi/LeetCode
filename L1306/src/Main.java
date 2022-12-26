public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canReach(new int[]{4,2,3,0,3,1,2}, 5));
        System.out.println(solution.canReach(new int[]{4,2,3,0,3,1,2}, 0));
        System.out.println(solution.canReach(new int[]{3,0,2,1,2}, 2));
    }
}

class Solution {
    boolean zeroFound;
    public boolean canReach(int[] arr, int start) {
        zeroFound = false;
        boolean beenHereBefore [] = new boolean[arr.length];
        beenHereBefore[start] = true;
        goToWay(arr, start, beenHereBefore);

        return zeroFound;
    }

    private void goToWay(int[] arr, int start, boolean[] beenHereBefore) {
        if ((start-arr[start] >= 0 && arr[start-arr[start]] == 0) ||
                (start+arr[start] < arr.length && arr[start+arr[start]] == 0)) {
            zeroFound = true;
            return;
        }

        if (!zeroFound && start-arr[start] >= 0 && !beenHereBefore[start-arr[start]]) {
            beenHereBefore[start-arr[start]]=true;
            goToWay(arr, start-arr[start], beenHereBefore);
        }
        if (!zeroFound && start+arr[start] < arr.length && !beenHereBefore[start+arr[start]]) {
            beenHereBefore[start+arr[start]]=true;
            goToWay(arr, start+arr[start], beenHereBefore);
        }
    }
}