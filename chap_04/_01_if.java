package chap_04;

public class _01_if {
    public static void main(String[] args) {
       /*  int hour = 12;
         boolean MorningCoffee = false;
         if(hour <= 10 && !MorningCoffee) {
             System.out.println("아이스 아메리카노 주문완료");
             System.out.println("샷추가");
         }else{
             System.out.println("커피안마심");
         }*/

        int hour = 14;
        boolean MorningCoffee = true;
        if(hour >=14 || MorningCoffee == true){
            System.out.println("커피");
        }else{
            System.out.println("디카페인 커피");
        }
    }

}
