class LongestCommonPrefix14 {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        for(int i = 0; i < strs[0].length(); i++){
            char c = strs[0].charAt(i);
            for(int j = 1; j<strs.length; j++){
                if(strs[j].length() == i || strs[j].charAt(i) != c){
                    return strs[j].substring(0, i);
                }

            }
        }

        return "";
    }

    public static void main(String[] args) {
        String[] strs = {"asdjisdf", "asdjiej", "asd3"};
        LongestCommonPrefix14 s = new LongestCommonPrefix14();
        String res = s.longestCommonPrefix(strs);
        System.out.println(res);
    }

}
