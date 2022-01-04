package algo_study.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main2503 {
    static int N;
    static String str;
    static int strikes, balls;
    static Set<String> sets = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            str = st.nextToken();
            strikes = Integer.parseInt(st.nextToken());
            balls = Integer.parseInt(st.nextToken());

            if(i == 0){
                Set<String> set = containPossibleNumbers();
                sets.addAll(set);
            }else{
                sets.retainAll(containPossibleNumbers());
            }
        }

        System.out.println(sets.size());
    }
    static Set<String> containPossibleNumbers(){
        Set<String> set = new HashSet<>();
        for(int i = 1; i <= 9; i++){
            for(int j = 1; j <= 9; j++){
                if(i == j) continue;
                for(int k = 1; k <= 9; k++){
                    if(k == i || k == j) continue;
                    StringBuilder sb = new StringBuilder();
                    sb.append(i);
                    sb.append(j);
                    sb.append(k);

                    if(isOk(sb.toString())){
                           set.add(sb.toString());
                    }
                }
            }
        }

        return set;
    }
    static boolean isOk(String target){
        //target str 이 strikes balls 관계면 true return
        int stCnt = 0;
        int baCnt = 0;
        for(int i = 0; i < 3; i++){
            if(str.charAt(i) == target.charAt(i)){
                stCnt++;
            }else{
                for(int j = 0; j < 3; j++){
                    if(i == j) continue;
                    if (str.charAt(i) == target.charAt(j)) {
                        baCnt++;
                    }
                }
            }
        }

        if(strikes == stCnt && balls == baCnt) return true;

        return false;
    }
}

/**
 * N이 최대 100개
 * 9 ^ 3 * 100 = 72900으로 적은 경우수
 * 브루투 포스로 완전탐색 가능
 *
 * 모든 경우의 수에 대해서 strike, ball이 되는 수를 교집합으로 계속 구해나가면 된다.
 *
 * 나는 백트래킹 문제인지 알았다. 사실 백트래킹으로 풀어도 된다.
 * 그러나 재귀함수를 이용하기보단, 단순히 for문으로 완전탐색이 가독성이 좋아 그리 풀었다.
 */