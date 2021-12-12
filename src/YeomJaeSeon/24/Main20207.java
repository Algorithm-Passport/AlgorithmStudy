package algo_study.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 시작일이 앞선것부터 위에 있음
 * 시작일이 같으면 일정의 기간이 긴것부터
 *
 */
public class Main20207 {
    static int[] dates = new int[366];
    static int N;
    static List<Daily> dailies = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            dailies.add(new Daily(start, end));

        }

        Collections.sort(dailies);

        // dates 갱신 (dates가 0 이라면 해당 날짜에 일정이 없음을 의미)
        for (Daily daily : dailies) {
            for(int i = daily.start; i <= daily.end; i++){
                dates[i] += 1;
            }
        }


        System.out.println(calculateChunk());
    }
    static int calculateChunk(){
        int width = 0;
        int height = 0;

        int totalWidth = 0;

        for(int i = 1; i <= 365; i++){
            if(dates[i] == 0){
                totalWidth += (width * height);
                width = 0;
                height = 0;
                continue;
            }
            width++;
            height = Math.max(height, dates[i]);
        }

        // 365일까지 데이터가 있는 경우를 생각 안함. 그래서 한번틀림
        totalWidth += width * height;

        return totalWidth;
    }
}

class Daily implements Comparable<Daily>{
    int start;
    int end;

    public Daily(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "Daily{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }

    // start가 작은거부터 오름차순 정렬, 같다면 end - start가 큰녀석부터 오름차순 정렬
    @Override
    public int compareTo(Daily o) {
        if(this.start != o.start)
            return this.start - o.start;
        else{
            return ((this.end - this.start) - (o.end - o.start)) * -1;
        }
    }
}
/**
 * 시작일 앞선거 + 같으면 기간이 긴 순으로 오름차순 정렬을 해야할거 같다.
 * 365를 담을수있는 1차원 배열이 있어야한다.
 * 배열의 값은 세로를 의미한다.
 * 일정하나씩 검색하며 1차원 배열의 세로를 업데이트해야할거같다.
 *
 * 풀이
 * 1. 달력에 일정을 저장할 배열이 있어야 한다. - dates
 * 2. 입력되는 일정은 정렬이 필요하다.
 * 3. 일정을 돌면서 dates에 += 1 씩해나간다. (dates의 원소값이 0 이면 일정 X, 원소값이 0 이아니면 그만큼의 일정이 그날에 있다는 의미)
 * 4. chunk 직사각형들의 넓이를 구한다.
 *
 * 한번 틀림
 * 1. calculateChunk라는 메서드에서 totalWidth를 구하는 공식을 하나 빼먹음. 마지막 365가 0 이 아닐경우(365일날에 일정이 있을경우) totalWidth를 갱신해야하는데 깜빡함
 */