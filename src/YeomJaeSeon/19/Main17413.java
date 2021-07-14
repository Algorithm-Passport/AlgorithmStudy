package baekjoon.구현;

import java.io.*;

public class Main17413 {
    static String str;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        str = br.readLine();

        StringBuilder sb = new StringBuilder(str);

        int start = 0;
        int end = 0;
        boolean isWord = true;

        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '<'){
                if(end != 0){
                    StringBuilder s = new StringBuilder();
                    for(int j = start; j <= end; j++){
                        s.append(str.charAt(j));
                    }
                    String reverseStr = s.reverse().toString();
                    sb.replace(start, end + 1, reverseStr);
                }
                isWord = false;
            }else if(str.charAt(i) == '>'){
                start = i + 1;
                isWord = true;
            }else if(isWord && str.charAt(i) == ' '){
                StringBuilder s = new StringBuilder();
                for(int j = start; j <= end; j++){
                    s.append(str.charAt(j));
                }
                String reverseStr = s.reverse().toString();
                sb.replace(start, end + 1, reverseStr);

                start = i + 1;
            }else if(i == str.length() - 1){
                // 마지막문자
                StringBuilder s = new StringBuilder();
                for(int j = start; j <= end + 1; j++){
                    s.append(str.charAt(j));
                }
                String reverseStr = s.reverse().toString();
                sb.replace(start, str.length() + 1, reverseStr);

            }
            end = i;
        }
        bw.write(sb.toString()+"\n");

        bw.flush();
        bw.close();

    }
}

/**
 단어인 곳을 식별해서 단어가 시작하는 곳의 위치를 start변수에 담고,
 start부터 end(현재 i)까지를 뒤집어서 변경해서 넣었음.
 단어인곳을 식별하는건 isWord라는 boolean변수로 단어인지 아닌지 식별하였꼬, >가 끝난다음을 start로, ' '가 끝난 다음위치를 단어의 start로 하여서 품
 **/