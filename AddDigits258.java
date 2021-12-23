class AddDigits258{
    public static int addDigits(int num){
        int t = 0;
        while(true){
            t += num % 10;
            num /= 10;
            if(num == 0){
                if(t<10){
                    return t;
                }
                num = t;
                t = 0;
            }
        }
    }
    public static int addDigits2(int num) {
        while (num >= 10) {
            int next = 0;
            while (num != 0) {
                next = next + num % 10;
                num /= 10;
            }
            num = next;
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(addDigits(29));
        System.out.println(addDigits(9));
        System.out.println(addDigits(111));
    }
}
