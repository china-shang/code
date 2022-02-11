class NumberToTitle168{
    // 假设num=n0 + 26 * n1 + 26 ** 2 * n2 + 26 ** 3 * n3 n0.1.2.3 ∈{1,26}
    // 由于A代表1,Z代表26，而字符为'A' + num ∈ { 0, 25}，'A'加的是代表的数-1
    public static String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while(columnNumber != 0){
            columnNumber--;
            sb.append((char)(columnNumber % 26 + 'A'));
            columnNumber /= 26;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(convertToTitle(26));
        System.out.println(convertToTitle(260));
        System.out.println(convertToTitle(2600));
    }
}
