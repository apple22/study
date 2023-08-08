package chap_04;

public class _05_For {
    public static void main(String[] args) {
        //반복문 for 
        //나코매장 
        System.out.println("어서오세요 나코입니다");
        //또다른 손님이 들어오면?
        System.out.println("어서오세요 나코입니다");
        System.out.println("어서오세요 나코입니다");
        System.out.println("어서오세요 나코입니다");
        System.out.println("어서오세요 나코입니다");
        System.out.println("어서오세요 나코입니다");
        System.out.println("어서오세요 나코입니다");
        //만약에 인사법이 바뀌면?
        System.out.println("환영합니다 , 나코입니다");
        System.out.println();

        //짝수만출력
        for(int i = 0; i< 10; i+=2){
            System.out.println(i);
        }

        System.out.println();
        //홀수만출력
        for(int i = 1; i< 10; i+=2){
            System.out.println(i);
        }


        System.out.println();
        //거꾸로 숫자
        //5,4,3,2,1

        for (int i = 5; i > 0; i--) {
            System.out.println(i);
            
        }

        System.out.println();
        
        //1부터 10까지 수들의 합
        
        int sum = 0;
        for (int i = 1; i <= 11; i++) {
            sum +=1;
            System.out.println("현재까지 총 합은 " + sum + "입니다");
        }
    }
}
