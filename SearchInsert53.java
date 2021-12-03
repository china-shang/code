class SearchInsert53 {
    public static int searchInsert(int[] arr, int num){
        int start=0, end=arr.length - 1, ans = arr.length;
        while(start<=end){
            int mid = (start + end) / 2;
            if(arr[mid] >= num){
                ans = mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }

        }
        return ans;
    }
    public static int searchInsert2(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1, ans = n;
        while (left <= right) {
            int mid = (right + left) / 2;
            // 所在的位置一定大于target
            if (target <= nums[mid]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{0, 1, 3, 5 , 7, 9}, 4));
        // 3
        System.out.println(searchInsert2(new int[]{0, 1, 3, 5 , 7, 9}, 4));
    }
}
