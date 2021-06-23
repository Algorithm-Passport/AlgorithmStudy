package baekjoon.자료구조;


//난이도별로 문제가 출제되어있음 1 - 하, N - 상
//먼저풀면 좋은 문제들이있음, 먼저풀면 그다음에 푸는 녀석은 쉽게풀림
//가능하면 쉬운문제부터 풀어야한다.
//N개문제 모두풀어야한다.

// 쉬운문제를 먼저푸는것보단 먼저풀면 좋은 문제를 먼저푸는것이 우선순위가 더높다.

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main1766 {
    static int N, M;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static int[] related;
    static boolean[] visited;
    static boolean[] visited2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        related = new int[N + 1];
        visited = new boolean[N + 1];
        visited2 = new boolean[N + 1];

        for(int i = 0; i < M; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
            int first = Integer.parseInt(st2.nextToken());
            int second = Integer.parseInt(st2.nextToken());
            visited[first] = true;
            visited[second] = true; // 관계있는 녀석찾으려고
            related[first] = second;
            pq.offer(first);
        }

        for(int i = 1; i <= N; i++){
            if(!visited[i]) pq.offer(i);
        }
        StringBuilder stringBuilder = new StringBuilder();

        while(!pq.isEmpty()){
            int v = pq.poll();
            while(visited2[v]) {
                v = pq.poll();
            }
            stringBuilder.append(v+" ");
            visited2[v] = true;
            if(related[v] != 0){
                pq.offer(related[v]);
            }
        }
        System.out.println(stringBuilder);
        br.close();
    }
}
