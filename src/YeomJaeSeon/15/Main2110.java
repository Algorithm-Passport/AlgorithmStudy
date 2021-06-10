package baekjoon.BS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 가장 인접한 두 공유기 사이의 거리는 최대로!
public class Main2110 {
    static int homes[];
    static int N, C;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        homes = new int[N];
        for(int i = 0; i < N; i++){
            homes[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(homes);

        binarySearch(1, homes[N - 1] - homes[0]); // 간격 1부터 최대간격까지 전달
        //start = 1, end = homes[N - 1] - homes[0]

        System.out.println(result);

    }
    static void binarySearch(int start, int end){
        if(start > end) return;

        int mid = (start + end) / 2; //공유기간 간격

        int count = calcCount(mid); //mid 간격을 가지고 설치한 공유기 개수

        if(C > count){ // 공유기를 더 적게설치했으면
            binarySearch(start, mid - 1); // 간격을 더작게 설정
        }else if(C <= count){ // 공유기를 더 많이설정하거나 같게설정했으면
            result = Math.max(result, mid); // 조건에 충족되기때문에 최대값저장해놓고
            binarySearch(mid + 1, end); // 더 큰 간격이 있을수도있으니 간격을 더 크게설정한다.
        }
    }
    static int calcCount(int dist){
        int position = homes[0]; // 공유기 첫집에설치
        int count = 1; // 설치한공유기 개수
        for(int i = 1; i < N; i++){
            if(position + dist <= homes[i]){
                count++;
                position = homes[i];
            }
        }
        return count;
    }

}

/**
 최소간격 1 ~ 최대간격 homes[N - 1] - homes[0]
 1부터 최대간겪까지 하나씩 비교하면서 설치한 공유기 개수가 C가 될때까지 찾고
 최대값을 찾으면 O(N^2) - 시간너무걸림
 이진탐색으로

 조건은 설치한 공유기 개수를 기준으로 이진탐색을함

 **/