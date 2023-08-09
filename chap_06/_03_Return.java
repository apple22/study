package chap_06;
public class _03_Return {
    //호텔 전화번호
    public static String getPhoneNumber(){
        String PhoneNumber = "010-2321-0610";
        return PhoneNumber;
    }
    //호텔 주소
    
    public static String getAddress(){
        return "서울특별시 금천구";
    }
    //호텔 액티비티
    public static String getActivity(){
        return "볼링장 , 탁구장 ,노래방";
    }
    public static void main(String[] args) {
        //반환값 Return
       String PhoneNumber = getPhoneNumber();
       System.out.println("호텔 전화번호 : " + PhoneNumber);

       String Address =getAddress();
        System.out.println(" 호텔 주소는 :" + Address);

        System.out.println("호텔 액티비티 " + getActivity());
    }

}
