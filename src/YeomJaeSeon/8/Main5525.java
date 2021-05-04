package baekjoon.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main5525 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int s_len = Integer.parseInt(br.readLine());
        String s = br.readLine();

        int cnt = 0;
        int answer = 0;

        for(int i = 0; i < s_len - 2; i++){
            if(s.charAt(i) == 'I' && s.charAt(i + 1) == 'O' && s.charAt(i + 2) == 'I'){
                ++cnt;
                i++;
                if(cnt == N){
                    answer++;
                    cnt--;
                }
            }else{
                cnt = 0;
            }
        }

        System.out.println(answer);
    }
}

/**
 시간초과 : Pn을만들려고했음 만드는 과정 자체가 시간초과를 유발함
 물론 O(N * M)으로 하나씩 비교해도 시간초과나지만 이문제는 Pn만드는 과정자체가 시간초과남
 PN만들필요없이 입력되는 N값을 이용하면됨
 연속되는 패턴의 문자열이므로 단순히 O(N)으로 비교함
 **/