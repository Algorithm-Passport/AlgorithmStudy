package baekjoon.그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1525 {
    static int[][] answerBoard = new int[][]{
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 0}
    };
    static int[][] myBoard = new int[3][3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < 3; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < 3; j++){
                myBoard[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(!Arrays.deepEquals(myBoard, answerBoard)){
            //tring to..
        }
    }
}
