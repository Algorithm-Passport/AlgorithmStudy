package algo_study.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Main9342 {
    static int T;
    static final String SUCCESS_MSG = "Infected!";
    static final String FAIL_MSG = "Good";
    static List<Character> list = Arrays.asList('A', 'B', 'C', 'D', 'E', 'F');
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int i = 0;  i < T; i++){
            String str = br.readLine();
            if(checkString(str)) System.out.println(SUCCESS_MSG);
            else System.out.println(FAIL_MSG);
        }
    }
    static boolean checkString(String str){
        if(str.length() < 3) return false;

        // == 스택을 이용해 문자열을 축약하는 과정 == //
        Stack<Character> stack = new Stack<>();
        stack.push(str.charAt(0));
        for(int i = 1; i < str.length(); i++){
            if(stack.peek() == str.charAt(i)){
                continue;
            }
            stack.push(str.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        for (Character ch : stack) {
          sb.append(ch);
        }
        String shortStr = sb.toString();


        // == true인 조건만 뽑는 switch문 - 축약 문자열의 길이를 토대로 == //
        switch (shortStr.length()){
            case 3:
                if(isContainAFC(0, shortStr))
                    return true;
                break;
            case 4:
                if(isContainAFC(0, shortStr)){
                    if(list.contains(shortStr.charAt(3)))
                        return true;
                }else if(isContainAFC(1, shortStr)){
                    if(list.contains(shortStr.charAt(0)))
                        return true;
                }
                break;
            case 5:
                if(isContainAFC(1, shortStr)){
                    if(list.contains(shortStr.charAt(0)) &&
                    list.contains(shortStr.charAt(4)))
                        return true;
                }
                break;

        }
        return false;
    }
    // == AFC를 포함하는지 안하는지 확인 == //
    static boolean isContainAFC(int start, String totalString){
        StringBuilder subSb = new StringBuilder();
        for(int i = start; i < start + 3; i++){
            subSb.append(totalString.charAt(i));
        }

        if(subSb.toString().equals("AFC"))
            return true;
        return false;
    }
}
