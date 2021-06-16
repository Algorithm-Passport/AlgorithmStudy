package baekjoon.그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 1은 땅, 0은 바다
public class Main4963 {
    static int w,h;
    static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};
    static int[][] board;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if(w == 0 && h == 0) break;

            board = new int[h][w];
            answer = 0;

            for(int i = 0; i < h; i++){
                StringTokenizer st2 = new StringTokenizer(br.readLine());
                for(int j = 0; j < w; j++){
                    board[i][j] = Integer.parseInt(st2.nextToken());
                }
            }

            for(int i = 0; i < h; i++)
                for(int j = 0; j < w; j++) {
                    if(bfs(i, j)) answer++;
                }

            System.out.println(answer);
        }
    }

    static boolean bfs(int x, int y){
        if(board[x][y] == 0) return false;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        board[x][y] = 0;

        while(!q.isEmpty()){
            int[] poll = q.poll();
            int cx = poll[0];
            int cy = poll[1];

            for(int i = 0; i < 8; i++){
                int nextX = cx + dx[i];
                int nextY = cy + dy[i];

                if(nextX < 0 || nextX >= h || nextY < 0 || nextY >= w) continue;
                if(board[nextX][nextY] == 0) continue;
                q.offer(new int[]{nextX, nextY});
                board[nextX][nextY] = 0;
            }
        }

        return true;
    }
}

/**
 큐 방문처리를 이상하게해서 메모리초과남
 q에서 pop될때만 방문처리함 - 큐에 중복된 요소가 많음
 그냥 큐에넣을떄 방문처리했더니 해결
 **/