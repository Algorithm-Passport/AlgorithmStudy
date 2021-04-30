package baekjoon.DP;

import java.util.Scanner;

public class Main1904 {
    public static void main(String[] args) {
        // 메모이제이션으로 풀면될듯 점화식 : d(i) = d(i-2) + d(i-1)
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] d = new int[N + 1];

        d[1] = 1;
        if(N > 1){
            d[2] = 2;
            for(int i = 3; i < N + 1; i++){
                d[i] = (d[i - 2] + d[i - 1]) % 15746;
            }

            System.out.println(d[N]);
        }else System.out.println(d[N]);
    }
}
/*
틀린이유
1.  연산 결과를 나머지연산해주지않으면 오버플로우로 틀림.(틀림)
2. N = 1일경우 indexBound 에러로 예외처리좀해줘야함.(에러)
 */