package baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main9465 {
    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[2][n];
            int[][] dp = new int[2][n];

            for(int j = 0; j < 2; j++){
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for(int k = 0; k < n; k++){
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            if(n == 1){
                System.out.println(Math.max(arr[0][0], arr[1][0]));
            }else if(n == 2){
                int first = Math.max(arr[1][0] + arr[0][1], arr[0][0]); // 위에
                int second = Math.max(arr[0][0] + arr[1][1], arr[1][0]);//아래

                System.out.println(Math.max(first, second));
            }else{
                dp[0][0] = arr[0][0];
                dp[1][0] = arr[1][0];

                dp[0][1] = Math.max(arr[0][1] + arr[1][0], arr[0][0]);
                dp[1][1] = Math.max(arr[1][1] + arr[0][0], arr[1][0]);

                for(int k = 2; k < n; k++){
                    for(int j = 0; j < 2; j++){
                        if(j == 0){
                            // 윗줄
                            dp[j][k] = Math.max(dp[1][k - 2] + arr[j][k], dp[1][k - 1] + arr[j][k]);
                        }else{
                            //아랫줄
                            dp[j][k] = Math.max(dp[0][k - 2] + arr[j][k], dp[0][k - 1] + arr[j][k]);
                        }
                    }
                }

                int maxA = Arrays.stream(dp[0]).max().getAsInt();
                int maxB = Arrays.stream(dp[1]).max().getAsInt();

                System.out.println(Math.max(maxA, maxB));
            }
        }
    }
}

/**
 * 2차원 dp 테이블 이용
 *
 * 해당 위치의 스티커를 둔다했을 때의 경우의수를 생각하며 최적의 해를 갱신하면됨
 *
 * i번째의 위에있는 스티커 샌택했을 경우는
 * i - 1 번째 아래있는 스티커 선택한 경우의 최적의 해 vs i - 2번째 아래있는 스티커 선택한 경우의 최적의해
 * 중 최대값에 i번째 스티커 점수를 더하면 된다.
 */