class Hint299Mid{
    // 遍历一边i∈{0，n-1},s[i]==g[i] then a++; else 对应需要的数字count++,对应提供的数字count++
    // 遍历需要、提供的数组,每项取需要、提供的count最小值作为b+=
    public static String getHint(String secret, String guess) {
        int a = 0, b = 0;
        int[] sDp = new int[10];
        int[] gDp = new int[10];
        for(int i = 0; i < secret.length(); i++){
            if(secret.charAt(i) == guess.charAt(i)){
                a++;
            } else {
                sDp[secret.charAt(i) - '0']++;
                gDp[guess.charAt(i) - '0']++;
            }
        }
        for(int i = 0; i < 10; i++){
            b += Math.min(sDp[i], gDp[i]);
        }
        return a + "A" + b + "B";
    }
    public static void main(String[] args) {
    }
}
