package baekjoon.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main9935 {
    static String str;
    static String explodeStr;
    static Stack<Character> stack = new Stack<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        explodeStr = br.readLine();
        char lastChar = explodeStr.charAt(explodeStr.length() - 1);

        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            stack.push(ch);
            if(explodeStr.indexOf(ch) != -1){
                //폭발문자열 내의 문자이면
                if(ch == lastChar){
                    //폭발문자열의 마지막 문자이면
                    deleteExplodeStr();
                }
            }
        }
        if(stack.isEmpty()){
            System.out.println("FRULA");
        }else{
            StringBuilder sb = new StringBuilder();
            while(!stack.isEmpty()){
                sb.append(stack.pop());
            }
            System.out.println(sb.reverse().toString());
        }
    }
    static void deleteExplodeStr(){
        if(stack.size() < explodeStr.length()) return; // 폭발문자열의 길이보다 스택이 더적을수가있음. 왜냐면 폭발문자열의 끝문자일때만 이 메서드가 호출되기떄문에

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < explodeStr.length(); i++){
            sb.append(stack.pop());
        }

        //stack : a b c d e
        // sb : e d c
        // popExplodeStr = c d e (reverse)
        String popExplodeStr = sb.reverse().toString();
        if (!explodeStr.equals(popExplodeStr)) {
            //둘이 다르다면
            for(int i = 0; i < popExplodeStr.length(); i++){
                stack.push(popExplodeStr.charAt(i)); // 이거 실수함 pop한 string의 char를 넣어야하는데 explodeStr의 char를 넣고있엇음
            }
        }
    }

}

/**
 stack을 이용해야겠단 생각이 팍 들었음
 프로그래머스의 짝지어 제거하기 문제와 동일함

 stack에 들어가는 문자가 폭발문자열의 마지막 문자일때! 검사하는 메서드호출
 메서드내에서 검사하는 문자열과 폭발문자열이 다르다면 다시 원상복귀해야하므로 스택에 push함.
 **/