package baekjoon.문자열;

import java.io.*;
import java.util.*;

public class Main7785 {
    static int N;
    static Map<String, String> store = new HashMap<>(1000000);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String name = st.nextToken();
            String state = st.nextToken();
            store.put(name, state);
            // hashMap에 이름과 상태를 넣는다. // key가 중복이 안된다. -> 덮어씌워짐
            //만약 "KIM", "enter" 가있는데
            // "KIM", "leave" 가 들어오면 leave로 덮어씌워짐 (총 객체가 2개가되는게아니라 1개임)
            //결국 state는 사람의 마지막 state가 저장되게된다.
        }

        List<String> resultList = new ArrayList<>(1000000);

        Iterator<Map.Entry<String, String>> iterator = store.entrySet().iterator();

        // enter상태이면 list에 집어넣기
        while(iterator.hasNext()){
            Map.Entry<String, String> next = iterator.next();
            String name = next.getKey();
            String state = next.getValue();
            if(state.equals("enter")) resultList.add(name);
        }

        //사전역순 정렬하기
        Collections.sort(resultList, (o1, o2) -> o1.compareTo(o2) * -1);

        for (String s : resultList) {
            bw.write(s+"\n");
        }
        bw.flush();
        bw.close();
    }
}

/**
 문제자체는 간단한데
 시간초과가많이남

 LinkedList사용 삭제 -> 시간초과
 ArrayList사용 삭제말고 flag변경 -> 시간초과
 어떠한 요소에 위치를 찾기위해 해싱을 이용하는 HashMap을 사용 -> 시간초과해결
 해싱이란 어떠한key를 해쉬함수에 넣으면 hashCode()반환값이나오고
 이 해쉬코드가 해쉬테이블(배열 + 링크드리스트)의 위치값을 가지고있음
 배열의 index로 접근 + LinkedList로 추가나 삭제로 엄청빠르다

 **/