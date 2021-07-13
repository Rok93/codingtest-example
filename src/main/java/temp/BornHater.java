package temp;

public class BornHater implements Born{

    public static void main(String[] args) {
        BornHater bornHater = new BornHater();
        System.out.println(bornHater.AGE);
        System.out.println(bornHater.HELLO);
        bornHater.hi();
    }
}
