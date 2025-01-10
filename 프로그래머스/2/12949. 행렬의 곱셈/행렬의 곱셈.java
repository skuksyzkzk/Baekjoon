import java.util.*;

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int row1 = arr1.length;
        int col1 = arr1[0].length;
        int row2 = arr2.length;
        int col2 = arr2[0].length;
        // 결국 행렬의 곱은 row1 x col2 임 
        int[][] answer = new int[row1][col2];
        for (int i = 0 ; i < row1; i++ ){
            for (int j = 0 ; j <col2; j++){
                for (int k = 0; k < row2; k++){
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        
        return answer;
    }
}