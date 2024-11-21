import java.util.*;
class Solution
{
    public int solution(int [][]board)
    {
        int answer = 0;
        int N = board.length;
        int M = board[0].length;
        
        for (int i = 1; i < N; i++){
            for (int j = 1; j < M; j++){
                if (board[i][j] == 1){
                    int up = board[i-1][j];
                    int left = board[i][j-1];
                    int leftUp = board[i-1][j-1];
                    
                    board[i][j] = Math.min(up,Math.min(left,leftUp)) + 1;
                }
            }
        }
        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                if (answer < board[i][j]) answer = board[i][j];
            }
        }
        
        return answer * answer;
    }
}