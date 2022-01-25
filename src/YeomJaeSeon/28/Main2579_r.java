package baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main2579_r {
    static int N;
    static int[] arr;
    static int[] dp = new int[301];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        for(int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        if(N == 1){
            System.out.println(arr[1]);
        }else if(N == 2){
            System.out.println(arr[1] + arr[2]);
        }else if(N == 3){
            System.out.println(Math.max(arr[1] + arr[3], arr[2] + arr[3]));
        }else{
            dp[1] = arr[1];
            dp[2] = arr[1] + arr[2];
            dp[3] = Math.max(arr[1] + arr[3], arr[2] + arr[3]);
            for(int i = 4; i <= N; i++){
                dp[i] = Math.max(dp[i - 2] + arr[i], dp[i - 3] + arr[i - 1]+ arr[i]);
            }
            System.out.println(dp[N]);
        }
    }
}
/**
 * dp
 * 큰문제를 작은 문제들로 나눌수있어.
 * 1. 중간의 값 i를 통해 일반항 찾기
 * 2. 케이스들을 생각해서 일반항 찾기
 */
