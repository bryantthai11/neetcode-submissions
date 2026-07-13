class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //we just have to contectualize the matrix, if we convert it into an array that is trivial binary sort.
        // we can just find the total spaces by rows * cols, then do integer division by rows, then the remainder is the column,
        //we use left and right to do it

        int left = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int right = rows * cols - 1;

        while(left <= right ){
            int mid = left + (right - left) / 2;
            int row = mid/cols;
            int col = mid%cols;
            if(matrix[row][col] == target){
                return true;
            }else if(matrix[row][col] > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return false;
    }

}
