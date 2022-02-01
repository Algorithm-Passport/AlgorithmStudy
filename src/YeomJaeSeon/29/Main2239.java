package algo_study.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2239 {
    static int[][] board = new int[9][9];
    static final int ASCII = 48;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < 9; i++){
            String str = br.readLine();
            for(int j = 0; j < 9; j++){
                board[i][j] = str.charAt(j) - ASCII;
            }
        }

        recursive(0);
    }

    static void recursive(int m){
        if(m == 81){
            for(int i = 0; i < 9; i++){
                for(int j = 0; j < 9; j++){
                    System.out.print(board[i][j]);
                }
                System.out.println();
            }
            System.exit(0);
        }

        int i = m / 9;
        int j = m % 9;

        if(board[i][j] != 0) {
            recursive(m + 1);
        }else{
            for(int v = 1; v <= 9; v++){
                board[i][j] = v;
                if(!isSudoku(i, j)){
                    board[i][j] = 0;
                    continue;
                }

                recursive(m + 1);

                board[i][j] = 0;
            }
        }
    }
    static boolean isSudoku(int x, int y){
        for(int i = 0; i < 9; i++){
            if(i == x) continue;
            if(board[i][y] == board[x][y]) return false;
        }

        for(int i = 0; i < 9; i++){
            if(i == y) continue;
            if(board[x][i] == board[x][y]) return false;
        }

        int standardX = (x / 3) * 3;
        int standardY = (y / 3) * 3;

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(standardX + i == x && standardY + j == y) continue;
                if(board[standardX + i][standardY + j] == board[x][y]) return false;
            }
        }

        return true;
    }
}

/**
 * 수도쿠 백트래킹
 * 간단함
 *
 * 종료조건이 되는 m 이 81( 9 * 9 스도쿠 판 크기) 일떄까지 하나씩 칸에 1 ~ 9의 수를 넣어보면됨
 * 적절한지, 적절하지 않은지 판단하는 가지치기 조건으로 운이좋다면 많은 경우를 줄일 수 있다.
 */