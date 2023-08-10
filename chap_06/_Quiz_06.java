package chap_06;
public class _Quiz_06 {
/*//    개인 정보중 일부를 비공개로 전환하는 프로그램을 작성하시오
    // 하나의 메소드에서 모든 동작 처리
    // 각정보는 아래 위치부터 비공개 적용
//       이름 : 2번째 글자 , 주민등록번호:ㅣ9번째글짜 , 전화번호 10번쨰 글자 */
    public  static String getHiddenData(String data , int index){
        String hiddenData = data.substring(0, index);//나코딩 -->
        for (int i = 0; i < data.length() -index; i++) {
             hiddenData += "a"; //나 **
        }
       return hiddenData;
    }
    public static void main(String[] args) {
        String name = "나코딩";//이름
        String id ="990130-1234567";//주민등록번호
        String phone = "010-1234-5678";// 전화번호
        System.out.println("이름 : " + getHiddenData(name , 1)); // 개인정보 , 비공개 시작 위치
        System.out.println("주민등록번호: " + getHiddenData(id , 8));
        System.out.println("전화번호 : " + getHiddenData(phone , 9));
    }
}


