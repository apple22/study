package chap_04;

public class _Quiz_04 {
    public static void main(String[] args) {
        /*주차요금 정산 프로그램*/

        /*주차요금은 시간당 4000원 (일일 최대 요금 30000원)*/
        /*경차 또는 장애인 차량 최종 요금 50%할인*/

        /*주차요금 */
        /*일반 차량 5시간 주차시 20000원*/
        /*경차 5시간 주차시 10000원*/
        /*장애인 차량 10시간 주차시 15000원*/

        int hour = 10; /*주차 시간*/
        boolean isSmallCar = false;
        boolean whiteDisablePerson = true;
        int fee = hour * 4000;
        
        //30000원 초과시 일일 최대 요금
        if(fee > 30000){
          fee = 30000;
        }

        /*경차 또는 장애인 차량인 경우*/
        if(isSmallCar || whiteDisablePerson ){
            fee /= 2; // 50%할인 적용
        }
        
        //실행 결과 출력 
        System.out.println("주차 요금은" + fee + "원 입니다");


    }
}
