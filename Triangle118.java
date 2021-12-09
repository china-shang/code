import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Triangle118{
    public static List<List<Integer>> generate(int numRows){
        if(numRows <= 0 ){
            return Collections.emptyList();
        }
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        l1.add(1);
        list.add(l1);

        for(int i=1; i<numRows; i++){
            List<Integer> last = list.get(i-1);
            List<Integer> lj = new ArrayList<>();
            for(int j=0; j<=i; j++){
                int left = j - 1 < 0? 0 :last.get(j-1);
                int right = j >= i ? 0 : last.get(j);
                lj.add(left + right);
            }
            list.add(lj);
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(generate(1));
        System.out.println(generate(4));

    }
}

