package baekjoon.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main1062 {
    public static List<Set<Character>> list = new ArrayList<>(100);
    public static int max = 0;
    public static Set<Character> allWords = new HashSet<>();
    public static void main(String[] args) throws IOException {
        // a n t c i - 5개는 알려줘야함
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if(K < 5) System.out.println(0);
        else{
            for(int i = 0; i < N; i++) {
                String str = br.readLine();
                String subStr = str.substring(4, str.length() - 4);
                
                Set<Character> set = new HashSet<>(100);
                
                for(int j = 0; j < subStr.length(); j++){
                    if(subStr.charAt(j) != 'a' && subStr.charAt(j) != 'n' && subStr.charAt(j) != 't' && subStr.charAt(j) != 'c' && subStr.charAt(j) != 'i') {
                        set.add(subStr.charAt(j));
                        allWords.add(subStr.charAt(j));
                    }
                }
                // List는 Set을 원소로갖는다
                list.add(set);
            }

            int wordNum = K - 5;
            // allWords중 wordNum 의 조합 을 구해야함 일단.
            // 그러기위해선 Set이아닌 List로 살짞 변환해준다.
            List<Character> setToList = new ArrayList<>(allWords);

            boolean[] visited = new boolean[setToList.size()];
            combination(setToList, visited, setToList.size(), 0, wordNum);

            System.out.println(max);
        }

    }
    // 조합
    public static void combination(List<Character> setToList, boolean[] visited, int length, int start, int M){
        if(M == 0){
            List<Character> testCases = new ArrayList<>(100);
            for(int i = 0; i < length; i++){
                if(visited[i] == true){
                    testCases.add(setToList.get(i));
//                    System.out.println(setToList.get(i) + " " );
                }
            }
//            System.out.println();
            List<Set<Character>> copyList = copyListSet(list);

            boolean flag = false;
            for(int i = 0; i < copyList.size(); i++){
                copyList.get(i).removeAll(testCases);
                if(copyList.get(i).size() == 0) {
                    flag = true;
                    break;
                }
            }
            if(flag == true){
                int teachWords = checkAnswer(testCases);
                if(max < teachWords) max = teachWords;
            }
        }
        for(int i = start; i < length; i++){
            visited[i] = true;
            combination(setToList, visited, length, i + 1, M - 1);
            visited[i] = false;
        }
    }
    public static int checkAnswer(List<Character> testCases){
        List<Set<Character>> copyList = copyListSet(list);

        for(int i = 0; i < copyList.size(); i++){
            if(copyList.get(i).size() <= testCases.size())
                copyList.get(i).removeAll(testCases);
        }

        int answer = 0;
        for(int i = 0; i < copyList.size(); i++){
            if(copyList.get(i).size() == 0) answer++;
        }
        return answer;
    }
    static public List<Set<Character>> copyListSet(List<Set<Character>> list){
        List<Set<Character>> copyList = new ArrayList<>(100);

        for(int i = 0; i < list.size(); i++){
            copyList.add(new HashSet<>(list.get(i)));
        }
        return copyList;
    }
}

/** 시간초과..
 **/