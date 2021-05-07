package baekjoon.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.valueOf(st.nextToken());
        int M = Integer.valueOf(st.nextToken());

        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < N; i++){
            set.add(br.readLine());
        }

        HashSet<String> set2 = new HashSet<>();
        for(int i = 0; i < M; i++){
            set2.add(br.readLine());
        }
        set.retainAll(set2);

        List<String> list = new ArrayList<>(set);
        Collections.sort(list);
        System.out.println(list.size());
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }
}

/**
 시간초과 1 : 배열로 완전탐색하려하니 최대 50만 * 50만 -> 1000억이넘음
 풀이
 1. HashSet 컬렉션 클래스를 이용함.
 HashSet컬렉션 클래스는 Hashing기법으로 해쉬함술릍 통해 해쉬테이블에 데이터에 접근하므로 굉장히빠름(해쉬테이블은 배열과 LinkedList구조)
 HashSet 클래스의 메서드인 retainAll(교집함)메서드로 품.
 **/