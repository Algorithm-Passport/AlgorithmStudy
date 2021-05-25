package baekjoon.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main9663 {
    static int N;
    static int[][] visited;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new int[N][2];
        for(int i = 0; i < N; i++){
            visited[i] = new int[]{-1, -1};
        }

        solution(0);
        System.out.println(cnt);
    }

    static void solution(int M){
        if(M == N){
//            for(int i = 0; i < N; i++){
//                System.out.print("["+visited[i][0]+","+visited[i][1] +"]");
//            }
//            System.out.println();
            ++cnt;
            return;
        }

        for(int i = 0; i < N; i++){
            if(checkQueen(M, i)) {
                solution(M + 1);
                // 이 이후코드는 재귀함수 종료될때 (위 조건문 if(M==N) return;)
                // 아래 코드로와서 그당시의 퀸위치를 삭제함.
                for (int j = 0; j < N; j++) {
                    if (visited[j][0] == M && visited[j][1] == i) {
                        visited[j][0] = -1;
                        visited[j][1] = -1;
                    }
                }
            }
        }
    }

    static boolean checkQueen(int x, int y){

        // 처음 퀸 위치를 고를때
        int checkCount = 0;
        for (int[] isVisit : visited) {
            if(isVisit[0] == -1 && isVisit[1] == -1) checkCount++;
        }
        if(checkCount == N){
            visited[0] = new int[]{x, y};
            return true;
        }

        // 이미 자리가 정해진 퀸이 있을때
        for (int[] isVisit : visited) {
            int posx = isVisit[0];
            int posy = isVisit[1];
            if(posx == -1 && posy == -1) {
                break;
            }
            if(posx == x || posy == y)
                return false;
            int absX = Math.abs(posx - x);
            int absY = Math.abs(posy - y);
            if(absX == absY)
                return false;
        }

        // 퀸자리 입력하고 return true;
        for(int i = 0; i < N; i++){
            if(visited[i][0] == -1 && visited[i][1] == -1) {
                visited[i][0] = x;
                visited[i][1] = y;
                break;
            }
        }
        return true;
    }
}

/**
 메모리초과
 1. ArrayList를 사용했더니 메모리초과 -> 2차원배열로 변경
 시간초과
 1. visited[N][N]을 사용했더니 시간초과 -> 일차원배열 (원소가 2차원배열)로 변경
 **/