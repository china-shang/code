class TitleToNumber171{
    // A代表1，A-Z代表1-26所以需要把charAt(i) - 'A' + 1
    public static int titleToNumber(String title){
        if(title == null ||title.length() == 0){
            return 0;
        }
        int flag = 1, num = 0;
        for(int i = title.length() - 1; i >= 0; i--){
            int t = title.charAt(i) - 'A' + 1;
            num += t * flag;
            flag *= 26;
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(titleToNumber("AOVIZ"));
    }
}
