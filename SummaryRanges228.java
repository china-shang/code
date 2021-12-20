import java.util.List;
import java.util.ArrayList;

class SummaryRanges228 {
    // TODO
    public static List<String> summaryRanges1(int[] nums){
        if(nums == null || nums.length == 0){
            return new ArrayList<>();
        }
        List<String> list = new ArrayList<>();
        int start=0, last=0;
        for(int i=1; i<nums.length; i++){
            while(i < nums.length && nums[last] + 1 == nums[i]){
                last = i;
                i++;
            }
            String s = String.valueOf(nums[start]);
            if(start != last){
                s += "->" + nums[last];
            }
            list.add(s);
            start = i;
            last = i;
        }
        return list;
    }
    public static List<String> summaryRanges(int[] nums){
        if(nums == null || nums.length == 0){
            return new ArrayList<>();
        }
        List<String> list = new ArrayList<>();
        int start=nums[0], last=start;
        for(int i=1; i<nums.length; i++){
            if(last + 1 == nums[i]){
                last = nums[i];
            } else {
                if(start == last){
                    list.add(String.valueOf(last));
                } else {
                    list.add(start + "->" + last);
                }
                start = nums[i];
                last = start;
            }
        }
        if(start == last){
            list.add(String.valueOf(last));
        } else {
            list.add(start + "->" + last);
        }
        return list;
    }
    public static void main(String[] args) {
        System.out.println(summaryRanges(new int[]{1,2,3,4,6,7,8,10}));
        System.out.println(summaryRanges(new int[]{1,2,3,4,6,7,8}));

        System.out.println(summaryRanges1(new int[]{1,2,3,4,6,7,8,10}));
        System.out.println(summaryRanges1(new int[]{1,2,3,4,6,7,8}));
    }
}
