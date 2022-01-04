class Offer46TransaleNumMid {
    // f(n) = f(n-1) + f(n-2) if xx < 26 && xx > 10 一下拿两个，只有当两个组合起来是一个字符才行
    // f(n) = f(n-1) 如果两位数无法组成字符 那么只有一步
    // 递归难以实现，使用迭代
    // 由公式以及max(f(2))=2得f(0) = 1 有公式公式优先
    public static int translateNum(int num) {
        int before = 1, beforeBefore = 1, x = 0, y= num % 10;
        while(num > 0){
            num /= 10;
            x = num % 10;
            int t = x * 10 + y;
            int now = before;
            if(t < 26 && t >= 10){
                now += beforeBefore;
            }
            beforeBefore = before;
            before = now;
            y = x;
        }
        return before;

    }

    public static void main(String[] args) {
        // 5;
        System.out.println(translateNum(12258));


        // 1
        System.out.println(translateNum(506));

    }
}
