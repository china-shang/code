class CanCar134Mid{
    // 如果从a出发抵达不了b,那么从a-b出发都抵达不了b,从b+1出发开始尝试
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas == null || gas.length == 0 || cost==null || cost.length == 0){
            return -1;
        }
        for(int i = 0; i < gas.length;){
            int remainGas = 0, j = 0;
            for(; j < gas.length; j++){
                int idx = (i + j) % gas.length;
                remainGas = remainGas + gas[idx] - cost[idx];
                if(remainGas < 0){
                    break;
                }
            }
            if(remainGas >= 0){
                return i;
            }
            i += j + 1;
        }
        return -1;

    }
    public static void main(String[] args) {
        System.out.println(canCompleteCircuit(new int[]{1,2,3,4,5}, new int[]{3,4,5,1,2}));
    }
}
