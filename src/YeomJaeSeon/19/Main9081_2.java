package baekjoon.구현;

import java.io.*;
import java.util.Arrays;

public class Main9081_2 {
    static int T;
    static String original;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            original = br.readLine();
            char[] charArr = original.toCharArray();

            int[] intArr = new int[charArr.length];
            for(int j = 0; j < charArr.length; j++){
                intArr[j] = (int)charArr[j] - 65;
            }

            int idx = -1;
            int idx2= -1;

            for (int j = intArr.length - 1; j >= 1; j--) {
                if (intArr[j] > intArr[j - 1]) {
                    idx = j - 1; // 증가하지않는 idx찾기
                    break;
                }
            }

            if(idx == -1){
                bw.write(original+"\n");
            }else{

                int num = intArr[idx];
                for(int j = intArr.length - 1; j >= 0; j--){
                    if(num < intArr[j]){
                        idx2 = j; // idx의 수보다 큰 수의 위치를 저장
                        break;
                    }
                }

                int tmp = intArr[idx];
                intArr[idx] = intArr[idx2];
                intArr[idx2] = tmp;
                // 위치 바꾸기

                Arrays.sort(intArr, idx + 1, intArr.length);
                // 증가하지않는 위치의 바로 뒤쪽은 전부 정렬

                StringBuilder sb = new StringBuilder();
                for (int v : intArr) {
                    sb.append((char)(v + 65));
                }
                bw.write(sb.toString()+"\n");
            }
        }

        bw.flush();
        bw.close();
    }
}

/**
 바로 다음 순열을 찾는문제

 틀린이유
 1. 백트래킹으로 풀려함 - 입력되는 문자열의 길이가 99일수도있음 . 시간초과

 풀이
 바로 다음순열을 찾는 로직이 존재하여 해당 로직을 이용해서풀면됨
 1. 뒤에서부터 증가하지않는 첫번째 위치를 찾는다.
 2. 또 다시 뒤에서부터 1에서 찾은 idx의 원소보다 큰 첫번째 위치를 찾는다
 3. 두 위치의 값을 서로 바꾸고 1에서 찾은 증가하지않는 첫번째 idx + 1 부터는 전부 사전순으로 정렬을 한다.

 **/