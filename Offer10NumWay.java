class Offer10NumWay {
    public static int fib(int n) {
        if(n < 2){
            return n;
        }
        int before=1, beforeBefore = 0, res=0;
        for(int i=2; i <= n; i++){
            res = (before + beforeBefore) % 1000000007;
            beforeBefore = before;
            before = res;
        }
        return res;
    }
    public static void main(String[] args) {
        // 5
        System.out.println(fib(5));
    }
}
