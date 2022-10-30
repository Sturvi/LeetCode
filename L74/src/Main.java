public class Main {
    public static void main(String[] args) {
        int matrix [][]={{-10,-8},{-6,-5},{-2,-2},{-1,0},{3,4},{7,7},{8,9},{10,10},{11,11},{12,14},{15,16},{17,19},{20,21},{22,22},{25,27},{28,30},{32,32},{35,36}};
        System.out.println(searchMatrix(matrix, 16));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int start = 0;
        int end = matrix.length - 1;
        while (start < end) {
            if (matrix[start][0]==target){
                return true;
            }
            if (matrix[end][0]==target){
                return true;
            }
            int mid = start + (end - start) / 2;
            if (matrix[mid][0]==target) return true;
            if (matrix[mid][0]<target){
                start=end-mid==1?mid+1:mid;
                if (start==end && matrix[end][0]>target)
                    return searchInRow(matrix[start-1], target);
            } else {
                end=mid-1;

            }
        }
        return searchInRow(matrix[start], target);
    }

    public static boolean searchInRow (int[] row, int target){
        int start=0;
        int end= row.length-1;
        while (start < end) {
            if (row[start]==target){
                return true;
            }
            if (row[end]==target){
                return true;
            }
            int mid = start + (end - start) / 2;
            if (row[mid]==target) return true;
            if (row[mid]<target){
                start=mid+1;
            } else {
                end=mid-1;

            }
        }
        return row[start]==target?true:false;
    }
}