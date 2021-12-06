import java.util.Arrays;
class MergeSortedArray88 {
    //从后往前遍历,两个数组都未遍历完，那个数更大就存下数，然后--;一个数组遍历完了，就存下另一个数，然后--;
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i=m-1, j=n-1, k=m+n-1;k>=0;k--){
            if(j < 0){
                break;
            }else if(i < 0){
                nums1[k] = nums2[j--];
            }else if(nums1[i] >= nums2[j]){
                nums1[k] = nums1[i--];
            }else{
                nums1[k] = nums2[j--];
            }

        }

    }

    public static void main(String[] args) {
        // int[] nums1 = {1,3,5,7,9, 0,0,0,0,0};
        // int[] nums2 = {2,4,6,8,10};
        // merge(nums1, 5, nums2, 5);
        // System.out.println(Arrays.toString(nums1));

        int[] nums3 = {2, 0};
        int[] nums4 = {1};

        merge(nums3, 1, nums4, 1);
        System.out.println(Arrays.toString(nums3));

    }
}
