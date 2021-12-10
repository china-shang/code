import java.util.List;
import java.util.ArrayList;

class Triangle119 {
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> before = new ArrayList<>();
        before.add(1);
        for(int i=0; i<rowIndex; i++){
            List<Integer> now = new ArrayList<>();
            for(int j=0; j<=i+1; j++){
                int left = j == 0 ? 0 :before.get(j-1);
                int right = j ==i+1 ? 0:before.get(j);
                now.add(left + right);
            }
            before = now;
        }

        return before;
    }

    public static void main(String[] args) {

        System.out.println(getRow(0));
        System.out.println(getRow(1));
        System.out.println(getRow(2));
        System.out.println(getRow(3));
        System.out.println(getRow(8));
    }
}
