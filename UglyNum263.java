class UglyNum263 {
    // 除掉所有的2 3 5
    // 对于2,3,5中的任何一个,如果余数为0就/,最后判断是否为1
    public static boolean isUgly(int num){
        if(num <= 0){
            return false;
        }
        int[] factors = new int[]{2, 3, 5};
        for(int i: factors){
            while(num % i == 0){
                num /= i;
            }
        }
        return num == 1;
    }
    public static void main(String[] args) {
        System.out.println(isUgly(2 * 3 * 5 * 5 * 3));
        System.out.println(isUgly(2 * 3 * 5 * 5 * 3 * 7));
    }
}
