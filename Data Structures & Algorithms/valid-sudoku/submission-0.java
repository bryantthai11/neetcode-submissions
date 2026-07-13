class Solution {
    public boolean isValidSudoku(char[][] board) {
        // 1. each row must contain digits 1 - 9
        // 2. each column must contain the digits 1 -9 without duplicates

        //what if we just iterate over the board, then assign each column, row, and square a set, if there is a duplicate we return false
            //hard part is how to distinguish where in the board i am
            //row key is i
            //col key is j 
            // i can do i/3  + col/3
        Map<Integer, Set> squareMap = new HashMap<>();
        Map<Integer, Set> rowMap = new HashMap<>();
        Map<Integer, Set> colMap = new HashMap<>();
        for(int i = 0; i < board.length; i++){
            
            for(int j = 0; j < board[0].length; j++){
                int idxSquare = (i / 3) * 3 + (j / 3);
                if(board[i][j] == '.'){
                    continue;
                }
                int num = board[i][j] - '0';
                rowMap.computeIfAbsent(i, k -> new HashSet<>());
                colMap.computeIfAbsent(j, k -> new HashSet<>());
                squareMap.computeIfAbsent(idxSquare, k -> new HashSet<>());
                if(rowMap.get(i).contains(num) || colMap.get(j).contains(num) || squareMap.get(idxSquare).contains(num)){
                    return false;
                }
                rowMap.get(i).add(num);
                colMap.get(j).add(num);
                squareMap.get(idxSquare).add(num);


            }
        }
        return true;
    }
}
