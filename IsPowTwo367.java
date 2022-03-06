class IsPowTwo367{
    public boolean isPerfectSquare(int num) {
        long l = 1, r = num, mid;
        while(l<=r){
            mid = l + (r - l >> 1);
            long t = mid * mid;
            if(t == num){
                return true;
            } else if (t > num){
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return false;
    }
    public static void main(String[] args) {

    }
}
