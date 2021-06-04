package baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main1495_re {
    static int N, S, M;
    static int[] a;
    static int[][] d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        a = new int[N + 1];
        d = new int[N + 1][M + 1];
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        for(int i = 1; i <= N; i++){
            a[i] = Integer.parseInt(st2.nextToken());
        }

        int nextV1 = S + a[1] <= M ? S + a[1] : -1;
        int nextV2 = S - a[1] >= 0 ? S - a[1] : -1;
        if(nextV1 != -1) d[1][nextV1] = 1;
        if(nextV2 != -1) d[1][nextV2] = 1;

        for(int i = 2; i < N + 1; i++){
            for(int j = 0; j < M + 1; j++){
                if(d[i - 1][j] == 1){
                    int nextV11 = j + a[i] <= M ? j + a[i] : -1;
                    int nextV22 = j - a[i] >= 0 ? j - a[i] : -1;
                    if(nextV11 != -1)d[i][nextV11] = 1;
                    if(nextV22 != -1)d[i][nextV22] = 1;
                }
            }
        }

        Long count = IntStream.of(d[N]).filter(i -> i == 1).count();

        if(count == 0){
            System.out.println(-1);
        }else{
            for(int i = M; i >= 0; i--){
                if(d[N][i] == 1) {
                    System.out.println(i);
                    break;
                }
            }
        }
    }
}


/**
 N * 2 의 dp테이블로 더했을때, 뺼떄의 각각 최대값만 저장햇는데
 반례가 존재함..
 N * M테이블로 만들어서 dp테이블만듬
 **/