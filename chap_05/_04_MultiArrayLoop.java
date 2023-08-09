package chap_05;

public class _04_MultiArrayLoop {
    public static void main(String[] args) {
        //다차원 배열 순회
        String[][] seats = new String[][] {
                {"A1" , "A2" , "A3" , "A4" , "A5"},
                {"B1" , "B2" , "B3" , "B4" , "B5"},
                {"C1" , "C2" , "C3" , "C4" , "C5"}
        };/*seats*/

        for (int i = 0; i < 3; i++) { //세
            for (int j = 0; j < 5; j++) { //가로
                System.out.print(seats[i][j] + " ");
            }/*for1*/
            System.out.println();
        }/*for2*/

        System.out.println("-------------");


        String[][] seats2 = {
                {"A1" , "A2" , "A3"},
                {"B1" , "B2" , "B3" , "B4"},
                {"C1" , "C2" , "C3" , "C4" , "C5"}
        };

        for (int i = 0; i < seats2.length; i++) { //세
            for (int j = 0; j < seats2[i].length; j++) { //가로
                System.out.print(seats2[i][j] + " ");
            }/*for1*/
            System.out.println();
        }/*for2*/


        System.out.println("-------------");
        //세로크기 10 X 가로크기 15에 해당하는 영화관 좌석
        String[][] seat3 = new String[10][15];
        String[] eng = {
                "A","B","C","D","E","F","G","H","I","j"
        };

        for (int i = 0; i < seat3.length; i++) { // 세로
            for (int j = 0; j < seat3[i].length; j++) {
                seat3[i][j] = eng[i] + (j + 1);
            }
        }

        //표구매
        seat3[7][8] ="__";
        seat3[7][9] ="___";

        System.out.println("-------------");
        //영화관 좌석 번호 확인
        for (int i = 0; i < seat3.length; i++) { //세
            for (int j = 0; j < seat3[i].length; j++) { //가로
                System.out.print(seat3[i][j] + " ");
            }/*for1*/
            System.out.println();
        }/*for2*/
    }/*main*/
}/*class*/
