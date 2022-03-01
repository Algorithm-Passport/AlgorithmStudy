package algo_study.week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main22871 {
    static int N;
    static int[] rocks;
    static long answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        rocks = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < N; i++){
            rocks[i] = Integer.parseInt(st.nextToken());
        }

        long left = 0;
        long right = (long) (N - 1) * (1 + Math.abs(rocks[0] - rocks[N - 1]));

        while(left <= right){
            long mid = (left + right) / 2;

            boolean isPossible = true;

            for(int i = 0; i < N - 1; i++){
                int v = 1 + Math.abs(rocks[i] - rocks[i + 1]);
                if(v > mid) {
                    isPossible = false;
                    break;
                }
            }

            if(isPossible){
                //갈수있으면 최적의 해를 찾자
                right = mid - 1;
                answer = mid;
            }else{
                //갈수 없으면 K를 늘리자
                left = mid + 1;
            }
        }
        System.out.println(answer);
    }
}
