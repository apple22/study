package chap_03;

public class _03_StringCompare {
    public static void main(String[] args) {
        String s1 = "JAVA";
        String s2 = "Python";

        System.out.println(s2.equals("python"));
        System.out.println(s2.equalsIgnoreCase("python"));
        
        //문자열 비교 심화
        s1 = "1234";
        s2 = "1235";
        System.out.println(s1.equals(s2));

    }
}
