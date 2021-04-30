package baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main11057 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());

        int[][]d = new int[N+1][10];
        for(int i = 0; i < 10; i++){
            d[1][i] = 1;
        }
        if(N > 1) {
            for (int i = 2; i < N + 1; i++) {
                for (int j = 0; j < 10; j++) {
                    for(int k = 0; k <= j; k++){
                        d[i][j] += d[i - 1][k];
                    }
                    d[i][j] %= 10007;
                }
            }
        }
        int sum = 0;
        for(int i = 0; i < 10; i++){
            sum += d[N][i];
        }
        System.out.println(sum % 10007);
    }
}

/**
 1. 틀렸습니다 : 점화식 잘못 구함. - d[i][j] = d[i-1][10 - j] * 10; 이런식으로함.
 2. %안함
 3. sum에도 %해야하는데 안함

 풀이
 i번째 숫자를 넣으려하는상황에서
 i - 1번째 숫자의 상황을 생각
 i번째 N을 넣는다면
 i - 1에는 0 ~ N까지 총 N개를 넣을수있음
 2차원배열에서 (int[][] arr = new int[X][10];)
 각 2차원 배열 내의 원소는 각 경우의 결과들임
 그래서 d[i][N] += (d[i - 1][0] + d[i - 1][1] .... + d[i - 1][N])
 점화식으로품
 **/