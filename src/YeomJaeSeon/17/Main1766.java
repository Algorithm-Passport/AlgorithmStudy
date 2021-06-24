package baekjoon.자료구조;

import java.io.*;
import java.util.*;

public class Main1766 {
    static int N, M;
    static int[] inDegree;
    static List<List<Integer>> list = new ArrayList<>(32001);
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        inDegree = new int[N + 1];
        for(int i = 0; i < N + 1; i++) list.add(new ArrayList<>());

        for(int i = 0; i < M; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            list.get(a).add(b);
            inDegree[b]++;// 진입차수 만큼 더해줌
        }

        topologySort();

        bw.flush();
        bw.close();
    }
    static void topologySort() throws IOException{
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 1; i < N + 1; i++){
            if(inDegree[i] == 0) pq.offer(i);
        }


        while(!pq.isEmpty()){
            int v = pq.poll();
            bw.write(v + " ");

            if(list.get(v).size() > 0){
                for (Integer v2 : list.get(v)) {
                    if(--inDegree[v2] == 0) pq.offer(v2);
                }
            }
        }
    }
}
/**
 5 2
 2 4
 4 5

 ->
 1 2 3 4 5

 4 2
 4 2
 3 1
 3 1 4 2

 5 2
 4 2
 2 1

 3 4 2 1 5
 **/

/**
 위상정렬
 - 사이클 X 그래프에서 어떠한 노드에서 다른 노드로가는 경로가 단방향으로 주어졌을때,
 정렬하는 방법

 -> 진입차수 0인녀석을 큐에넣고 빼면서 연결되는 간선을 뺌
 -> 진입차서 0인녀석 부터 접근하는 방법임.
 -> 모두 방문전 진입차수가 0인녀석이 없으면 사이클있는 그래프라는뜻 (방문전 큐가 비었다면)
 -> 가능하면 작은수이므로 우선순위큐를 이용함. (정수 오름차순정렬이 정렬기준임)
 **/