package baekjoon.시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class Paper{
    private int importance;
    private int index;

    public Paper(int importance, int index){
        this.importance = importance;
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public int getImportance() {
        return importance;
    }

}
public class Main1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            Queue<Paper> pq = new LinkedList<>();

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++){
                pq.offer(new Paper(Integer.parseInt(st2.nextToken()), j));
            }
            System.out.println(solve(pq, N, M));
        }
    }
    static int solve(Queue<Paper> pq, int N, int M){
        int result = 0;
        //N : 문서개수
        //M : 현재 큐의 문서가 몇번쨰 출력됨?
        while(!pq.isEmpty()){
            // 큐에서 삭제되는 순서
//            pq.forEach(i -> System.out.print(i.getImportance()+" "));
//            System.out.println();
            Paper nowPaper = pq.peek();
            long count = pq.stream().filter(i -> i.getImportance() > nowPaper.getImportance()).count();
            if(count > 0) { // 우선순위 높은게 하나라도있으면 - poll한뒤 맨뒤로 다시 offer
                Paper poll = pq.poll();
                pq.offer(poll);
            }else{ // 우선순위 높은게 없으면 - 삭제
                ++result;
                Paper removePaper = pq.poll();
                if(removePaper.getIndex() == M){
                    return result;
                }
            }
        }
        return 0;
    }
}

/**
 * 풀이
 큐를 이용
 맨위에있는 peek()한 요소의 중요도보다 뒤에 큰게 하나라도있으면 poll -> offer
 그렇지않으면 poll - count세서 M과같으면 return 
 **/