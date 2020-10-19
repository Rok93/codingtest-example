package librarytest;

public class StringLibrary {
    public static void main(String[] args) {
        char[] s = "123456789".toCharArray();
        String transStr = new String(s);
        int i = transStr.codePointBefore(1);
//        System.out.println(i);
//        System.out.println((int) '1');

        char[] chars = {'a', 'P', 'P', 'l', 'e', '2'};
        String apple2 = String.valueOf(chars);
        System.out.println(apple2);
        String s1 = apple2.toLowerCase();
        String s2 = apple2.toUpperCase();
        System.out.println(s1);
//        int i1 = apple2.indexOf("2e");
//        int i2 = apple2.indexOf("pl", 2);
//        System.out.println(i1);
//        System.out.println(i2);
    }
}

