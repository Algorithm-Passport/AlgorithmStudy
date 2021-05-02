package baekjoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2048 {
    static int max = 0;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());
        int[][] board = new int[N][N];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++){
                board[i][j] = Integer.valueOf(st.nextToken());
            }
        }
        // 상하좌우를 총 다섯번 4 * 4 * 4 * 4 * 4
        // 0 : 상, 1 : 하, 2 : 좌, 3: 우
        for(int i1 = 0; i1 < 4; i1++){
            for(int i2 = 0; i2 < 4; i2++){
                for(int i3 = 0; i3 < 4; i3++){
                    for(int i4 = 0; i4 < 4; i4++){
                        for(int i5 = 0; i5 < 4; i5++){
                            int[][] newBoard = new int[board.length][board.length];
                            for(int i = 0; i < board.length; i++){
                                for(int j = 0; j < board.length; j++){
                                    newBoard[i][j] = board[i][j];
                                }
                            }

                            resultBoard(newBoard, i1);
                            resultBoard(newBoard, i2);
                            resultBoard(newBoard, i3);
                            resultBoard(newBoard, i4);
                            resultBoard(newBoard, i5);


                            for(int i = 0; i < newBoard.length; i++){
                                for(int j = 0; j < newBoard.length; j++){
                                    if(max < newBoard[i][j]){
                                        max = newBoard[i][j];
                                    }
                                }
                            }
//                            System.out.printf("%d %d %d %d %d%n", i1, i2, i3, i4, i5);
//                            System.out.println("Arrays.deepToString(newBoard) = " + Arrays.deepToString(newBoard));
                        }
                    }
                }
            }
        }
//        resultBoard(board, 2);
//        resultBoard(board, 3);
//        System.out.println("Arrays.deepToString(newBoard) = " + Arrays.deepToString(board));

        System.out.println(max);

    }
    public static void resultBoard(int[][] newBoard, int num){
        for(int i = 0; i < newBoard.length; i++){
            for(int j = 0 ; j < newBoard.length; j++){
                switch(num){
                        // 위
                    case 0:
                        moveToZero(newBoard, num);
//                        for(int k = 0; k < newBoard.length - 1; k++){
//                            if(newBoard[k])
//                        }
                        i = newBoard.length - i - 1;
//                        j = newBoard.length - j - 1;
                        if(i == 0) break;
                        if(newBoard[i - 1][j] == newBoard[i][j]) {
                            newBoard[i - 1][j] += newBoard[i][j];
                            if(i == newBoard.length - 1){
                                newBoard[i][j] = 0;
                                break;
                            }
                        }
                        break;
                        // 아래
                    case 1:
                        moveToZero(newBoard, num);

                        if(i == newBoard.length - 1) break;
                        if(newBoard[i + 1][j] == newBoard[i][j]) {
                            newBoard[i + 1][j] += newBoard[i][j];
                            if(i == 0){
                                newBoard[i][j] = 0;
                                break;
                            }
                        }
                        break;
                        // 좌
                    case 2:
                        moveToZero(newBoard, num);

//                        i = newBoard.length - i - 1;
                        j = newBoard.length - j - 1;
                        if(j == 0)break;
                        if(newBoard[i][j - 1] == newBoard[i][j]){
                            newBoard[i][j - 1] += newBoard[i][j];
                            if(j == newBoard.length - 1) {
                                newBoard[i][j] = 0;
                                break;
                            }
                        }
                        break;
                        // 우
                    case 3:
                        moveToZero(newBoard, num);

                        if(j == newBoard.length - 1)break;
//                        if(newBoard[i][j + 1] == 0)
                        if(newBoard[i][j + 1] == newBoard[i][j]){
                            newBoard[i][j + 1] += newBoard[i][j];
                            if(j == 0){
                                newBoard[i][j] = 0;
                                break;
                            }
                        }
                        if(newBoard[i][j + 1] == 0)
                        break;
                    default:
                        break;
                }
            }
        }

    }
    public static void moveToZero(int[][] board, int num){
        if(num == 0) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board.length; j++) {
                    if(board[j][i] == 0){
                        if(j == board.length - 1) break;
                        int k = j + 1;
                        while(board[k][i] == 0){
                            ++k;
                            if(k == board.length) break;
                        }
                        if(k != board.length) {
                            board[j][i] = board[k][i];
                            board[k][i] = 0;
                        }
//                        board[i][j - 1] = board[i][j];
//                        board[i][j] = 0;
                    }
                    //
//                    if(board[i - 1][j] == 0){
//                        int k = i;
//                        while(board[k][j] != 0){
//                            ++k;
//                            if(k == board.length) break;
//                        }
//                        if(k != board.length) {
//                            board[i - 1][j] = board[k][j];
//                            board[k][j] = 0;
//                        }
//                    }
//                    while(board[i - 1][j] != 0){
//                        board[i - 1][j] = board[i][j];
//                        board[i][j] = 0;
//                    }
                }
            }
        }
        else if(num == 1){
            for (int i = 0; i < board.length - 1; i++) {
                for (int j = board.length - 1; j >= 0; j--) {
                    if(board[j][i] == 0){
                        if(j == 0) break;
                        int k = j - 1;
                        while(board[k][i] == 0){
                            --k;
                            if(k == -1) break;
                        }
                        if(k != -1) {
                            board[j][i] = board[k][i];
                            board[k][i] = 0;
                        }
//                        board[i][j + 1] = board[i][j];
//                        board[i][j] = 0;
                    }
//                    while(board[i + 1][j] != 0){
//                        board[i + 1][j] = board[i][j];
//                        board[i][j] = 0;
//                    }
                }
            }
        }
        else if(num == 2){
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board.length; j++) {
                    if(board[i][j] == 0){
                        if(j == board.length - 1) break;
                        int k = j + 1;
                        while(board[i][k] == 0){
                            ++k;
                            if(k == board.length) break;
                        }
                        if(k != board.length) {
                            board[i][j] = board[i][k];
                            board[i][k] = 0;
                        }
//                        board[i][j - 1] = board[i][j];
//                        board[i][j] = 0;
                    }
//                    while(board[i][j - 1] != 0){
//                        board[i][j - 1] = board[i][j];
//                        board[i][j] = 0;
//                    }
                }
            }
        }
        else{
            // 오른쪽으로 밀어야함.
//            for(int i = 0; i < board.length; i++){
//                bo
//            }

            for (int i = 0; i < board.length; i++) {
                for (int j = board.length - 1; j >= 0; j--) {
                    if(board[i][j] == 0){
                        if(j == 0) break;
                        int k = j - 1;
                        while(board[i][k] == 0){
                            --k;
                            if(k == -1) break;
                        }
                        if(k != -1) {
                            board[i][j] = board[i][k];
                            board[i][k] = 0;
                        }
//                        board[i][j + 1] = board[i][j];
//                        board[i][j] = 0;
                    }
//                    while(board[i][j + 1] != 0){
//                        board[i][j + 1] = board[i][j];
//                        board[i][j] = 0;
//                    }
                }
            }
        }


    }
}
