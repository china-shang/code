import java.util.Set;
import java.util.HashSet;

class LongSeq128Mid {
    // 对于每个数,都在数组中找后面的数,如果找到++然后继续找
    // 使用set快速查找是否存在
    // 最长序列只会出现在开头,如果前面存在数字,不用查找
    public static int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for(int i : nums){
            set.add(i);
        }
        int max = 1;
        for(int i: set){
            int current = 1;
            if(!set.contains(i - 1)){
                while(set.contains( i + 1)){
                    i++;
                    current++;
                }
                max = Math.max(current, max);
            }
        }
        return max;
    }
    public static void main(String[] args) {
        // 5
        System.out.println(longestConsecutive(new int[]{1, 2, 3 ,4 ,5,7 ,8 ,9 ,10, 12, 21, 39,98}));
    }
}
