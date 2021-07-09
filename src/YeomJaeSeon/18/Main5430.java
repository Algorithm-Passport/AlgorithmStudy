package baekjoon.문자열;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main5430 {
    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());
        outer:
        for(int i = 0; i < T; i++){
            String p = br.readLine(); // 함수
            int n = Integer.parseInt(br.readLine()); // 배열 길이
            String arr = br.readLine(); //문자열 형태로들어오는 배열
            Deque<Integer> deque = new ArrayDeque<>();
            boolean isReverse = false; // true : 뒤, false : 앞 (R 함수관련)

            // deque 초기화
            if(n > 0){
                StringBuilder sb = new StringBuilder();
                for(int j = 1; j < arr.length() - 1; j++){
                    sb.append(arr.charAt(j));
                }
                StringTokenizer st = new StringTokenizer(sb.toString(), ",");

                while(st.hasMoreTokens()){
                    deque.add(Integer.parseInt(st.nextToken()));
                }
            }
            // n == 0이면 deque size : 0

            // 함수하나씩 실행
            for(int j = 0; j < p.length(); j++){
                if(p.charAt(j) == 'R'){
                    //뒤집기
                    isReverse = !isReverse;
                }else{
                    //버리기
                    if(deque.size() == 0){
                        bw.write("error\n");
                        continue  outer;
                    }else{
                        //삭제할게있으면
                        if(!isReverse){
                            //앞
                            deque.pollFirst();
                        }else{
                            //뒤
                            deque.pollLast();
                        }
                    }
                }
            }

            // 결과출력
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            if(!isReverse){
                while(!deque.isEmpty()){
                    sb.append(deque.pollFirst());
                    sb.append(',');
                }
            }else{
                while(!deque.isEmpty()){
                    sb.append(deque.pollLast());
                    sb.append(',');
                }
            }
            //결과가 []일때 ,를 삭제하려고 delete를하면 결과가 ]만 출력됨
            if(sb.length() > 2) sb.deleteCharAt(sb.length() - 1); // ,가있을때만..
            sb.append(']');

            bw.write(sb.toString()+"\n");
        }


        bw.flush();
        bw.close();
    }
}

/**
 deque을 이용해서 배열내 원소를 삭제하고 뒤집는것
 여기서중요한건
 R이나온다고 실제로 뒤집는게아니라
 boolean을 이용해서 deque의 앞을 삭제할지 뒤를 삭제할지만 정하고
 마지막에 isReverse가 true로 뒤집어야한담녀 그때 뒤집으면 됨
 즉 최대한번 최소 0면 뒤집는것

 **/