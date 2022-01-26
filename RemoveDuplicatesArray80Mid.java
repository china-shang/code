import java.util.Arrays;
class RemoveDuplicatesArray80Mid{
    // 需要先左移,因为当前的左移位数,是由前面的remove决定的,本次循环的removeCount++影响的是下次左移
    // 利用双指针每次跳到不同的数字上,然后左移
    // 由于要最大保留两位,遇到j== i + 1时,也进行左移,并且不进行removeCount++
    public static int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int removeCount = 0, n = nums.length;
        for(int i = 0, j=1; i < n; i=j, j++){
            nums[i - removeCount] = nums[i];
            while(j < nums.length && nums[j] == nums[i]){
                if(j == i + 1){
                    nums[j - removeCount] = nums[i];
                } else {
                    removeCount++;
                }
                j++;
            }
        }

        return n - removeCount;
    }
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 2, 2, 2, 3, 3, 4, 4, 5 , 6, 6, 6};
        removeDuplicates(nums);
        System.out.println(Arrays.toString(nums));

    }
}
