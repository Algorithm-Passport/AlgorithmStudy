package algo_study.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 문자열 길이 1개중 사전순으로 가장앞에오는거 출력
 * 문자열 길이 2개중 사전순으로 가장 앞에오는거 출력
 * 문자열 길이 3개중 사전순으로 가장 앞에오는거 출력
 * ..
 * 문자열 길이 N개중 사전순으로 가장 앞에오는거 출력
 */
public class Main16719 {
    static String str;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        visited = new boolean[str.length()];

        for(int i = 0; i < str.length(); i++){
            List<MyWord> list = new ArrayList<>();

            for(int j = 0; j < str.length(); j++){
                if(visited[j]) continue;
                visited[j] = true;

                //방문처리된 녀석들 MyWord 객체로 만드는 메서드
                MyWord myWord = makeMyWord(i + 1);
                list.add(myWord);

                visited[j] = false;
            }

            Collections.sort(list);//오름차순 정렬
            MyWord first = list.get(0); //가장 앞에 있는 녀석

            System.out.println(first.word); //출력

            //해당 문자열의 방문배열 방문처리
            for (int idx : first.idxes) {
                visited[idx] = true;
            }
        }
    }
    //방문처리된 녀석들 문자열로 만들어 반환
    static MyWord makeMyWord(int arrLength){
        StringBuilder sb = new StringBuilder();
        int[] indexes = new int[arrLength];
        int idx = 0;

        for(int i = 0; i < str.length(); i++){
            if(visited[i]) {
                sb.append(str.charAt(i));
                indexes[idx++] = i;
            }

        }
        MyWord myWord = new MyWord(sb.toString(), indexes);
        return myWord;
    }
}

class MyWord implements Comparable<MyWord>{
    String word;
    int[] idxes;

    public MyWord(String word, int[] idxes) {
        this.word = word;
        this.idxes = idxes;
    }

    //MyWord의 word(String)의 오름차순으로 정렬기준을 정의함.
    @Override
    public int compareTo(MyWord o) {
        return this.word.compareTo(o.word);
    }
}

/**
 * 입력받는 문자열 만큼의 정수 배열이 있어야한다 생각했음
 * 이정수형 배열은 알파벳 대문자의 순서가 있어야한다 생각했음 ( ex A : 0, B : 1, C : 2..)
 * 그리고 적절하기 한개부터 N개씩 뽑으면 된다생각함
 * //처음 문제 보고 든생각 - 불필요한거같아 풀면서 없앰
 *
 * 모든 경우를 탐색하자.
 *
 * 1. 1자리수 에서 사전순 가장 앞에오는 녀석 찾고 출력
 * 2. 2자리수에서 사전순 가장 앞에오는 녀석 찾고 출력
 * 3. 3자리수...
 * (포인트는 방문처리를 계속 해나가가는것.)
 *
 * 근데 왜틀렸지?
 * 복붙 잘못해서 틀렸나보다
 *
 *
 * 틀린이유
 * 1. 파티션을 나눠서 해당 파티션에서 가장 작은 녀석을 하나씩 문자열에 추가해가며 출력해야 한다 생각했음 - 예시 3에서 틀리는 줄몰랐음.
 * 이렇게하면 왜안되냐면, 8 9 3 1 4 2 이렇게 알파벳있으면 1 -> 1 2 -> 3 1 2(가되버림) (1 4 2가 맞는건데.)
 *
 * 풀이
 * 최대 문자열의 길이가 100밖에 되지않아, 모든 경우를 탐색해도 될거라 생각했음
 *
 * 그냥 '한자리수일때 사전순 가장앞, 두자리수일떄 사전순 가장앞에녀석 출력하면 된다' 의 가장 간단한 아이디어에서 생각함
 *
 * 그러나
 *
 * 단순히 그렇게 하면안된다..
 * 문자열 사전순이므로, 해당 자리수의 가장 앞선 녀석을 뽑기위해선 해당 자리수만큼의 모든 경우를 생각해야한다했음
 *
 * 재귀함수를 이용해야하나?라는 생각이들었는데, 방문처리를 통해 단순히 O(N^2)으로 풀수 있을거라 생각함. (반복문 중첩 2번)
 *
 * 1자리수 모두 탐색 -> 오름차순 정렬(사전순 정렬) -> 해당 문자열 방문처리
 * 2자리수 모두 탐색(위에서 방문되어있는 것이있으므로 하나만 추가로 방문해가면됨)  -> 오름차순 정렬(사전순 정렬) -> 해당 문자열 방문처리
 * 3자리수 ...
 *
 * 이렇게 푸니 맞았따.
 */