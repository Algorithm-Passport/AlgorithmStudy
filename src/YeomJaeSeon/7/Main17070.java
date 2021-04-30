package baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main17070 {
    public static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());

        int[][] graph = new int[N][N];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++){
                graph[i][j] = Integer.valueOf(st.nextToken());
            }
        }

        graph[0][0] = 1;
        dfs(graph,0, 0, 0, 1, N, 1);

        System.out.print(result);
    }
    // bx, by : 전칸, x, y : 현재칸
    public static void dfs(int[][] graph,int bx, int by, int x, int y, int N, int cnt){
        if(x < 0 || x >= N || y < 0 || y >= N)
            return;
        if(graph[x][y] != 0) return;
        if(x == N - 1 && y == N - 1) result += 1;
        // 가로모양 파이프 (ㅡ)
        if(bx == x && by + 1 == y){
            dfs(graph, x, y, x, y + 1, N, cnt + 1);
            dfs(graph, x, y, x + 1, y + 1, N, cnt + 1);
        }
        // 대각선 모양 (\)
        else if(bx + 1 == x && by + 1 == y){
            if(graph[bx][by + 1] != 0 || graph[bx + 1][by] != 0) {
                if(x == N - 1 && y == N - 1 && result > 0) result--;
                return;
            }
            dfs(graph, x, y, x, y + 1, N, cnt + 1);
            dfs(graph, x, y, x + 1, y + 1, N, cnt + 1);
            dfs(graph, x, y, x + 1, y, N, cnt + 1);
        }
        // 세로모양 파이프 (ㅣ)
        else if(bx + 1 == x && by == y){
            dfs(graph, x, y, x + 1, y, N, cnt + 1);
            dfs(graph, x, y, x + 1, y + 1, N, cnt + 1);
        }
    }
}

/**
 dfs로품

 틀린이유
 1. 대각선으로 목적지까지 파이프가 이동했을때 벽이 붙어있는 경우를 빼주지 않아서 틀림
 **/