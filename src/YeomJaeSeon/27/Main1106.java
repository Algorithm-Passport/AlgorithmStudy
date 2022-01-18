package baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main1106 {
    static int N, C;
    static int[] dp;
    static List<MyCustomer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        C = Integer.parseInt(st.nextToken()); // 늘려야할 고객수
        N = Integer.parseInt(st.nextToken()); // 도시의 개수

        dp = new int[C + 1];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int price = Integer.parseInt(st.nextToken());
            int people = Integer.parseInt(st.nextToken());

            list.add(new MyCustomer(price, people));
        }

        // 최소 비용 구하기
        recursive(0);


        // 쪼갤수없으므로, 그리디가 아닌 동적계획법으로 풀어야하는 배낭문제이다.
    }
}

class MyCustomer{
    int price;
    int people;

    public MyCustomer(int price, int people) {
        this.price = price;
        this.people = people;
    }
}