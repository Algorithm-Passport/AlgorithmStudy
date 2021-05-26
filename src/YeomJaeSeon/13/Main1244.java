package baekjoon.시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1244 {
    static int N, people;
    static int[] state;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 스위치 개수
        state = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1; i < N + 1; i++){
            state[i] = Integer.parseInt(st.nextToken());
        }
        people = Integer.parseInt(br.readLine());
        for(int i = 0; i < people; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
            int sex = Integer.parseInt(st2.nextToken());
            int number = Integer.parseInt(st2.nextToken());

            if(sex == 1){
                //남
                int v = 1;
                while(number * v <= N){
                    state[number * v] = state[number * v] == 1 ? 0 : 1;
                    ++v;
                }
            }else{
                //여
                int dist = 1;
                while(number + dist <= N && number - dist >= 1 && state[number + dist] == state[number - dist]){
                    ++dist;
                }
                dist -= 1;
                for(int j = number - dist; j <= number + dist; j++){
                    state[j] = state[j] == 1 ? 0 : 1;
                }
            }
        }
        for(int i = 1; i < N + 1; i++) {
            System.out.print(state[i] + " ");
            if(i % 20 == 0) System.out.println();
        }
    }
}

/**
 틀림1 : 스위치 개수 + 1로한뒤 배열만들었는데 까먹고 적용안함
 **/