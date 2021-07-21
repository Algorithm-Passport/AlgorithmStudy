package baekjoon.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Cow{
    int arrive;
    int time;

    public Cow(int arrive, int time){
        this.arrive = arrive;
        this.time = time;
    }

    public int getArrive() {
        return arrive;
    }

    public int getTime() {
        return time;
    }
}

public class Main14469 {
    static int N;
    static List<Cow> list = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            list.add(new Cow(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(list, Comparator.comparingInt(Cow::getArrive)
                .thenComparing(Cow::getTime));
        // 걸리는 최소시간을 위해 정렬

        long times = list.get(0).getTime() + list.get(0).getArrive();
        for(int i = 1; i < N; i++){
            if(list.get(i).getArrive() > times){
                times = list.get(i).getArrive() + list.get(i).getTime();
            }else{
                times += list.get(i).getTime();
            }
        }

        System.out.println(times);
    }
}
/**
 * 소가 입장하는 시간을 최소로하려면
 * 소가 도착한 시간을 기준으로 정렬 -> 같으면 대기시간 기준으로 정렬을해야한다
 * 그래야 버리는 시간을 최소로 할수있다.
 *
 * type 은 long으로
 */
