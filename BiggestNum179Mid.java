
class BiggestNum179Mid{
    // 排序组合
    // 比较时，谁在前面的字符串更大就在前面即a+b > b+a说明a应该在前，a > b
    // strs[0]=0说明全部=0 return 0
    // 规定大的在前,a + b > b + a时，a应该在前，所以a>b
    // a +b >b + a时说明a应该在前,如果大的在前，那么a > b
    public static String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for(int i = 0; i <nums.length; i++){
            strs[i] = String.valueOf(nums[i]);
        }
        sort(strs, 0, strs.length - 1);
        StringBuilder sb = new StringBuilder();
        if(strs[0].equals("0")){
            return "0";
        }
        for(int i = 0; i <strs.length; i++){
            sb.append(strs[i]);
        }
        return sb.toString();

    }
    public static void sort(String[] strs, int l, int r){
        if(l >= r){
            return;
        }
        int mid = l;
        String key = strs[r];
        for(int i = l; i < r; i++){
            if((strs[i] + key).compareTo(key +strs[i]) > 0){
                swap(strs, mid++, i);
            }
        }
        swap(strs, mid, r);
        sort(strs, l, mid - 1);
        sort(strs, mid + 1, r);
    }
    public static void swap(String[] strs, int l, int r){
        String t = strs[l];
        strs[l] = strs[r];
        strs[r] = t;
    }
    public static void main(String[] args) {
        // 9534330
        System.out.println(largestNumber(new int[]{3,30,34,5,9}));
    }
}
