package baekjoon.BS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main2805 {
    static long result = 0;
    static int N;
    static long M, H;
    static long[] trees;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        trees = new long[N];
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < N; i++){
            trees[i] = Integer.parseInt(st2.nextToken());
        }

        H = Arrays.stream(trees).max().getAsLong(); // trees의 최대값을 H로설정
        binarySearch(0, H);
        System.out.println(result);

    }
    static void binarySearch(long start, long end){
        while(start <= end){
            long mid = (start + end) / 2;
            long total = 0;
            for (long tree : trees) {
                if(tree > mid) total += (tree - mid);
            }
            if(total < M){
                end = mid - 1;
            }else{
                result = mid;
                start = mid + 1;
            }
        }
    }
}

/**
 파라메트릭서치 - 특정 조건에서의 최대, 최소값문제 -> 결정(예/아니오)문제로 풀기
 M이 20억, 순차탐색으로 다 찾아가며 total 갱신해가면 시간초과
 BS로푼다.

 total은 20억이 넘을수도있으므로 int가아닌(int는 +- 20억) long으로 변경
 **/