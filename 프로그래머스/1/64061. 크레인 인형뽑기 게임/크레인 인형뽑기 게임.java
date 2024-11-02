import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i =0 ; i < moves.length; i++){
            int target = 0;
            for (int j = 0; j < board.length;j++){
                if ( board [j][moves[i] - 1 ] != 0){
                    target = board[j][moves[i] - 1];
                    board[j][moves[i] - 1] = 0;
                    break;
                }
            }
            if (target != 0){
                if ( !stack.isEmpty() && stack.peek() == target){
                    stack.pop();
                    answer+=2;
                }
                else {
                    stack.push(target);
                }
            }
        }
        return answer;
    }
}