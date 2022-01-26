class SearchReverse33Mid {
    // 直接使用两段排序的条件
    // 分别根据nums[mid]与nums[0]的判断分别处理,两种情况
    // 根据target与nums[0]的判断分别处理两种情况
    // 二分本质是使每次有两种选择,然后每次都可以排除不可能的选择,而不是选择必定可能的选择
    // 如根据target拆分,target > nums[0]时,mid处于右端必定不可能右移,只能左移.
    // mid处于左段,根据与target的比较,必定能排除一个方向.
    // 所有的左移合并后,只有一个情况右移,if指明他,右移.else 左移
    // +是右移,-是左移 l要右移即加 r要左移即-
    public static int search2(int[] nums, int target){
        if(nums == null || nums.length == 0){
            return -1;
        }
        int l = 0, r = nums.length - 1, mid;
        while(l <= r){
            mid = (r - l >> 1) + l;
            if(nums[mid] == target){
                return mid;
            }
            if(target >= nums[0]){
                if(nums[mid] >= nums[0] && target > nums[mid]){
                    l = mid + 1;
                }else{
                    r = mid - 1;
                }
            }else{
                if(nums[mid] < nums[0] && target < nums[mid]){
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }

        return -1;

    }
    public static int search1(int[] nums, int target){
        if(nums == null || nums.length == 0){
            return -1;
        }
        int l = 0, r = nums.length - 1, mid ;
        while(l <= r){
            mid = (r - l >> 1) + l;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] >= nums[0]){
                if(target >= nums[0] && nums[mid] > target){
                    r = mid - 1;
                }else{
                    l = mid + 1;
                }
            }else{
                if(target < nums[0] && nums[mid] < target){
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }

        return -1;

    }

    private static int midIdx;
    // 先找到旋转的位置,然后分别二分查找两边
    // 如何找到位置: 二分mid,如果大于nums[0],右边找,如果小于nums[0],记录并向左边找
    // 如果相等向右边找-如[1, 0]
    // 默认为0,如果未找到小于nums[0]的则相当与全部旋转
    // 如果只有一个元素,那么默认为0
    // 找到位置后, 如果=0,二分查找整个数组
    // 否则查找对应的一段
    // 迭代二分,条件为l <= r
    // l + (r-l >> 1) 位移运算的优先级很低
    public static int search(int[] nums, int target){
        if(nums == null || nums.length == 0){
            return -1;
        }
        midIdx = 0;
        findMid(nums, 0, nums.length-1);
        if(midIdx == 0){
            return search(nums, 0, nums.length - 1, target);
        }
        if(target >= nums[0] && target <= nums[midIdx-1]){
            return search(nums, 0, midIdx - 1, target);
        }
        if(target >= nums[midIdx] && target <= nums[nums.length - 1]){
            return search(nums, midIdx, nums.length - 1, target);
        }
        return -1;
    }
    public static int search(int[] nums, int l, int r, int target){
        while(l <= r){
            int mid = l + (r - l >> 1);
            if(nums[mid] == target){
                return mid;
            } else if (nums[mid] < target){
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }
    public static void findMid(int[] nums, int l, int r){
        if(l > r){
            return;
        }
        int mid = l + (r - l >> 1);
        if(nums[mid] >= nums[0]){
            findMid(nums, mid + 1, r);
        }
        if(nums[mid] < nums[0]){
            midIdx = mid;
            findMid(nums, l, mid - 1);
        }
    }
    public static void main(String[] args) {
        // 1
        System.out.println(search(new int[]{4, 5, 6, 7, 8, 9,1,2,3}, 5));
        System.out.println(search1(new int[]{4, 5, 6, 7, 8, 9,1,2,3}, 5));
        System.out.println(search2(new int[]{4, 5, 6, 7, 8, 9,1,2,3}, 5));

        // 7
        System.out.println(search(new int[]{4, 5, 6, 7, 8, 9,1,2,3}, 2));
        System.out.println(search1(new int[]{4, 5, 6, 7, 8, 9,1,2,3}, 2));
        System.out.println(search2(new int[]{4, 5, 6, 7, 8, 9,1,2,3}, 2));

        // 0
        System.out.println(search(new int[]{4, 5, 6, 7, 8, 9}, 4));
        System.out.println(search1(new int[]{4, 5, 6, 7, 8, 9}, 4));
        System.out.println(search2(new int[]{4, 5, 6, 7, 8, 9}, 4));

        // 0
        System.out.println(search(new int[]{4}, 4));
        System.out.println(search1(new int[]{4}, 4));
        System.out.println(search2(new int[]{4}, 4));

        // 1
        System.out.println(search(new int[]{3, 1}, 1));
        System.out.println(search1(new int[]{3, 1}, 1));
        System.out.println(search2(new int[]{3, 1}, 1));

    }
}
