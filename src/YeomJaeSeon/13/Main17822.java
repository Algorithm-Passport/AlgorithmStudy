package baekjoon.시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 원판이 케이크모양으로 존재함(옆에서 삼각형모양)
public class Main17822 {
    static int N, M, T;
    static int[][] graph;
    static int x, d, k;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static boolean[][] visited;
    static Deque<Integer> deque;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); // 원판 2 ~ 50
        M = Integer.parseInt(st.nextToken()); // 각원판의 수 : 2 ~ 50
        T = Integer.parseInt(st.nextToken());// TEST CASE 수

        deque = new ArrayDeque<>(); //덱을 이용해서 원판 회전구현

        graph = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];
        for(int i = 1; i < N + 1; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for(int j = 1; j < M + 1; j++){
                graph[i][j] = Integer.parseInt(st2.nextToken());
            }
        }
        for(int i = 0; i < T; i++){
            boolean isChange = false;
            // test start
            StringTokenizer st3 = new StringTokenizer(br.readLine(), " ");
            x = Integer.parseInt(st3.nextToken()); // 배수
            d = Integer.parseInt(st3.nextToken()); // 0 : 시계, 1 : 반시계
            k = Integer.parseInt(st3.nextToken()); // 회전할 칸수

            // x배수 원판 회전시키기
            for(int j = 1; j < N + 1; j++){
                if(j % x != 0) continue;

                if(d == 1){
                    //반 시계방향
                    for(int c = 0; c < k; c++){
                        // k칸회전
                        for(int count = 1; count < M + 1; count++) deque.offer(graph[j][count]);
                        int popNum = deque.pollFirst();
                        deque.offerLast(popNum);

                        for(int count = 1; count < M + 1; count++) graph[j][count] = deque.pollFirst();
                    }
                }else{
                    //시계방향
                    for(int c = 0; c < k; c++){
                        // k칸회전
                        for(int count = 1; count < M + 1; count++) deque.offer(graph[j][count]);
                        int popNum = deque.pollLast();
                        deque.offerFirst(popNum);

                        for(int count = 1; count < M + 1; count++) graph[j][count] = deque.pollFirst();

                    }
                }
            }


            // 인접하면서 같은수 삭제
            for(int i1 = 1; i1 < N + 1; i1++){
                for(int j1 = 1; j1 < M + 1; j1++) {
                    if (isSameAneClose(i1, j1)) {
                        isChange = true;
                    }
                }
            }
            // 위 반복문이 끝나면 인접하면서 같은 요소들의 위치의 visited 원소는 true로변함. 하나라도 true로변했으면 isChange도 true

            // 숫자없애기 - visited가 true는 같은 요소만 접근한것이므로 삭제 - 0으로 변경
            for(int i2 = 1; i2 < N + 1; i2++) {
                for (int j2 = 1; j2 < M + 1; j2++) {
                    if (visited[i2][j2]) graph[i2][j2] = 0;
                }
            }

            // visited 배열초기화
            for(int i2 = 1; i2 < N + 1; i2++)
                for(int j2 = 1; j2 < M + 1; j2++)
                    visited[i2][j2] = false;


            //else 평균보다 큰수는 -1, 평균보다 작은수는 +1
            // 하나도 삭제된게없으면
            if(!isChange){
                int sum = 0;
                int cnt = 0;
                for(int i1 = 1; i1 < N + 1; i1++) {
                    for (int j1 = 1; j1 < M + 1; j1++) {
                        if (graph[i1][j1] != 0) cnt++;
                        sum += graph[i1][j1];
                    }
                }

                double avg = (double)sum / cnt;

                for(int i1 = 1; i1 < N + 1; i1++)
                    for(int j1 = 1; j1 < M + 1; j1++){
                        if((double)graph[i1][j1] > avg){
                            graph[i1][j1] -= 1;
                        }else if((double)graph[i1][j1] < avg && graph[i1][j1] != 0){
                            graph[i1][j1] += 1;
                        }
                    }
            }

        }

        //결과
        int sum = 0;
        for(int i = 1; i < N + 1; i++)
            for(int j = 1; j < M + 1; j++)
                sum += graph[i][j];

        System.out.println(sum);


    }
    static boolean isSameAneClose(int x, int y){
        boolean isChange = false;
        if(visited[x][y]) return false;
        if(graph[x][y] == 0) return false;

        // bfs
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});

        while(!q.isEmpty()){
            int[] value = q.poll();

            if(visited[value[0]][value[1]]) continue;
            visited[value[0]][value[1]] = true;

            for(int i = 0; i < 4; i++){
                int nextX = value[0] + dx[i];
                int nextY = value[1] + dy[i];
                if(nextX < 1 || nextX > N || nextY < 1 || nextY > M){
                    continue;
                }
                if(visited[nextX][nextY]) continue;
                if(graph[nextX][nextY] == 0) continue;

                if(graph[value[0]][value[1]] == graph[nextX][nextY]) {
                    isChange = true;
                    q.offer((new int[]{nextX, nextY}));
                }
            }
            // 행 체크할떄.
            if(value[1] == 1){
                if(graph[value[0]][value[1]] == graph[value[0]][M]) {
                    isChange = true;
                    if(!visited[value[0]][M]) q.offer(new int[]{value[0], M});
                }
            }else if(value[1] == M){
                if(graph[value[0]][value[1]] == graph[value[0]][1]) {
                    isChange = true;
                    if(!visited[value[0]][1])q.offer(new int[]{value[0], 1});
                }
            }

        }
        if(!isChange){
            visited[x][y] = false;
        }
        return isChange;
    }
}

/**
 풀이
 1. 원판 회전 - 덱을 이용
 2. 인접하면서 같은숫자를 찾는과정 - bfs이용

 틀렸습니다.
 - 인접하면서 같은 숫자를 찾는 로직을 찾고 바로 0으로 변경해서 틀림

 시간초과(메모리초과)
 - visited를 갱신하는로직을 2차원배열 각 요소 돌떄마다 갱신 -> 초기화, 갱신 -> 초기화...
 - 그냥 visited만 게속 갱신하고 TestCase 한번 끝나면 visited갱신으로 바꿨더니 해결

 틀렸습니다.
 - isSameAndClose메서드의 예외처리하는 부분이 틀림(visited가 true이면 바로 리턴, graph의 값이 0이면(값이 이미 삭제가 되어있으면) 리턴)
 - 후자의 예외처리를 빼먹어서 틀림 - 그래서 isChange가 false로 하나도 변경이일어나지않았을경우의 처리가 안되었음

 **/