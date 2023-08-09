package chap_05;

public class _Quiz_05 {
    public static void main(String[] args) {
        /*배열을 활용하여 쇼핑몰에서 구매가능한 신발사이즈 옵션 출력 프로그램 작성 */
        /* 신발사이즈 250부터 295까지 5단위로 증가 */
        /*신발 사이즈 10가지*/
//        String[][] ShoesSize = new String[][] {
//                {"250" , "255" , "260" , "265" , "270"},
//                {"275" , "280" , "285" , "290" , "295"}
//        };
//
//        for (int i = 0; i < ShoesSize.length; i++) {
//            for (int j = 0; j < ShoesSize[i].length; j++) {
//                System.out.println(ShoesSize[i][j] + " " + "(재고 있음)");
//            }
//
//        }
        int[] sizeArray = new int[10];
        for (int i = 0; i < sizeArray.length; i++) {
            sizeArray[i] = 250 + (5 * i);
        }/*for*/
        for (int size:
             sizeArray) {
            System.out.println("사이즈" + size + " (재고있음) ");
        }
    }/*main*/
}/*class*/
