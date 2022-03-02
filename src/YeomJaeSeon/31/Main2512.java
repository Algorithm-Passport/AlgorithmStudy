package algo_study.week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2512 {
    static int N, M;
    static int[] cities;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        cities = new int[N];
        for(int i = 0; i < N; i++){
            int price = Integer.parseInt(st.nextToken());
            cities[i] = price;
        }
        M = Integer.parseInt(br.readLine());

        Arrays.sort(cities);

        int left = 0;
        int right = cities[N - 1];

        while(left <= right){
            int mid = (left + right) / 2;
            int sum = 0;
            for (int city : cities) {
                if(city >= mid) sum += mid;
                else sum += city;
            }

            if(sum > M)
                right = mid - 1;
            else {
                left = mid + 1;
                answer = Math.max(answer, mid);
            }
        }
        System.out.println(answer);

    }
}
/**
 * binarySearch로 상한액 갱신해나가면 된다.
 *
 * 왜 binarySearch?
 *
 */