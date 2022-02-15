
class RangeAnd201Mid{
    // 范围AND就是求最大最小数的前缀
    // 每次右移去掉最后的一位，shift++直到前缀相同为止
    // 否则r > l时继续循环
    // 最后左移shift
    public static int rangeBitwiseAnd(int left, int right) {
        int shift = 0;
        while(left < right){
            left >>>= 1;
            right >>>=1;
            shift++;
        }
        return left << shift;
    }
    public static void main(String[] args) {
        // 4
        System.out.println(rangeBitwiseAnd(5, 7));
    }
}
