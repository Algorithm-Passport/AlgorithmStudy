package baekjoon.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//5 -> 4 -> 2 -> 1 -> 7 (3, 6 포기)
//60 40 20 50 30 10 5

/**
 * 60 4
 * 40 3
 * 20
 * 50 2
 * 30 1
 * 10
 * 5  5
 */

class HomeWork implements Comparable<HomeWork>{
    int day;
    int score;

    public HomeWork(int day, int score){
        this.day = day;
        this.score = score;
    }

    public int getDay() {
        return day;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "HomeWork{" +
                "day=" + day +
                ", score=" + score +
                '}';
    }

    @Override
    public int compareTo(HomeWork o) {
        return score - o.score; // 점수 오름차순
    }
}
public class Main13904 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        List<HomeWork> list = new ArrayList<>();

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            list.add(new HomeWork(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(list, Comparator.comparingInt(HomeWork::getDay));

        int result = calculateScore(list);
        System.out.println(result);
    }
    static int calculateScore(List<HomeWork> list){
        PriorityQueue<HomeWork> pq = new PriorityQueue<>();
        pq.offer(list.get(0));

        for(int i = 1; i < N; i++){
            int size = pq.size() + 1; // 만약 넣었을 때 pq size
            if(size <= list.get(i).getDay()){
                pq.offer(list.get(i));
            }else{
                pq.offer(list.get(i));
                pq.poll(); //제일 작은 점수의 숙제를 하지않음
            }
        }
        int sum = pq.stream().mapToInt(HomeWork::getScore).sum();
        return sum;
    }
}

/**
 풀이
 매일 하루에 하나씩의과제밖에 하지못한다.
 1 20
 2 50
 3 30
 4 40
 4 60
 4 10
 이런 입력이있으면 어떤게 최대일까?

 바로 저 6개의 입력값중 합이 최대인게 최대이다. (당연함)
 그러려면 뭐가빠져야할까? - 제일 작은 녀석 두개가 빠져야한다(과제는 6개 남은일수는 4일..)

 어떤식으로 풀었냐면
 일단 입력될때, 남은일수를 List에 오름차순으로 정렬했다.

 그리고 우선순위 큐를 이용했는데 우선순위큐는 점수가 오름차순이다.
 즉, List에 제일 남은일수가 작은걸 우선순위큐에 offer하고,,, 하다보면 우선순위큐에는 제일 점수가 작은녀석이 위에있겠다.

 우선순위큐의 size와 Homework의 걸리는 일수를 비교하며 pq에 넣거나 빼고했다.
 1 20
 2 50
 3 30
 4 40
 4 60
 4 10

 이 입력에 대해서 List는
 1 20
 2 50
 3 30
 4 40
 4 60
 4 10
 이 상태로 정렬되어있다.
 우선순위큐에 넣는 동작을 확인해보자(우선순위큐는 offer될때 점수 오름차순으로 정렬되는것을 유의하자)
 1. 1 20 -> pq size + 1이 입력되는 day 1보다 작거나 같으므로 pq에 offer [1 20]
 2. 2 50 -> pq size + 1, 즉 2가 입력되는 day 2보다 작거나 같으므로 pq에 offer [1 20, 2 50]
 3. 3 30 -> pq size + 1, 즉 3이 입력되는 day 3보다 작거나 같으므로 pq에 offer [1 20, 3 30, 2 50]
 4. 4 40 -> pq size + 1, 즉 4가 입력되는 day 4보다 작거나 같으므로 pq에 offer [1 20, 3 30, 4 40, 2 50]
 5. 4 60 -> pq size + 1, 즉 5가 입력된느 day 4보다 크므로!! pq에 이 값을 넣은다음 맨위에있는(점수가 제일작은)걸 뺴야한다. -> [1 20, 3 30, 4 40, 2 50, 4 60]에서 1 20이 빠지게된다.
 즉 5에서 pq는 [3 30, 4 40, 2 50, 4 60]이 된다. 즉, pq에서는 일수는 하나도 중요하지않다!!! (pq를 그냥 점수 Integer만 집어넣으면 더깔끔하겠다.)

 이 과정을 거치고 pq의 점수의 합을 더하면 답이다.
 **/