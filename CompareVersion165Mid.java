class CompareVersion165Mid {
    // split是按正则拆分的，需要\\.转义.
    public static int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        for(int i = 0 ; i < v1.length || i <v2.length; i++){
            int t1 = i >= v1.length ? 0 : Integer.valueOf(v1[i]);
            int t2 = i >= v2.length ? 0 : Integer.valueOf(v2[i]);
            if(t1 > t2){
                return 1;
            } else if(t2 > t1){
                return -1;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        // 0
        System.out.println(compareVersion("1.0.1", "1.0.1.0"));
        // 1
        System.out.println(compareVersion("1.0.1.1", "1.0.1.0"));
        // -1
        System.out.println(compareVersion("1.0.1.1", "1.0.1.1.1"));
    }
}

