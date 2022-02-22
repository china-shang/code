import java.util.Arrays;

class HIndex274Mid{
    // h指数,先排序.nums[i]代表h，length - i也代表h.取最小值为实际h
    // 取最大值为h指数
    public static int hIndex(int[] citations) {
        Arrays.sort(citations);
        int ans = 0;
        for(int i = citations.length - 1; i >= 0; i--){
                ans = Math.max(ans, Math.min(citations[i], citations.length - i));
        }
        return ans;
    }
    public static void main(String[] args) {
    }
}
