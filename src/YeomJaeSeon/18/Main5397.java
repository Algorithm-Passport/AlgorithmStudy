package baekjoon.문자열;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Main5397 {
    static int T;
    static List<String> password;
    static ListIterator<String> listIterator;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            //test case
            password = new LinkedList<>();
            listIterator = password.listIterator();
            String str = br.readLine();

            for(int j = 0; j < str.length(); j++){
                String word = String.valueOf(str.charAt(j));
                if(word.equals("<")){
                    goLeft();
                }else if(word.equals(">")){
                    goRight();
                }else if(word.equals("-")){
                    backSpace();
                }else{
                    //command가 아닌 문자들
                    listIterator.add(word);
                }
            }
            //출력
            password.stream().forEach(o -> {
                try {
                    bw.write(o);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
    static void goLeft(){
        if(listIterator.hasPrevious()) listIterator.previous();
    }
    static void goRight(){
        if(listIterator.hasNext()) listIterator.next();
    }
    static void backSpace(){
        if(listIterator.hasPrevious()){
            listIterator.previous(); // 해줘야함
            listIterator.remove();
        }
    }
}

/**
 listIterator를 통한 양방향 LinkedList 탐색

 지난주 에디터와 동일한문제
 **/