class Sqrt69{

    public static int sqrt(int x){
        int l = 0, r = x, ans = 0;
        while(l <= r){
            int mid = (r - l) / 2 + l;
            if((long) mid * mid <= x){
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        System.out.println(sqrt(10));
    }
}
