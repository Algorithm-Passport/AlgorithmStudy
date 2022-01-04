package algo_study.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main15721 {
    static int A, T, TYPE;
    static List<Integer> list = Arrays.asList(0, 1, 0, 1, 0, 0, 1, 1);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        A =  Integer.parseInt(br.readLine());
        T =  Integer.parseInt(br.readLine());
        TYPE = Integer.parseInt(br.readLine());

        int count = 1; // 회차
        int idx = 0; // 자리

        int gameIdx = 0;

        while(true){
            if(list.get(gameIdx) == TYPE){
                T--;
                if(T == 0){
                    break;
                }
            }


            gameIdx++;
            if(gameIdx == list.size()) {
                createNewList(++count);
                gameIdx = 0;
            }
            idx++;
            if(idx == A) idx = 0;
        }

        System.out.println(idx);
    }
    static void createNewList(int count){
        list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(0);
        list.add(1);
        // 뻔 추가
        for(int i = 0; i < count + 1; i++){
            list.add(0);
        }
        // 데기 추가
        for(int i = 0; i < count + 1; i++){
            list.add(1);
        }
    }
}

/**
 * 풀이
 *
 * 실제로 게임을 시뮬레이션하며 구현하여 품.
 *
 * 게임을 코드로 반영하는 실력이 늘었다.
 */