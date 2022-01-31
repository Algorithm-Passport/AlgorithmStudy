package algo_study.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main18429 {
    static int n, k;
    static int[] kits;
    static int[] result;
    static boolean[] visited;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        kits = new int[n];
        result = new int[n];
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++){
            kits[i] = Integer.parseInt(st.nextToken());
        }

        recursive(0, 500);

        System.out.println(count);
    }
    static void recursive(int m, int strength){
        if(m == n){
            count++;
            return;
        }

        for(int i = 0; i < n; i++){
            if(!visited[i]){
                int resultStrength = strength - k + kits[i];
                if(resultStrength < 500) continue;
                result[m] = i;
                visited[i] = true;

                recursive(m + 1, resultStrength);
                visited[i] = false;
            }
        }
    }
}

/**
 * 쉬운 백트래킹문제
 *
 * 키트를 하루에 하나씩 선택해야하므로 visited를 통해 같은 배열의 원소에 두번 접근하지 않도록 하면됨
 * 가지치기의 조건으 근력이 500 이하
 * 난 파라미터에 넣었즤만 메서드 하나 만들어 풀어도 될듯싶음
 */