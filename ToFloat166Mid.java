import java.util.Map;
import java.util.HashMap;

class ToFloat166Mid{
    // 由于需要负数转正数，相乘, 除以Ingeger.MIN_VALUE 需要使用long替代int.
    // map.put(a, sb.length())把a对应的商算了进去.判断被除数是否重复时，商还没append
    public static String fractionToDecimal(int numerator, int denominator) {
        long n1 = numerator, n2 = denominator;
        if(n1 % n2 == 0){
            return String.valueOf(n1 / n2);
        }
        StringBuilder sb = new StringBuilder();
        if(n1 * n2 < 0){
            sb.append("-");
        }
        n1 = Math.abs(n1);
        n2 = Math.abs(n2);
        long t = n1 / n2;
        sb.append(String.valueOf(t))
        .append(".");
        long a = n1 % n2;
        Map<Long, Integer> map = new HashMap<>();
        while(a != 0){
            map.put(a, sb.length());
            a *= 10;
            long b = a / n2;
            a = a % n2;
            sb.append(String.valueOf(b));
            if(map.containsKey(a)){
                int pos = map.get(a);
                return String.format("%s(%s)", sb.substring(0, pos),sb.substring(pos));
            }

        }
        return sb.toString();
    }
    public static void main(String[] args) {
        //-0.58(3)
        System.out.println(fractionToDecimal(7, -12));
    }
}
