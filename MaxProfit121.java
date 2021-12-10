import java.util.Arrays;

class MaxProfit121 {
    // 暴力穷举
    public static int maxProfit(int[] prices) {
        int max=0;
        for(int i=0; i<prices.length; i++){
            for(int j=i+1; j<prices.length; j++){
                max = max > (prices[j] - prices[i]) ? max : (prices[j] - prices[i]);
            }
        }
        return max;
    }

    // 穷举每天卖出的最大利润,以往日的最低值作为买入，今日作为卖出，找出最大值
    public static int maxProfit2(int[] prices) {
        int min=Integer.MAX_VALUE, maxProfit=0;
        for(int i=0; i<prices.length; i++){
            int profit = prices[i] - min;
            if(profit > maxProfit){
                maxProfit = profit;
            }
            min = prices[i] < min ? prices[i] : min;
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1, 3, 5, 0, 8}));
        System.out.println(maxProfit2(new int[]{1, 3, 5, 0, 8}));

    }
}
