package chap_03;

public class _02_String2 {
    public static void main(String[] args) {
        String s = "I like Java and Python and c . ";

        System.out.println(s.replace(" and", ","));
        System.out.println(s.substring(7));

        System.out.println(s.substring((s.indexOf("Java"))));
        System.out.println(s.substring(s.indexOf("Java"), s.indexOf(".")));

        //공백제거
        System.out.println(s.trim());


        String s1 = "JAVA";
        String s2 = "python";

        System.out.println(s1 + s2);
        System.out.println(s1.concat(",").concat(s2));
    }

}
