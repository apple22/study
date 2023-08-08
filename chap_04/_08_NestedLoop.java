package chap_04;

public class _08_NestedLoop {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
            System.out.print("*");
            }/*for2*/
            System.out.println();
        }/*for1*/
        /*별 왼쪽 삼각형 만들기*/
        for (int i = 0; i < 5 ; i++) {
            for (int j = 0; j < i+1 ; j++) {
                System.out.print("*");
            }
            System.out.println();
        }/*for3*/

        /*별 오른쪽으로 치우친 삼각형*/
        for (int i = 0; i < 5 ; i++) {
            for (int j = 0; j < 4 - i; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k <= i; k++) {
                System.out.print("*");
            }
            System.out.println();
        }/*for3*/
    }
}
