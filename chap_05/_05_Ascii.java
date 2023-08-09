package chap_05;

public class _05_Ascii {
    public static void main(String[] args) {
        // 아스키코드 (ANSI) : 미국 표준 코드
        char c = 'A'; // 알파벳 대문자 A 는 65부터 시작 , 소문자 a 는 97부터 시작 숫자 0은 48부터 시작
        System.out.println(c);
        System.out.println((int) c);

        c = '1';

        c++;
        System.out.println(c);
        System.out.println((int) c);

        String[][] seat3 = new String[10][15];
        char ch = 'A';
        for (int i = 0; i < seat3.length; i++) { // 세로
            for (int j = 0; j < seat3[i].length; j++) {
                seat3[i][j] = String.valueOf(ch) + (j + i);
            }
            ch++;
        }



        //영화관 좌석 번호 확인
        for (int i = 0; i < seat3.length; i++) { //세
            for (int j = 0; j < seat3[i].length; j++) { //가로
                System.out.print(seat3[i][j] + " ");
            }/*for1*/
            System.out.println();
        }/*for2*/

        



    }
}
