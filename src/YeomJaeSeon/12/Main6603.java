package baekjoon.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main6603 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String input = br.readLine();
            if(input.equals("0"))
                break;
            StringTokenizer st = new StringTokenizer(input, " ");
            int k = Integer.parseInt(st.nextToken());
            int[] arr = new int[k];
            for(int i = 0; i < k; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            boolean[] visited = new boolean[k];
            combination(0, arr, visited, 0, k);
            System.out.println();
        }
    }
    static void combination(int startIdx, int[] arr, boolean[] visited, int M, int length){
        if(M == 6){
            for(int i = 0; i < length; i++){
                if(visited[i]) System.out.print(arr[i]+" ");
            }
            System.out.println();
            return;
        }
        for(int i = startIdx; i < length; i++){
            visited[i] = true;
            combination(i + 1, arr, visited,M + 1, length);
            visited[i] = false;
        }
    }
}

/**
 풀이
 조합구하는 문제임
 재귀로 조합을 구함(가지치기 필요없는 완전탐색으로)
 **/