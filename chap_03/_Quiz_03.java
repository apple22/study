package chap_03;

public class _Quiz_03 {
    public static void main(String[] args) {
        String id ="901101- 1409918";
        System.out.println(id.substring(0,8));

        System.out.println(id.substring(0,id.indexOf("-") + 2));

    }
}
