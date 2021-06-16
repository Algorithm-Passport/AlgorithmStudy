package baekjoon.그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main2210 {
    static Set<String> set = new HashSet<>();
    static int[][] board = new int[5][5];

    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < 5; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < 5; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                dfs(i, j, "");
            }
        }

        System.out.println(set.size());

    }
    static void dfs(int x, int y, String s){
        s += board[x][y];

        if(s.length() == 6){
            set.add(s);
            return;
        }

        for(int i = 0; i < 4; i++){
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if(nextX < 0 || nextX >= 5 || nextY < 0 || nextY >= 5) continue;

            dfs(nextX, nextY, s);
        }
    }
}
