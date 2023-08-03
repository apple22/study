package chap_02;

public class _05_operator5 {
    public static void main(String[] args) {
        //삼항연산자
        //결과 = 조건

        int x = 5;
        int y = 3;

        int max = (x > y) ? x : y;

        boolean b = (x == y) ? true : false;

        String s = (x != y ) ? "달라요" : "같아요";
        System.out.println(s);
    }
}
