package algorithm.동적계획법.besttimetobuyandsellstock;

/*
 * 출처: leetcode
 * 문제 이름: Best Time to Buy and Sell Stock
 * */
public class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i = 0; i < prices.length; i++) {
            if(prices[i] < minPrice) minPrice = prices[i];
            else if(prices[i] - minPrice > maxProfit) maxProfit = prices[i] - minPrice;
        }
        return maxProfit;
    }
}
