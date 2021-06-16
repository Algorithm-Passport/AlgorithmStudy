package baekjoon.그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1600_re {
    static int K, W, H;
    static int[][] board;
    static boolean[][][] visited;
    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, -1, 0, 1};

    static int hx[] = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int hy[] = {-2, -1, 1, 2, 2, 1, -1, -2};

    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        board = new int[H][W];
        visited = new boolean[K + 1][H][W]; // 말의 점프횟수, Height, Width

        for(int i = 0; i < H; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < W; j++){
                board[i][j] = Integer.parseInt(st2.nextToken());
            }
        }

        boolean re = bfs();

        if(re){
            System.out.println(answer);
        }else{
            System.out.println(-1);
        }
    }
    static boolean bfs(){
        Queue<Monkey> q = new LinkedList<>();
        visited[0][0][0] = true;
        q.offer(new Monkey(0, 0, 0, 0)); // 좌표, 점프횟수, 횟수


        while(!q.isEmpty()){
            Monkey monkey = q.poll();

            int cx = monkey.getX();
            int cy = monkey.getY();
            int jumCnt = monkey.getJumCnt();
            int count = monkey.getCount();

            if(cx == H - 1 && cy == W - 1) {
                answer = count;
                return true;
            }

            for(int i = 0; i < 4; i++){
                int nextX = cx + dx[i];
                int nextY = cy + dy[i];

                if(nextX < 0 || nextX >= H || nextY < 0 || nextY >= W) continue;
                if(visited[jumCnt][nextX][nextY]) continue;
                if(board[nextX][nextY] == 1) continue;
                visited[jumCnt][nextX][nextY] = true;
                q.offer(new Monkey(nextX, nextY, jumCnt, count + 1));
            }

            if(K > jumCnt){
                for(int i = 0; i < 8; i++){
                    int nextX = cx + hx[i];
                    int nextY = cy + hy[i];

                    if(nextX < 0 || nextX >= H || nextY < 0 || nextY >= W) continue;
                    if(visited[jumCnt + 1][nextX][nextY]) continue;
                    if(board[nextX][nextY] == 1) continue;
                    visited[jumCnt + 1][nextX][nextY] = true;
                    q.offer(new Monkey(nextX, nextY, jumCnt + 1, count + 1));
                }
            }
        }
        return false;

    }
}

class Monkey{
    private int x;
    private int y;
    private int jumCnt;
    private int count;

    Monkey(int x, int y, int jumCnt, int count){
        this.x = x;
        this.y = y;
        this.jumCnt = jumCnt;
        this.count = count;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getJumCnt() {
        return jumCnt;
    }

    public int getCount() {
        return count;
    }
}