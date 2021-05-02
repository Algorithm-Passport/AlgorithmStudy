package baekjoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1051 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s, " ");
        int a = Integer.valueOf(st.nextToken());
        int b = Integer.valueOf(st.nextToken());

        int[][] arr = new int[a][b];
        for(int i = 0; i < a; i++){
            String inputString = br.readLine();
            for(int j = 0; j < b; j++){
                arr[i][j] = Integer.valueOf(String.valueOf(inputString.charAt(j)));
            }
        }

        int minValue = a > b ? b : a;
        int maxValue = a > b ? a : b;

        int result = 0;

        outer:
        while(minValue > 1){
            for(int i = 0; i < b - minValue + 1; i++){
                for(int j = 0; j < a - minValue + 1; j++){
                    if(isSquare(i, j, minValue, arr) == true){
                        result = minValue * minValue;
                        break outer;
                    }

                }
            }
            minValue--;
        }
        if(result == 0){
            System.out.println(1);
        }else System.out.println(result);
    }
    public static boolean isSquare(int x, int y, int length, int[][] arr){
        // x : 열 y : 행
            if(arr[y][x] == arr[y + length - 1][x] && arr[y + length - 1][x] == arr[y][x+length-1] && arr[y][x+length-1] == arr[y + length - 1][x + length - 1])
                return true;
            return false;
    }
}
