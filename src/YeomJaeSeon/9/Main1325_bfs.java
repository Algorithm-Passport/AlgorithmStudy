package baekjoon.그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main1325_bfs {
    static int N;
    static int M;
    static List<Integer>[] graph;
    static boolean[] visited;
    static int max = 0;
    static List<Integer> resultBox = new ArrayList<>(10000);

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
            int value = bfs(i);
            if(value > max){
                resultBox.clear();
                max = value;
                resultBox.add(i);
            }else if(max == value){
                resultBox.add(i);
            }
            Arrays.fill(visited, false);
        }
        Iterator<Integer> it = resultBox.iterator();
        while(it.hasNext()){
            System.out.print(it.next()+" ");
        }
    }
    static int bfs(int startNode){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startNode);
        visited[startNode] = true;
        int visitCnt = 1;

        while(!queue.isEmpty()){
            int node = queue.poll();
            for (Integer nodeValue : graph[node]) {
                if(!visited[nodeValue]){
                    queue.offer(nodeValue);
                    visited[nodeValue] = true;
                    visitCnt++;
                }
            }
        }

        return visitCnt;
    }
}

/**
 풀이
 1. 입력되는 형태를 바꿔야겠따고생각햇음 - 순서를 바꿈
 2. 그래프 형태로 또 바꿈
 3. BFS로품
 4. 배열의 요소를 List나 Set 등 클래스의 객체로 할떈 new로 요소들을 초기화하는 작업이 필요함.!
 **/