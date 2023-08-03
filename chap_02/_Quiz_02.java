package chap_02;

public class _Quiz_02 {
    public static void main(String[] args) {
        /*어린이 키에 따른 탑승 기구
        키가 120cm 이상인 경우 탑승 가능 , 미만 불가
        */

        int kwonjieun_height = 121;
        int limit = 120;

        String lollercoaster = (kwonjieun_height > limit ) ? "탑승가능" : "탑승불가";
        System.out.println(lollercoaster);

    }
}
