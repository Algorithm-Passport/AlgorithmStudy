package baekjoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main15686 {
    // 최초 치킨집들의 정보를 담는 리스트
    public static List graphList = new ArrayList(13);
    // 도시치킨거리의 경우를 저장할 리스트
    public static List resultArr = new ArrayList(100);
// 치킨집 개수 >= M , 치킨집개수 <= 13
    public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int N = Integer.valueOf(st.nextToken());
            int M = Integer.valueOf(st.nextToken());

            // graph : 맵 위치정보
            int[][] graph = new int[N][N];

            for(int i = 0; i < N; i++){
                StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
                for(int j = 0; j < N; j++){
                    graph[i][j] = Integer.valueOf(st2.nextToken());
                }
            }
            
            // 치킨집 찾기
        findChickedHouses(graph, N);
        // graphList에는 치킨집의 위치정보가 들어있음(ArrayList에 int 배열이 들어있는거임)
        
        // 치킨집 개수만큼 체크할 int 배열만듬
        int[] checkNums = new int[graphList.size()];
        for(int i = 0; i < checkNums.length; i++){
            checkNums[i] = i;
        }
        
        // 치킨집 존재하는 조합 경우의수 찾기 - 조합임!
        boolean[] visited = new boolean[checkNums.length];
        combination(checkNums, visited, 0, visited.length, M, graph);
        
        // 도시치킨거리중 제일작은값
        System.out.println(Collections.min(resultArr));

    }
    // 치킨집찾기
    public static void findChickedHouses(int[][] graph, int N){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(graph[i][j] == 2){
                    graphList.add(new int[]{i, j});
                }
            }
        }
    }

    public static void combination(int[] chickenNums, boolean[] visited, int start, int length, int M, int[][] graph){
        if(M == 0){
            // 2차원배열 deep copy - graph의 깊은복사한 다른 2차원배열
            int[][] newGraph = new int[graph.length][graph.length];
            for(int i = 0; i < newGraph.length; i++){
                for(int j = 0; j < newGraph.length; j++){
                    newGraph[i][j] = graph[i][j];
                }
            }
            
            // staic graphList 리스트와 다른 점은 이건 현재 치킨집의 정보만 갖고있음
            ArrayList chickenPos = new ArrayList(13);

            for(int i = 0; i < visited.length; i++){
                // 치킨집아닌것들은 newGraph 전부 0으로 바꿔주고
                if(visited[i] == false){
                    int[] xy = (int[])graphList.get(i);
                    newGraph[xy[0]][xy[1]] = 0;
                }
                // 치킨집맞는놈들은 chickenPos 리스트에 위치정보를담는다.
                else{
                    int[] xy = (int[])graphList.get(i);
                    chickenPos.add(xy);
                }
            }
            // calculate메서드에서 갱신된 맵정보와 치킨 위치정보 리스트를넘김 
            resultArr.add(calculate(newGraph, chickenPos));
            return;
        }

        for(int i = start; i < length; i++){
            visited[i] = true;
            combination(chickenNums, visited, i + 1, length, M - 1, graph);
            visited[i] = false;
        }
    }
    public static int calculate(int[][] newGraph, List chickenPos){
        int value = 0; //도시의 치킨거리
        for(int i = 0; i < newGraph.length; i++){
            for(int j = 0; j < newGraph.length; j++){
                // 집을 찾으면 치킨거리를 구하고 (제일 작은값)
                if (newGraph[i][j] == 1) {
                    int minDistance = 200; 
                    for (int k = 0; k < chickenPos.size(); k++) {
                        int[] r2c2 = (int[])chickenPos.get(k);
                        int distance = Math.abs(i - r2c2[0]) + Math.abs(j - r2c2[1]);
                        if(minDistance > distance) minDistance = distance;
                    }
                    // 도시치킨거리에치킨거리를 더한다.
                    value += minDistance;
                }
            }
        }
        // 도시치킨거리 리턴
        return value;
    }

}
