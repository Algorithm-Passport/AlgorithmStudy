package algo_study.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main11047 {
    static int n, k;
    static List<Integer> coins = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++){
            coins.add(Integer.parseInt(br.readLine()));
        }

        coins.sort(Comparator.reverseOrder());

        int result = getCount();

        System.out.println(result);
    }
    static int getCount(){
        int count = 0;
        for (Integer value : coins) {
            if(k >= value){
                count += (k / value);
                k -= ((k / value) * value);
            }
        }

        return count;
    }
}

/**
 * Ai (i >= 2)는 Ai-1의 배수다는 조건이 있으므로 그리디가 가능하다.
 *
 * 그렇지 않으면 동적계획법을 이용해야한다.
 *
 * 왜냐면 배수라면 k를 작은 값으로 쪼갠것보다, 큰 값으로 조개는 것이 동전의 최솟값임을 보장하기 떄문이다.
 * 배수가 아니면 보장할 수가 없다.
 */