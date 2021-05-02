package baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main10844 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());

        long d[][] = new long[N + 1][10];

        for(int i = 1; i < 10; i++){
            d[1][i] = 1;
        }
        if(N > 1){
            for(int i = 0; i < 10; i++){
                d[2][i] = 2;
            }
            d[2][0] = 1;
            d[2][1] = 1;
            d[2][9] = 1;
            if(N > 2){
                for(int i = 3; i < N + 1; i++){
                    for(int j = 0; j < 10; j++){
                        if(j == 0) d[i][j] += d[i - 1][1];
                        else if(j == 9) d[i][j] += d[i - 1][8];
                        else d[i][j] += (d[i - 1][j - 1] + d[i - 1][j + 1]);
                        d[i][j] %= 1_000_000_000;
                    }
                }
            }
        }
        long sum = 0;
//        System.out.println(Arrays.deepToString(d));

        for(int i = 0; i < 10; i++){
            sum += d[N][i];
        }
        sum %= 1_000_000_000;
        System.out.println(sum);
    }
}

/**
 틀렸습니다
 1. 초기화실수
 2. int 이차원배열과 int sum으로했더니 틀림 -> long으로 바꿔서 오버플로우 막음.. long - 8byte, int 4byte

 풀이
 숫자를 넣는데 N을넣으면 이전 숫자는 N - 1이거나 N + 1이어야한다.
 이차원배열을 통해서 d[i][N] +=( d[i - 1][N - 1] + d[i - 1][N + 1] )점화식을 풀되
 N이 0일떄와 9일떄를 조심해서 푼다. 그떄는 d[i][0] += d[i-1][1]이다.. 9도 마찬가지 이전수는 8일수밖에
 경우를 계속 메모해가며 푸는 DP ! 로품.. (바텀업으로) - 반복문 과 메모이제이션
 **/