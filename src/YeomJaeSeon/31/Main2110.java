package algo_study.week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2110 {
    static int N, C;
    static int[] x;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        x = new int[N];
        for(int i = 0; i < N; i++){
            x[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(x);

        int left = 1;
        int right = x[N - 1] - x[0];
        while(left <= right){
            int mid = (left + right) / 2; // interval 공유기사이의 간격

            int installedWifiCount = calculateInstalledWifiCount(mid);

            if(installedWifiCount >= C){ //설치한 공유기가 더많을 땐 간격을 더 키워서 가장큰 간격을 찾을 필요가 있음
                answer = Math.max(answer, mid);
                left = mid + 1;
            }else{
                right = mid - 1;//설치한 공유기 수가 설치해야할 수보다 적을땐 간격을 줄여서라도 설치 공유기 개수를 늘려야함
            }
        }

        System.out.println(answer);
    }
    static int calculateInstalledWifiCount(int interval){
        int position = x[0];
        int count = 1;

        for(int i = 1; i < N; i++){
            if(position + interval <= x[i]){
                count++;
                position = x[i];
            }
        }

        return count;
    }
}
