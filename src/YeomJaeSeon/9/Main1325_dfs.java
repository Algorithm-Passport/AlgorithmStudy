package baekjoon.그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main1325_dfs {
    static int N;
    static int M;
    static List<Integer>[] graph;
    static boolean[] visited;
    static int max = 0;
    static List<Integer> resultBox = new ArrayList<>(10000);
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        int[][] inputArr = new int[M][2];

        // graph ArrayList로 초기화
        for(int i = 0; i < N + 1; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
            int b = Integer.parseInt(st2.nextToken());
            int a = Integer.parseInt(st2.nextToken());
            inputArr[i][0] = a;
            inputArr[i][1] = b;
        }
        // [[1, 3], [2, 3], [3, 4], [3, 5]] 이런식으로 앞뒤바뀌어서저장됨.

        for(int i = 1; i < N + 1; i++){
            for(int j = 0; j < M; j++){
                if(i == inputArr[j][0]) graph[i].add(inputArr[j][1]);
            }
        }
        // graph는 [] [3] [3] [4, 5] [] [] 형태임.
        for(int i = 1; i < N + 1; i++){
            dfs(i);
            if(cnt > max){
                resultBox.clear();
                max = cnt;
                resultBox.add(i);
            }else if(max == cnt){
                resultBox.add(i);
            }
            cnt = 0;
            Arrays.fill(visited, false);
        }
        Iterator<Integer> it = resultBox.iterator();
        while(it.hasNext()){
            System.out.print(it.next()+" ");
        }
    }
    static void dfs(int startNode){
        if(!visited[startNode]) {
            visited[startNode] = true;
            cnt++;
        }

        for (Integer nodeValue : graph[startNode]) {
            if(!visited[nodeValue]){
                dfs(nodeValue);
            }
        }
    }
}

/**
 풀이
 1. 입력되는 형태를 바꿔야겠따고생각햇음 - 순서를 바꿈
 2. 그래프 형태로 또 바꿈
 3. dfs로품
 **/