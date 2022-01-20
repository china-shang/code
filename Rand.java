import java.util.Random;
class Rand{
    public static int rand5(){
        return new Random().nextInt(4) + 1;
    }

    public static int rand8(){
        int t = (rand5() - 1) * 5 + rand5();
        while (t > 24){
            t = (rand5() - 1) * 5 + rand5();
        }
        return t % 8 + 1;
   }

    public static void main(String[] args) {

        System.out.println(rand8());
    }
}
