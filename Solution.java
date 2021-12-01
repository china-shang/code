class Solution {
    public int longestArithSeqLength(int[] A) {
        int []lens = new int[A.length - 1];
        for (int i = 0; i < A.length - 1; i++) {
            lens[i] = Math.abs(A[i + 1] - A[i]);
        }
        int max = 2, now = 2;
        int before = lens[0];
        for (int i = 1; i < lens.length; i++) {
            if(lens[i] == before){
                now += 1;
            }else {
                max = max > now ? max : now;
                now = 2;
                before = lens[i];
            }
        }
        max = max > now ? max : now;

        return max;
    }
}
