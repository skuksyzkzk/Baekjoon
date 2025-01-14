import java.util.*;

class Solution {
    class Stock {
        int order;
        int price;
        
        public Stock(int order,int price){
            this.order = order;
            this.price = price;
        }
    }
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        int total = prices.length;
        ArrayDeque<Stock> stack = new ArrayDeque<>();
        for (int i = 0 ; i < total; i++){
            Stock cur = new Stock(i+1,prices[i]);
            
            if (stack.isEmpty()) stack.offerLast(cur);
            else if (stack.peekLast().price > cur.price){
                while (!stack.isEmpty() && stack.peekLast().price > cur.price){
                    Stock old = stack.pollLast();
                    answer[old.order-1] = cur.order - old.order;
                }
                stack.offerLast(cur);
            }
            else {
                stack.offerLast(cur);
            }
        }
        while (!stack.isEmpty()){
            Stock cur = stack.pollLast();
            answer[cur.order - 1] = total - cur.order;
        }
        return answer;
    }
}