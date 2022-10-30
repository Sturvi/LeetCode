
import java.io.FilterOutputStream;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1,2}, new int[]{3,4}));

    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] newArray = new int[nums1.length + nums2.length];
        int j = 0;
        for (int i = 0; i < nums1.length; i++) {
            newArray[i] = nums1[i];
        }
        for (int i = nums1.length; i < nums1.length+nums2.length; i++) {
            newArray[i] = nums2[j];
            j++;
        }
        Arrays.sort(newArray);
        if (newArray.length % 2 == 1)
            return newArray[newArray.length / 2];
        int i =newArray.length / 2;
         return (newArray[i-1] + newArray[i])/2.0;
    }
}