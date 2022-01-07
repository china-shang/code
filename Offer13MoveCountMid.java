class Offer13MoveCountMid {
    private static boolean[][] moved;
    // 开始没走的时候,moved[0][0] = true
    // 防止走老路,moved[i][j] == true return
    public static int movingCount(int m, int n, int k) {
        moved = new boolean[m][n];
        moved[0][0] = true;
        move(1, 0, k);
        move(0, 1, k);
        int res = 0;
        for(int i = 0; i < m; i ++){
            for(int j = 0; j < n; j++){
                if(moved[i][j]){
                    res++;
                }
            }
        }

        return res;
    }
    public static void move(int i, int j, int k){
        if(i < 0 || i >= moved.length || j < 0 || j >= moved[0].length || moved[i][j]){
            return;
        }
        int c = 0, t = i;
        while(t != 0){
            c += t % 10;
            t /= 10;
        }
        t = j;
        while(t != 0){
            c += t % 10;
            t /= 10;
        }
        if(c > k){
            return;
        }
        moved[i][j] = true;
        move(i+1, j, k);
        move(i, j+1, k);
    }

    public static void main(String[] args) {
        // 27
        System.out.println(movingCount(5, 6, 7));

    }
}

