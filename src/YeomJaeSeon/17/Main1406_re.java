package baekjoon.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main1406_re {
    static List<Character> init = new LinkedList<>();
    static String word;
    static int M;
    static ListIterator<Character> iterator;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        word = br.readLine();
        M = Integer.parseInt(br.readLine());

        for(int i = 0; i < word.length(); i++){
            init.add(word.charAt(i));
        }
        iterator = init.listIterator(init.size());

        for(int i = 0; i < M; i++){
            String cmd = br.readLine();
            command(cmd);
        }

        StringBuilder sb = new StringBuilder();
        init.stream().forEach(item -> sb.append(item));
        System.out.println(sb);
    }
    static void command(String cmd){
        if(cmd.length() == 1){
            if(cmd.equals("L")){
                if(iterator.hasPrevious()) iterator.previous();
            }else if(cmd.equals("D")){
                if(iterator.hasNext()) iterator.next();
            }else if(cmd.equals("B")){
                if(iterator.hasPrevious()) {
                    iterator.previous();
                    iterator.remove();
                }
            }
        }else{
            StringTokenizer st = new StringTokenizer(cmd, " ");
            st.nextToken();
            char word = st.nextToken().charAt(0);
            iterator.add(word);
        }
    }
}

/**
 요소 중간에서 삭제와 추가가 잦기 때문에 배열 기반 X -> 무조건 시간초과
 LinkedList를 이용해야함
 ListIterator를 통해서 추가나 삭제를함. (커서의 움직임을 ListIterator를 통해 구현 - previous(), next()를 통홰 양방향이동 가능 - iterator와 다름)
 listIterator는 remove()하기전에 previous()를 호출을 무조건해줘야함. 그렇지않으면 IllegalStateException 발생 -> previous()로 현재 위치지정
 System.out.println()으로 출력하면 시간초과
 StringBuilder로 하나의 문자열로 출력하면 시간 초과해결가능
 **/