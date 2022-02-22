class HIndex275Mid {
    // 数组已排序 h为min(citations[i], length -i)
    // 两个关键参数一个递增一个递减,取最小值就是一条/\线
    // 二分查找根据是否=length-i来判断是在哪一边
    public static int hIndex(int[] citations) {
        int n = citations.length, l = 0, r=n-1, mid = 0,ans = 0;
        while(l <= r){
            mid = l + (r - l >> 1);
            int t = Math.min(citations[mid], n - mid);
            ans = Math.max(ans, t);
            if(t == n - mid){
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {

    }
}
