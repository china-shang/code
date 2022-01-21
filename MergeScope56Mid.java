import java.util.Arrays;
class MergeScope56Mid {
    // 先按坐端进行排序,然后相邻的区间可以合并,由于已经按左段排序好了,所以
    // 左端就是左边的左端, 右端:如果相邻两个区间无法合并,即i2.left > i1.right,右端=i1.right,加入res
    // 否则就是有重叠,right=max(i1.right, i2.right),继续试图参与合并,如果i==length,没有后续区间了,res.add(last)
    public static int[][] merge(int[][] intervals) {
        sort(intervals, 0, intervals.length - 1);
        int[] last = intervals[0];
        int[][] res = new int[intervals.length][2];
        int end = 0;
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] <= last[1]){
                last[1] = Math.max(intervals[i][1], last[1]);
            } else {
                res[end++] = last;
                last = intervals[i];
            }
        }
        res[end] = last;

        return Arrays.copyOf(res, end + 1);
    }

    public static void sort(int[][] arr, int l, int r){
        if(l >= r){
            return ;
        }
        int[] key = arr[r];int mid = l;
        for(int i=l; i < r; i++){
            if(arr[i][0] < key[0]){
                int[] t = arr[i];
                arr[i] = arr[mid];
                arr[mid++] = t;
            }
        }
        int[] t = arr[mid];
        arr[mid] = arr[r];
        arr[r] = t;
        sort(arr, l, mid-1);
        sort(arr, mid+1, r);
    }

    public static void main(String[] args) {
        //
        int[][] res = merge(new int[][] {
            {9, 11},
            {1, 3},
            {2, 6},
            {5, 8}
        });
        for(int[] i :res){
            System.out.println(Arrays.toString(i));
        }
    }
}
