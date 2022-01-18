package baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1463_re {
    //3 or 2
    static int N;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];

        int count = 0;

        //무조건 큰수로 나누는게 최소 연산 횟수가 되는것을 보장할수 없음
//        while (N > 1) {
//            if (N % 3 == 0) N /= 3;
//            else if (N % 2 == 0) N /= 2;
//            else N -= 1;
//            count++;
//        }
//
//        System.out.println(count);
        dp[1] = 0;

        for(int i = 2; i <= N; i++){
            int min = Integer.MAX_VALUE;
            if(i % 3 == 0) min = Math.min(min, dp[i / 3] + 1);

            if(i % 2 == 0) min = Math.min(min, dp[i / 2] + 1);

            min = Math.min(min, dp[i - 1] + 1);
            dp[i] = min;
        }

        System.out.println(dp[N]);
    }

}
/**
 * 무조건 큰수로 나누어진다 해서 큰수부터 고르는게 최소 연산 횟수를 보장할수 없다.
 *
 * 동적계획법을 이용한다. dp테이블을 이용한 메모이제이션을 통해 바텀업의 방법으로 메모를 해나가며 최소값을 갱신해 나간다.
 * 큰 문제를 작은 문제로 나누는데 항상 같은 결과를 도출해애냐 사용할수 있다.
 *
 * N 이 1보다 큰줄 알았음 그래서 한번 틀림
 */