package algo_study.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 9 4, 9 4 1 4
 * 13 + 18 = 31
 *
 * 4 1 4 9 9
 *
 * 9 9 4 1 4
 * 27 + 27 = 54
 *
 *
 */

public class Main21758 {
    static int N;
    static int[] arr;
    static int max = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        max = Math.max(getEnd(0), getEnd(N - 1));

        max = Math.max(getIntervalLeft(), max);

        max = Math.max(getIntervalRight(), max);

        System.out.println(Math.max(max, getBetween()));

    }
    static int getEnd(int start){
        int sum = 0;
        if(start == 0){
            for(int i = 2; i < N; i++){
                sum += arr[i];
            }
        }else{
            for(int i = 0; i < N - 2; i++){
                sum += arr[i];
            }
        }


        return sum * 2;
    }
    static int getIntervalLeft(){
        int subMax = -1;

        int criticSum = 0;
        for(int i = 1; i < N; i++){
            criticSum += arr[i];
        }

        //벌의 위치
        for(int i = 1; i < N - 1; i++){
            int sum1 = 0;
            for(int j = i + 1; j < N; j++){
                sum1 += arr[j];
            }
            subMax = Math.max(subMax, criticSum - arr[i] + sum1);
        }

        return subMax;
    }
    static int getIntervalRight(){
        int subMax = -1;

        int criticSum = 0;
        for(int i = 0; i < N - 1; i++){
            criticSum += arr[i];
        }

        //벌의 위치
        for(int i = N - 2; i >= 0; i--){
            int sum1 = 0;
            for(int j = i - 1; j >= 0; j--){
                sum1 += arr[j];
            }
            subMax = Math.max(subMax, criticSum - arr[i] + sum1);
        }


        return subMax;
    }
    static int getBetween(){
        int subMax = -1;

        // i 는 벌꿀통 위치
        for(int i = 1; i < N - 1; i++){
            //left
            int sum1 = 0;
            for(int j = 1; j <= i; j++){
                sum1 += arr[j];
            }
            int sum2 = 0;
            //right
            for(int j = N - 2; j >= i; j--){
                sum2 += arr[j];
            }
            subMax = Math.max(subMax, sum1 + sum2);
        }


        return subMax;
    }
}
