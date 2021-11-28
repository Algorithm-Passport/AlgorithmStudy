package algo_study.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main6550 {
    static String S, T;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String inputStr = null;
        while((inputStr = br.readLine()) != null){
            StringTokenizer st = new StringTokenizer(inputStr, " ");
            S = st.nextToken();
            T = st.nextToken();

            if(S.length() > T.length())
                System.out.println("No");
            else{
                int ptr = 0;
                for(int i = 0; i < T.length(); i++){
                    if(T.charAt(i) == S.charAt(ptr)){
                        ptr++;
                        if(ptr == S.length()) break;
                    }
                }
                if(ptr == S.length())
                    System.out.println("Yes");
                else
                    System.out.println("No");
            }
        }
    }
}
