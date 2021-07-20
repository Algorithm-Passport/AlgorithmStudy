package baekjoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//1(1) -> 5(2) -> 9(3) -> 13(4)
public class Main10994 {
    static int n;
    static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        int v = n * 4 - 3;

        board = new char[v][v];

        displayStar(0, v, v);

        for(int i = 0; i < v; i++){
            for(int j = 0; j < v; j++){
                if(board[i][j] == '*')
                    System.out.print('*');
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }

    static void displayStar(int start, int n, int v){
        if(n <= 0) return;
        for(int i = 0; i < n; i++){
            board[start][start + i] = '*';
            board[start + i][start] = '*';
            board[v - 1 - start][start + i] = '*';
            board[start + i][v - 1 - start] = '*';
        }

        displayStar(start + 2, n - 4, v);
    }
}

/**
 재귀함수를 이용한 별찍기

 2차원 배열을 이용해서 별을찍었음.
 **/