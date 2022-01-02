class Offer47MaxGift {
    private int[][] maxValues;
    public int maxValue(int[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        maxValues = new int[grid.length][grid[0].length];
        return grid[0][0] + Math.max(maxValue(grid, 0, 1), maxValue(grid, 1, 0));
    }
    public int maxValue(int[][] grid, int a, int b){
        if(a >= grid.length){
            return 0;
        }
        if(b >= grid[0].length){
            return 0;
        }
        if(maxValues[a][b] != 0){
            return maxValues[a][b];
        }
        int res =  grid[a][b] + Math.max(maxValue(grid, a, b+1), maxValue(grid, a+1,b));
        maxValues[a][b] = res;
        return res;

    }

}
