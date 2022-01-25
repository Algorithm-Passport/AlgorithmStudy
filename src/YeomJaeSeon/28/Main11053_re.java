package baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main11053_re {
    static int N;
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N + 1];
        dp = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }

        for(int i = 1; i <= N; i++){
            for(int j = i - 1; j >= 1; j--){
                if(arr[i] > arr[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
}

/**
 * 가장 긴 증가하는 부분수열의 개수를 구해야함
 *
 * i번째의 최적의 해를 구할 때, 앞에 있는 녀석들과 비교하여 크면(증가 수열이면)
 * dp[i]값을 갱신해나가면 된다.
 */