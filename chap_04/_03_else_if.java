package chap_04;

public class _03_else_if {
    public static void main(String[] args) {
        //조건문 else if
        //한라봉 에이드가 있으면 + 1
        //망고 주스가 있으면 + 1
        
        boolean hallabongAde = false; // 한라봉 에이드
        boolean mangojuice = false; // 망고 쥬스
        boolean orangeJuice = true; // 오렌지쥬스

        if (hallabongAde){
            System.out.println("한라봉 에이드 + 1");
        }else if(mangojuice){
            System.out.println("망고쥬스 + 1");
        }else if(orangeJuice){
            System.out.println("오렌지쥬스 + 1");
        }else{
            System.out.println("아이스아메리카노 + 1");
        }

        System.out.println("커피 주문 완료 #1");
    }
}
