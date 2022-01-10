package baekjoon.그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main16234 {
    static int N, L, R;
    static int[][] board;
    static boolean[][] visited;
    static boolean isEnd = true;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int days = 0;
    static List<int[]> dfsVisitedPositions;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        board = new int[N][N];
        visited = new boolean[N][N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // == bfs 로직 == //
//        while (true){
//            for(int i = 0; i < N; i++){
//                for(int j = 0; j < N; j++){
//                    if(bfs(i, j)) isEnd = false;
//                }
//            }
//
//            if(isEnd) break;
//            days++;
//            visited = new boolean[N][N];
//            isEnd = true;
//        }

        // == dfs 로직 == //
        while (true){
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    dfsVisitedPositions = new ArrayList<>();
                    dfs(i, j);

                    int sum = dfsVisitedPositions.stream().mapToInt(value -> board[value[0]][value[1]]).sum();

                    if(dfsVisitedPositions.size() > 1){
                        isEnd = false;
                    }
                    for (int[] visitedPosition : dfsVisitedPositions) {
                        board[visitedPosition[0]][visitedPosition[1]] = sum / dfsVisitedPositions.size();
                    }
                }
            }

            if(isEnd) break;
            days++;
            visited = new boolean[N][N];
            isEnd = true;
        }


        System.out.println(days);
    }
    // == dfs == //
    static void dfs(int x, int y){
        if(visited[x][y]) return;
        visited[x][y] = true;
        dfsVisitedPositions.add(new int[]{x, y});

        for(int i = 0; i < 4; i++){
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) continue;
            if(visited[nextX][nextY]) continue;
            if(Math.abs(board[x][y] - board[nextX][nextY]) >= L &&
                    Math.abs(board[x][y] - board[nextX][nextY]) <= R){
                dfs(nextX, nextY);
            }
        }
    }
    // == bfs == //
    static boolean bfs(int x, int y){
        if(visited[x][y]) return false;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;

        List<int[]> visitedPositions = new ArrayList<>();

        while (!q.isEmpty()){
            int[] current = q.poll();
            int currentX = current[0];
            int currentY = current[1];
            visitedPositions.add(new int[]{currentX, currentY});

            for(int i = 0; i < 4; i++){
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];

                if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) continue;
                if(visited[nextX][nextY]) continue;
                if(Math.abs(board[currentX][currentY] - board[nextX][nextY]) >= L &&
                Math.abs(board[currentX][currentY] - board[nextX][nextY]) <= R){
                    q.offer(new int[]{nextX, nextY});
                    visited[nextX][nextY] = true;
                }
            }
        }
        int sum = visitedPositions.stream().mapToInt(i -> board[i[0]][i[1]]).sum();

        if(visitedPositions.size() == 1){
            return false;
        }
        for (int[] visitedPosition : visitedPositions) {
            board[visitedPosition[0]][visitedPosition[1]] = sum / visitedPositions.size();
        }

        return true;
    }
    static void print(){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}

/**
 * bfs로 품
 * 한 노드가 옆에있는 노드로 갈수 있는 조건이 단순히 차이가 L 이상, R이하 밖에 추가가 되지않은 문제임
 *
 * 모든 노드를 시작으로 방문을 시작해야함. (연합이 여러개 존재할 수 있기 때문)
 * 무한루프 종료조건 생각하는게 좀 귀찮았다.
 *
 * 연합을 만들었으면 bfs메서드는 true를 반환하고 isEnd static 필드는 bfs가 true를 반환하면 false로 변경해 무한루프를 계속 도는 식으로 했다.
 * 즉, 연합을 만들 수 있으면 종료하지않고, 연합으 만들수 없으면 종료하였다.
 *
 * 물론 dfs로도 풀수 있음
 */