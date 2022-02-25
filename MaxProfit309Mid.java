class MaxProfit309Mid{
    private static int max;
    public static int maxProfit(int[] prices) {
        max = 0;
        dfs(prices, 0, false, 0, false);
        return max;
    }
    public static int maxProfit2(int[] prices){
        // false,false|false,true|true
        int a = 0, b = Integer.MIN_VALUE, c = Integer.MIN_VALUE;
        for(int i = 0; i < prices.length; i++){
            int ta = Math.max(b, a);
            int tb = c + prices[i];
            int tc = Math.max(c, a - prices[i]);
            a = ta;
            b = tb;
            c = tc;
        }
        return Math.max(a, Math.max(b, c));
    }
    // f(pos+1)[false, true] = Math.max(f(pos)[true] + prices[pos); //无股票冻结
    // f(pos+1)[true] = Math.max(f(pos)[true], f(pos)[false,false]-prices[pos) // 有股票,不冻结
    // f(pos+1)[false,false] = Math.max(f(pos)[false, true],f(pos)[false,false]) // 无股票不冻结
    public static void dfs(int[] prices, int pos, boolean has, int sum, boolean before){
        if(pos == prices.length){
            max = Math.max(sum, max);
            return ;
        }
        if(has){
            dfs(prices, pos+1, false, sum + prices[pos], true);
            dfs(prices, pos+1, true, sum, false);
        } else {
            if(before){
                dfs(prices, pos+1, false, sum, false);
            } else{
                dfs(prices, pos+1, true, sum - prices[pos], false);
                dfs(prices, pos+1, false, sum, false);
            }
        }
    }
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1,2,3,4,5,1,100}));
        System.out.println(maxProfit(new int[]{1,2,3,0,2}));

        System.out.println(maxProfit2(new int[]{1,2,3,4,5,1,100}));
        System.out.println(maxProfit2(new int[]{1,2,3,0,2}));
    }
}
