import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        int N = nums.length / 2;
        int keyCount = map.keySet().size(); 
        
        if (N >= keyCount) return keyCount;
        else return N;
        
    }
}