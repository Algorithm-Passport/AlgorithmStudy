package baekjoon.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Lesson {
    int start;
    int end;

    public Lesson(int start, int end){
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}

public class Main11000 {
    static int N;
    static List<Lesson> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            list.add(new Lesson(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(list, Comparator.comparingInt(Lesson::getStart).thenComparing(Lesson::getEnd));
        //시작시간 정렬 -> 끝나는 시간 정렬,

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(list.get(0).getEnd());
        for(int i = 1; i < N; i++){
            if(pq.peek() <= list.get(i).getStart()){
                pq.poll();
                pq.offer(list.get(i).getEnd());
            }else{
                pq.offer(list.get(i).getEnd());
            }
        }

        System.out.println(pq.size());
    }

}

/**
 최소의 강의실을 배정해야되는 문제

 풀이
 수업을 안하는 버리는 시간을 줄이기 위해 시작시간을 기준으로 정렬, 시작시간 같으면 종료시간을 기준으로 정렬함
 이 정렬은 수업을 최대한 버리지 않도록 함
 시작시간이 그럼 작은것부터 정렬이 되기 때문에 종료시간만 생각하며 강의실을 배정할수 있음
 정렬하지않으면 시작시간도 고려를 해야함

 그리고 우선순위큐 (정수 오름차순 정렬 기준)를 이용
 우선순위큐는 끝나는 시간만 알고있음

 1 3
 1 4
 3 5
 4 6

 네개의 수업(정렬된상태)

 일단 먼저 우선순위큐에 1 3 수업의 끝나는 시간 3을 넣는다
 그다음 수업 1 4 에 대해서 우선순위 큐 가장위에있는 3(우선순위 큐 가장위에있는 녀석이 종료를 가장 빨리 하는 녀석이다.)
 과 시작시간 1을 비교한다. 시작시간으로 정렬한 상태이므로 강의실을 새롭게 배정해야한다는 확신을 할수있음
 그래서 우선순위큐에 1 4 의 끝나는 시간 4를 넣는다. 그럼 우선순위큐는 [3, 4] 의 데이터가 존재한다.
 그다음 수업 3 5 에 대해서 시작시간 3과 우선순위큐 맨위에있는 3을 비교하면 3 >= 3이므로 우선순위큐의 3을 pop하고
 새로운 종료시간 5를 넣는다. 그럼 우선순위큐는 [4, 5]이다.
 그리고 4 6 수업에 대해서 4와 우선순위큐 맨위의 4를 비교하면 4>= 4 이므로 pop하고 offer하면 [5, 6]이되고
 배정된 강의실의 개수는 pq의 size이다.

 우선순위큐는 내부적으로 heap이 구현되어있다. 그래서 우선순위에 따라 힙의 구조를 바꾸는데 굉장히 빠르다.
 애초에 입력되는 수업의 개수가 200,000 개이므로 완전탐색은 무조건 시간초과이므로 내부적으로 힙이 구현되어있는
 우선순위큐를 이용함.

 암튼 어려운문제다. 생각하기에
 **/
