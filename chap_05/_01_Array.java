package chap_05;

public class _01_Array {
    public static void main(String[] args) {
        //배열 : 같은 자료형의 값 여러개를 적용하는 공간
//        String coffeeRoss = "아메리카노";
//        String coffeeRachel = "카페모카";
//        String coffeeCahandler = "라떼";
//        String confeeMonica = "카푸치노";
//
//        System.out.println(coffeeRoss + "하나");
//        System.out.println(coffeeRachel + "하나");
//        System.out.println(coffeeCahandler + "하나");
//        System.out.println(confeeMonica + "하나");
//        System.out.println("주세요");
        
//        배열 선언 첫번째 방법
//          String[] coffees = new String[4];
        
//        //배열 선언 두번째 방법
//        String coffees[] = new String[4];

//          coffees[0] = "아메리카노"; // 0부터 시작
//          coffees[1] = "카페모카";
//          coffees[2] = "카푸치노";
//          coffees[3] = "라떼";

        // 세번째 방법 
        String [] coffees = new String[] {"아메리카노" , "카페모카" , "라떼" , "카푸치노"};
        //커피 주문

        coffees[2] = "에스프레소";


        System.out.println(coffees[0] + " 하나");//아메리카노 하나
        System.out.println(coffees[1] + " 하나");//아메리카노 하나
        System.out.println(coffees[2] + " 하나");//아메리카노 하나
        System.out.println(coffees[3] + " 하나");//아메리카노 하나

        // 다른 자료형
        int[] i = new int[3];
        i[0] = 1;
        i[1] = 2;
        i[2] = 3;



    }


}
