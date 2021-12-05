package algo_study.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main22942 {
    static int N;
    static List<MyCircle> circles = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            circles.add(new MyCircle(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(circles, Comparator.comparingInt(o -> (o.x - o.r)));

        System.out.println(circles);

        for(int i = 0; i < circles.size() - 1; i++){
            MyCircle currCircle = circles.get(i);
            MyCircle nextCircle = circles.get(i + 1);

            if(isMeet(currCircle, nextCircle)){
                System.out.println("NO");
                System.exit(0);
            }
        }
        System.out.println("YES");
    }
    static boolean isMeet(MyCircle curr, MyCircle next){
        if(curr.r + next.r < Math.abs(next.x - curr.x)) return false;
        if(Math.abs(next.x - curr.x) < Math.abs(curr.r - next.r)) return false;

        return true;
    }
    
}

class MyCircle{
    int x;
    int r;

    public MyCircle(int x, int r) {
        this.x = x;
        this.r = r;
    }

    @Override
    public String toString() {
        return "MyCircle{" +
                "x=" + x +
                ", r=" + r +
                '}';
    }
}

/**
 * 3
 * 0 1
 * 1 3
 * 3 1
 *
 * 이 경우는 교점이 존재하는데 왜 YES지?
 *
 *
 */