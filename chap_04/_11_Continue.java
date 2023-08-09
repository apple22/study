package chap_04;

public class _11_Continue {
    public static void main(String[] args) {
        //Continue
        //치킨 주문 손님중에 노쇼 손님이 있다고 가정
        //For
        int max = 20; //최대 치킨 판매 수량
        int sold = 0; // 현재 치킨 판매 수량
        int noShow = 17;// 대기번호 17번 손님이 소쇼

        for (int i = 1; i < 50; i++) {
            if(i == noShow){
                System.out.println(i + "번 손님 , 노쇼로 인해 다음 손님에게 기회가 넘어 갑니다");
                continue;
            }


            System.out.println(i + "번 손님 , 주문하신 치킨 나왔습니다");
            sold++; // 판매 처리
            if(sold == max){
                System.out.println("금일 재료가 모두 소진되었습니다");
                break;

            }//*if*//
        }/*for*/
        //while문
        sold = 0;
        int index = 1;//손님 번호
        int maxa = 50;

        while(true){
            System.out.println(index + "번 손님 , 주문하신 치킨 나왔습니다");
            sold++;//판매처리
            if(index == 20){
                System.out.println(index + "번 손님 , 노쇼로 인해 다음 손님에게 기회가 넘어 갑니다");
                index++;
                continue;
            }

             if(sold == maxa){
                 System.out.println("금일 재료가 모두 소진되었습니다");
                 break;
             }
             index ++;
        }/*while*/
        System.out.println("금일 영업을 종료합니다");
        
    }
}
