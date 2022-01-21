import java.util.Arrays;

class InsertScope57Mid{
    // 两个区间的关系有3种,相交,AB,BA,排除了AB BA,剩下的必定相交,而相交区间的合并为
    // 取最小值为left,最大值为right
    // AB阶段,直接res.add, 相交merge完毕的结果添加到res,BA阶段直接res.add
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] res = new int[intervals.length + 1][2];
        int i = 0, end=0;
        for(; i < intervals.length; i++){
            if(intervals[i][1] < newInterval[0]){
                res[end++] = intervals[i];
            }else{
                break;
            }
        }
        for(;i < intervals.length; i++){
            if(newInterval[1] < intervals[i][0]){
                break;
            }
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
        }
        res[end++] = newInterval;
        for(; i < intervals.length;i++){
            res[end++] = intervals[i];
        }

        return Arrays.copyOf(res, end);
    }
    public static void main(String[] args) {
        int[][] res = insert(new int[][] {
            {1, 3},
            {5, 8},
            {9, 11},
            {13, 15}

        }, new int[]{7, 9});
        for(int[] i: res){
            System.out.println(Arrays.toString(i));
        }
    }
}
