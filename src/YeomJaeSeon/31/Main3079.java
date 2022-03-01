package algo_study.week8;
//N :입국심사대 개수
//M: 친구 수

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main3079 {
    static int N, M;
    static int[] T;
    static long answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        T = new int[N];
        for(int i = 0; i < N; i++){
            T[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(T);

        long left = 1;
        long right = (long)T[N - 1] * M;

        while(left <= right){
            long mid = (left + right) / 2;

            long peopleCnt = 0;
            for (int i : T) {
                peopleCnt += (mid / i);
            }

            if(peopleCnt < M){ // 모든 친구들 심사하지 못함
                left = mid + 1;
            }else{ //모든친구들은 심사했는데 더 시간을 효율적으로 사용할수 있음
                right = mid - 1;
                answer = mid;
            }
        }
        System.out.println(answer);
    }
}
