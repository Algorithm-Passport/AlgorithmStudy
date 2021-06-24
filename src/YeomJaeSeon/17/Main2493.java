package baekjoon.자료구조;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main2493 {
    static int N;
    static int[] buildings; // 입력되는 탑의 높이들
    static Stack<int[]> stack = new Stack<>(); // 탑의 높이, 위치
    static int[] result; // 송신받는 탑의 위치 저장할 배열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        buildings = new int[N];
        result = new int[N];

        for(int i = 0; i < N; i++){
            buildings[i] = Integer.parseInt(st.nextToken());
        }

        // 초기화(입력)

        // 첫번재 송신탑부터
        for(int i = 0; i < N; i++){
            // 첫번재 송신탑은 무적건 도달할 탑이없음. result에 0을 넣는다. stack에도 탑 높이와 위치넣는다.
            if(i == 0){
                stack.push(new int[]{buildings[i], i + 1});
                result[i] = 0;
            }else{
                // 그다음 탑이존재하면(그다음 탑부턴)
                // 스택에 맨위에있는 녀석은 이미 거친 탑들중 높이가 가장큰녀석임. (만약 4위치에 탑높이 100이있고 위치 1,2,3에 100보다 작은 탑들이있으면 5위치부터 송신하는 레이저는 절대로 1 2 3 위치의  탑을 도달할수 없다.)
                // 이 아이디어를 이용해서 스택을통해 구현한다.
                if(stack.peek()[0] < buildings[i]) { // 현재 거친탑중 제일 큰녀석보다 더 큰녀석이오면
                    // 더작은 녀석들은 스택에서 비워주고
                    while (stack.peek()[0] < buildings[i]) {
                        stack.pop();
                        if (stack.isEmpty()) break;
                    }
                }
                // 송신받는 탑의 배열에 값을 넣어준다.
                makeResult(i);
                stack.push(new int[]{buildings[i], i + 1});
                //만약 더 작은녀석이 오면 그냥 push만한다. pop을하지않고 위의 if문에 걸리지않으면!
            }
        }
        for(int i = 0; i < N; i++){
            bw.write(result[i] + " ");
        }

        bw.flush();
        bw.close();
    }
    static void makeResult(int i){
        if(stack.isEmpty()){
            result[i] = 0;
        }else{
            result[i] = stack.peek()[1];
        }
    }
}
