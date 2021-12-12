class HuiString125 {
    public static boolean isHui(String s){
        for(int i=0, j=s.length()-1; i<j;i++,j--){
            while(i<j && !Character.isLetterOrDigit(s.charAt(i))){
                i++;
            }

            while(i<j && !Character.isLetterOrDigit(s.charAt(j))){
                j--;
            }
            if(i<j && Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(isHui("asdfjkkjfdsa"));
        System.out.println(isHui("a sd fjk kjf ds a"));
        System.out.println(isHui("asdfjkoikjfdsa"));
    }
}
