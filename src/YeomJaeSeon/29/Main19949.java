package algo_study.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main19949 {
    static int[] solutions = new int[10];
    static int[] result = new int[10];
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < 10; i++){
            solutions[i] = Integer.parseInt(st.nextToken());
        }

        recursive(0);

        System.out.println(count);
    }
    static void recursive(int m) {
        if (m == 10) {
            if(isUpper5()){
                count++;
            }
            return;
        }
        for (int i = 1; i <= 5; i++) {
            result[m] = i;
            if(isContinue(m)) {
                result[m] = 0;
                continue;
            }

            recursive(m + 1);

            result[m] = 0;
        }
    }
    static boolean isContinue(int m){
        int before = result[0];
        int sameCount = 1;
        for(int i = 1; i <= m; i++){
            if(before == result[i]){
                sameCount++;
            }else{
                before = result[i];
                sameCount = 1;
            }

            if(sameCount == 3) return true;
        }

        return false;
    }
    static boolean isUpper5(){
        int grade = 0;
        for(int i = 0; i < 10; i++){
            if(solutions[i] == result[i]) grade++;
        }
        if(grade >= 5) return true;

        return false;
    }
}

/**
 * 10개의 문제에 1 ~ 5번 무작위로 넣는 문제
 * 모든 경우를 넣어야한다.
 *
 * 백트래킹을 이용한다.
 * 가지치기의 조건은 '세개의 수가 연속되지 않는다'
 *
 * grade가 5이상이면 count 증가한다.
 *
 */