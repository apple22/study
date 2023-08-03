package chap_03;

public class _01_String1 {
    public static void main(String[] args) {
        String s = "I like Java and Python and c . ";
        System.out.println(s.length());
        
        //대문자 변환
        System.out.println(s.toUpperCase());

        //소문자 변환
        System.out.println(s.toLowerCase());

        //포함
        System.out.println(s.contains("Java"));
        System.out.println(s.contains("Jieun"));
        
        //위치
        System.out.println(s.indexOf("Java"));
        System.out.println(s.indexOf("Jieun"));
        System.out.println(s.indexOf("and"));/*처음 위치정보*/
        System.out.println(s.lastIndexOf("and"));/*마지막 위치정보*/

        System.out.println(s.startsWith("I like"));/*이문자열로 시작하는지 여부*/
        System.out.println(s.endsWith("."));/*이 문자열로 끝나는지 여부*/


    }
}
