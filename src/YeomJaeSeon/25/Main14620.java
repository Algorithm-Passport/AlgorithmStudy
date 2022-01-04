package algo_study.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main14620 {
    static int N;
    static int[][] board;
    static int min = 22000;
    static int[][] result = new int[3][2];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        for(int i = 0; i < 3; i++){
            result[i][0] = -1;
            result[i][1] = -1;
        }

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recursive(0, 0);

        System.out.println(min);
    }
    static void recursive(int m, int price){
        if(m == 3){
            min = Math.min(min, price);
            return;
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                result[m] = new int[]{i, j};
                if(!meet()){
                    //아무 꽃이 죽으면 않으면
                    result[m] = new int[]{-1, -1};
                    continue;
                }
                int calculatePrice = getPrice(i, j);

                recursive(m + 1, price + calculatePrice);

                result[m] = new int[]{-1, -1};
            }
        }
    }
    static boolean meet(){
        boolean[][] visited = new boolean[N][N];
        for(int k = 0; k < 3; k++){
            int[] pos = result[k];
            if(Arrays.equals(pos, new int[]{-1, -1})) continue;

            int currentX = pos[0];
            int currentY = pos[1];

            if(visited[currentX][currentY]) return false;
            visited[currentX][currentY] = true;

            for(int k2 = 0; k2 < 4; k2++){
                int nextX = currentX + dx[k2];
                int nextY = currentY + dy[k2];
                if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) return false;
                if(visited[nextX][nextY]) return false;

                visited[nextX][nextY] = true;
            }
        }
        return true;
    }
    static int getPrice(int i, int j){
        int sum = board[i][j];
        for(int k = 0; k < 4; k++){
            int nextX = i + dx[k];
            int nextY = j + dy[k];

            sum += board[nextX][nextY];
        }

        return sum;
    }
}

/**
 * 백트래킹으로 품
 *
 * 가지치기 조건 : 꽃이 죽는것.
 * 하나의 경우 조건 : m == 3 이때 최소가격 min 갱신해나가면 됨.
 */