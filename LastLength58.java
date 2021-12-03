class LastLength58  {

    /**
     * 遇到非空length+1
     * 遇到空如果length > 0 lastLength = length
     * length = 0
     * 最后如果length != 0 lastLength=length
     */
    public static int lastLength(String s){
        if(s == null || s.length() == 0){
            return 0;
        }
        int length = 0,lastLength=0;
        for(char c : s.toCharArray()){
            if(c!=' '){
                length++;
            }else{
                if(length > 0){
                    lastLength = length;
                }
                length = 0;
            }
        }
        if(length > 0){
            lastLength = length;
        }
        return lastLength;

    }

    /*
     * 先去重了所有的空格,然后计数到头或者遇到空格为止
     *
     */
    public static int lastLength1(String s){

        int idx = s.length() - 1;
        for(; idx>0;idx--){
            if(s.charAt(idx) != ' '){
                break;
            }
        }


        int length = 0;
        for(int i=idx; i>=0;i--){
            if(s.charAt(i) != ' '){
                length++;
            }else{
                break;
            }
        }

        return length;

    }

    public static void main(String[] args) {
        System.out.println(lastLength("1fji 3 312j3  12345  "));
        System.out.println(lastLength("1fji 3 1  12345"));

        System.out.println(lastLength1("1fji 3 312j3  12345  "));
        System.out.println(lastLength1("1fji 3 1  12345"));
    }
}
