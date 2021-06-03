package baekjoon.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main1463 {
    static int N;
    static final int SIZE = (int)1e6 + 1;
    static int[] d = new int[SIZE];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        d[1] = 0; // 1을 1로만드는 최솟값

        for(int i = 2; i < SIZE; i++){
            d[i] = d[i - 1] + 1; // 1차이나는것
            if(i % 3 == 0){ // 1차이나는것과 3으로 나누어지는것의 최솟값
                d[i] = Math.min(d[i / 3] + 1, d[i]);
            }
            if(i % 2 == 0){ // 위 조건식의 최솟값과 2나누어지는것의 최솟값
                d[i] = Math.min(d[i / 2] + 1, d[i]);
            }
        }// 결국 d[i]에는 최적의 해가들어감.

        System.out.println(d[N]);
    }
}

/**
 i가 3으로나누어지는것, 2로나누어지는것 1더해진 최솟값의 dp테이블을
 아래에서부터 위까지 바텀업으로 반복문으로 풀면됨

 **/