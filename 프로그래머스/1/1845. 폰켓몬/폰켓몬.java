import java.util.*;

class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0 ; i < nums.length; i++){
            set.add(nums[i]);
        }
        if (set.size() < (nums.length / 2) ) return set.size();
        else return (nums.length / 2);
        // N분의 2마리를 선택할때 가장 많은 종류를 선택할 수 있게
        // 해시로 종류를 기억해서 size 사용 
        // size보다 n/2가 클 경우 size return
        // size보다 n/2가 작거나 같을 경우 n/2리턴 
    }
}