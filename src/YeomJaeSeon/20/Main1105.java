package baekjoon.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1105 {
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String str1 = st.nextToken();
        String str2 = st.nextToken();

        result = countEight(str1, str2);

        System.out.println(result);
    }
    static int countEight(String str1, String str2){
        if(str1.length() == str2.length()){
            //같은 자리수
            int count = 0;
            for(int i = 0; i < str2.length(); i++){
                if(str1.charAt(i) == str2.charAt(i)){
                    if(str1.charAt(i) == '8') count++;
                }else{
                    break;
                }
            }
            return count;

        }else{
            //다른 자리수
            return 0;
        }
    }
}
/**
 * 주어진 두 수 사이(두 수 포함) 8의 개수가 가장적은 수의 8의 개수를 구하라는 문제이다.
 *
 * 틀린이유
 * 1. 808 808 반례에 대해서 생각못함.
 *
 * 풀이
 * L이 1이고 R이 20억이면
 * 최소의 8의개수를 찾는 완전탐색하면 시간초과날것이다.
 * 두 숫자의 길이 (문자열일때 length())가 다르면 8의 개수의 최소는 0이다.
 * 두 숫자의 길이가 다르단 말은 두 숫자사이엔 숫자가 존재하고
 * 두 숫자가 길이가 다르면서 gap이 가장 작은 경우는 9와 10이다. 이경우에도 8이없으므로 8의 개수는 0으로 확신할수있음
 *
 * 두 숫자의 길이가 같은경우 8이존재할수있는데
 * 8이 존재하려면 각 자리가 8일 경우밖에없다.
 * 가장큰 자리수의 수를 하나하나 비교하며 같으면 계속하다, 8이나오면 count를 늘려가주는 식으로한다음
 * count를 리턴했다.
 *
 */
