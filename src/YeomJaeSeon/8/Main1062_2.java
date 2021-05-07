package baekjoon.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main1062_2 {
    static Set<Character> allWords = new HashSet<>(10000);
    static List<Set<Character>> list = new ArrayList<>();
    static int max = 0;
    static boolean[] alphabet = new boolean[26];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); // <= 50
        int K = Integer.parseInt(st.nextToken()); // 0 <= K <= 26

        // N개의 각단어는 8 ~ 15 의길이
        //a n t i c 은 무조건 가르쳐야하는 5글자임

        if(K < 5){
            System.out.println(0);
            System.exit(0);
        }
        if(K == 26){
            System.out.println(N);
            System.exit(0);
        }

        for(int i = 0; i < N; i++){
            String s = br.readLine();
            String substring = s.substring(4, s.length() - 4);
            Set set = new HashSet(30);
            for(int j = 0; j < substring.length(); j++){
                if(substring.charAt(j) == 'a' ||
                substring.charAt(j) == 'n' ||
                substring.charAt(j) == 't' ||
                substring.charAt(j) == 'i' ||
                substring.charAt(j) == 'c') continue;
                allWords.add(substring.charAt(j));
                set.add(substring.charAt(j));
            }
            list.add(set);
        }

        boolean[] visited = new boolean[allWords.size()]; // allWords.size() C K - 5 조합임
        List<Character> setToList = new ArrayList<>(allWords);
        combination(visited, 0, allWords.size(), setToList, K - 5);
        System.out.println(max);
    }
    public static void combination(boolean[] visited, int start, int length, List<Character> setToList ,int M){
        if(M == 0){
            char selectedAlphabet = ' ';
            for(int i = 0; i < length; i++){
                if(visited[i] == true) {
                    selectedAlphabet = setToList.get(i);
                    alphabet[selectedAlphabet - 97] = true;
                }
            }
            int check = check();
            if(check > max) max = check;
            Arrays.fill(alphabet, false);
            return;
        }
        for(int i = start; i < length; i++){
            visited[i] = true;
            combination(visited, i + 1, length, setToList, M - 1);
            visited[i] = false;
        }
    }
    public static int check(){
        List<Set<Character>> copyList = new ArrayList<>();
        int answer = 0;

        for(int i = 0; i < list.size();i++){
            Set<Character> set = new HashSet<>(list.get(i));
            copyList.add(set);
        }

        List<Character> list = new ArrayList<>();
        for(int i = 0; i < 26; i++){
            if(alphabet[i] == true)
                list.add((char)(i + 97));
        }

        for(int i = 0; i < copyList.size(); i++){
            if(copyList.get(i).size() > list.size())
                continue;
            copyList.get(i).removeAll(list);
            if(copyList.get(i).size() == 0) answer++;
        }

        return answer;
    }
}

/**
 컬렉션 사용하니 자꾸 시간초과남 다르게 풀어보자 컬렉션 클래스 최대한 이용하지말고
 **/