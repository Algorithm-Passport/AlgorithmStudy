package baekjoon.트리구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main9372 {
    public static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            solve(br);
        }
    }
    public static void solve(BufferedReader br) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); // 국가의수
        int M = Integer.parseInt(st.nextToken()); // 비행기종류
        boolean[] visited = new boolean[N + 1];

        int[][] inputArr = new int[M][2];
        List<Integer>[] list = new List[N + 1];
        for(int i = 0; i < N + 1; i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
            inputArr[i][0] = Integer.parseInt(st2.nextToken());
            inputArr[i][1] = Integer.parseInt(st2.nextToken());
        }

        for(int i = 1; i < N + 1; i++){
            for(int j = 0; j < M; j++){
                if(inputArr[j][0] == i) list[i].add(inputArr[j][1]);
                if(inputArr[j][1] == i) list[i].add(inputArr[j][0]);
            }
        }

        System.out.println(Arrays.toString(list));

        cnt = 0;
        dfs(1, visited, list);
        System.out.println(cnt);

    }
    public static void dfs(int startNode, boolean[] visited, List<Integer>[] list){
        visited[startNode] = true;

        for (Integer nation : list[startNode]) {
            if(!visited[nation]){
                cnt++;
                dfs(nation, visited, list);
            }
        }
    }
}

/**
 dfs로품
 **/