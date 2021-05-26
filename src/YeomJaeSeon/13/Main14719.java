package baekjoon.시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main14719 {
    static int[][] graph;
    static int totalCount = 0;
    static Stack<Integer> stack = new Stack<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int H = Integer.parseInt(st.nextToken()); // 세로
        int W = Integer.parseInt(st.nextToken()); // 가로

        graph = new int[H][W];
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < W; i++){
            int length = Integer.parseInt(st2.nextToken());
            for(int j = H - 1; j >= 0; j--){
                if(length == 0) break;
                graph[j][i] = 1;
                --length;
            }
        }

//        for(int i = 0; i < H; i++){
//            for(int j = 0; j < W; j++){
//                System.out.print(graph[i][j] +" ");
//            }
//            System.out.println();
//        }

        boolean isStart = false;
        //isStart로 왼쪽에 1이있는지

        for(int i = H - 1; i >= 0; i--){
            for(int j = 0; j < W; j++){
                if(graph[i][j] == 1){
                    if(!stack.empty()){ // 1이고 스택이 비어있지않으면 그건 고여있는것.
                        totalCount += stack.size();
                        stack.clear();
                    }else{
                        isStart = true;
                    }
                }
                if(graph[i][j] == 0 && isStart){
                    stack.push(1);
                }
            }
            stack.clear();
            isStart = false;
        }
        System.out.println(totalCount);
    }
}

/**
 풀이
 - 500 * 500 = 250000 (십만정도이므로) 이차원배열만들어서 하나씩 순차탐색해도 될거라 생각ㄴ
 1. 2차원배열만듬(입력과같은)
 2. 아래에서부터 물이 고일수있는 경우를 판단
 1) 양쪽에 1이있고 사이에 0 이있으면 물이고일수있음
 2) stack을 이용해서 물일수있는 (graph[i][j] == 0)일경우를 하나씩넣음 - 이때 isStart는 true로 왼쪽에 1이하나라도있어야하며 !stack.empty()로 오른쪽에 1로끝나야함을 체크함
 3) 각 행을 체크하고 스택과 isStart boolean변수를 초기화함.

 틀렸습니다.
 행을 진행중 isStart를 다시 false로 바꾸어서 스택에 빗물고일수있는경우가 안들어가 틀림 - 행을 진행중에는 isStart를 다시 false로 바꿀필요가없음.
 **/