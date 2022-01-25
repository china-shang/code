import java.util.Arrays;
class SortColor75Mid {
    // 方案一:遍历两遍,每一次把左边的数字换到左边,pos始终指向不是最左边的数字
    // 就像快排中的mid始终指向大于等于的数字
    // 方案二:遍历一遍,遇到2,while i <= p2 && nums[i] == 2 then swap(p2,i)
    // 然后遇到0,swap(i,p1).
    // i==p2需要执行,p2只是代表p2右边全是2,p2可能为0,1,2,需要把它放到对应的位置
    // 判断nums[i] == 0只要用if因为p1指向是1,或者是和i相同
    // 1. i == p1 遇到0直接原地交换,然后都++就行了
    // 2. i > p1 说明遇到过1了,这个1每次遇到0就会移动到i的位置,p1永远也到达不了1以外的数字
    public static void sortColors(int[] nums) {
        if(nums == null || nums.length < 2){
            return;
        }
        int pos = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                int t = nums[i];
                nums[i] = nums[pos];
                nums[pos++] = t;
            }
        }
        for(int i = pos; i < nums.length; i++){
            if(nums[i] == 1){
                int t = nums[i];
                nums[i] = nums[pos];
                nums[pos++] = t;
            }
        }
    }

    public static void sortColors1(int[] nums){
        if(nums == null || nums.length < 2){
            return;
        }
        int p1 = 0, p2 = nums.length - 1;
        for(int i = 0; i <= p2; i++){
            while(i <= p2 && nums[i] == 2){
                int t = nums[i];
                nums[i] = nums[p2];
                nums[p2--] = t;
            }
            if(nums[i] == 0){
                int t = nums[i];
                nums[i] = nums[p1];
                nums[p1++] = t;
            }
        }
    }
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2, 0, 1, 2, 0, 1, 2};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));

        int[] nums1 = new int[]{0, 1, 2, 0, 1, 2, 0, 1, 2};
        sortColors1(nums1);
        System.out.println(Arrays.toString(nums1));
    }
}
