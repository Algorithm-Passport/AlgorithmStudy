package baekjoon.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 다른 풀이 참고함.
public class Main1062_3 {
    static String[] strArr = new String[50];
    static boolean[] alphabet = new boolean[26];
    static final int ASCI = 97;
    static int N = 0;
    static int K = 0;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if(K < 5){
            System.out.println(0);
            System.exit(0);
        }
        if(K == 26){
            System.out.println(N);
            System.exit(0);
        }
        for(int i = 0; i < N; i++){
            strArr[i] = br.readLine();
        }

        alphabet['a' - ASCI] = true;
        alphabet['n' - ASCI] = true;
        alphabet['t' - ASCI] = true;
        alphabet['i' - ASCI] = true;
        alphabet['c' - ASCI] = true;
        K -= 5; // a n t i c5개는 무적건 있어야함

        dfs(0, 0); // 가르칠 알파벳(번호), 가르친 횟수
        System.out.println(max);
    }
    // 조합 dfs
    static void dfs(int word, int count){
        if(count == K){ // 26개중 K개를 고르면 ~ 조합 26 C K
            int teachWordCount = 0;
            for (String s : strArr) {
                if(s == null) break;
                boolean flag = true;
                // 한 문자열이 false가 있는지검사 하나라도있으면 break
                for(int i = 0; i < s.length();i++){
                    if(!alphabet[s.charAt(i) - ASCI]) {
                        flag = false;
                        break;
                    }
                }
                if(flag) teachWordCount++; // 읽을수있는 단어이므로 ++해줌.
            }
            max = Math.max(max, teachWordCount);
            return;
        }

        for(int i = word; i < 26; i++){
            if(!alphabet[i]){
                alphabet[i] = true;
                dfs(i, count + 1);
                alphabet[i] = false;
            }
        }
    }
}

/**
 풀이
 1. 26개의 알파벳중 C (K - 5) 의 조합을 구하는 문제
 2. 컬렉션클래스로 remove ~ 하면서하니 시간초과났음.
 3. alphabet이라는 index가 알파벳인 boolean배열을 false로 선언해놓고 선택된 알파벳은 true로 하며 조합을 이용함.
 4. 같은 조합이지만 2로한 풀이는 시간초과, 3으로한 풀이는 시간초과안남 컬렉션 클래스의 여러 메서드가 시간초과를 유발함
 5. dfs 조합으로품.
 **/