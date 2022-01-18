package baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1010_re {
    static int T;
    static int[][] dp = new int[31][31];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        //dp테이블 만들어놓기
//        for (int[] ints : dp) {
//            Arrays.fill(ints, -1);
//        }
        for(int i = 1; i <= 30; i++){
            dp[i][i] = 1;
            dp[1][i] = i;
        }
        for(int i = 1; i <= 30; i++){
            for(int j = 1; j <= 30; j++){
                if(i < j && dp[i][j] == 0){
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1];
                }
            }
        }

        //dp 테이블 출력
//        for (int[] ints : dp) {
//            System.out.println(Arrays.toString(ints));
//        }


        for(int i = 0; i < T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            System.out.println(dp[N][M]);


        }
    }
}

/**
 * 동적계획법은 점화식을 구하는게 뽀인트!
 * 2차원 dp테이블을 이용해야하는 문제
 *
 * 그림으로 직접 그리다 보면 규칙을 알게됨
 * dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1]
 *
 * 나도 풀고나서 다른사람의 풀이를 보고 알았는데 조합문제였다.
 * M개중 N개를 뽑는 MCN문제이다.
 *
 * 조합공식을 이용하는게 아닌 조합의 성질을 이용해야한다고한다.
 * m + 1 C n + 1 = m C n + m C n + 1
 * ==
 * dp[i + 1][j + 1] = dp[i][j] + dp[i][j + 1]
 *
 */