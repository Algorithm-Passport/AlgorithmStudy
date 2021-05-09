package baekjoon.그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main1058 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] graph = new char[N][N];

        int max = 0;

        for(int i = 0; i < N; i++){
            String s = br.readLine();
            for(int j = 0; j < N; j++){
                graph[i][j] = s.charAt(j);
            }
        }

        for(int i = 0; i < N; i++){
            int cnt = 0;
            for(int j = 0; j < N; j++){
                if(i == j) continue;
                if(graph[i][j] == 'Y') cnt++;
                else{
                    for(int k = 0; k < N; k++){
                        if(j == k) continue;
                        if(graph[k][j] == 'Y' && graph[i][k] == 'Y') {
                            cnt++;
                            break;
                        }
                    }
                }
            }
            max = Math.max(max, cnt);
        }
        System.out.println(max);
    }
}
/**
 * 틀렸습니다.
 * 1. 문제잘못이해함
 * 2. 문제를 잘못품. 공통의친구 찾는 로직을 잘못짬
 *
 * 풀이
 * - 친구이면 cnt++하고 친구하니면 해당 세로열을 탐색하면서 공통의 친구있는지 확인함.
 */
