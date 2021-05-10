package baekjoon.그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main1967 {
    static boolean[] visited;
    static List<Node>[] graph;
    static int max = 0; // 트리 전체의 max
    static int sum = 0; // 합저장할변수
    static int subMax = 0; // 노드 하나의 max

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] inputArr = new int[n - 1][3]; // 최대 10,000 * 3 * 4 = 120,000
        for(int i = 0; i < n - 1; i++){
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s, " ");
            inputArr[i][0] = Integer.parseInt(st.nextToken());
            inputArr[i][1] = Integer.parseInt(st.nextToken());
            inputArr[i][2] = Integer.parseInt(st.nextToken());
        }

        visited = new boolean[n + 1]; // 10,000 * 1 = 10,000
        graph = new ArrayList[n + 1]; // 10,000 * 24 = 240,000

        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 1; i < n + 1; i++){
            for(int j = 0; j < inputArr.length; j++){
                if(inputArr[j][0] > i) break; // 부모 노드는 항상 자식노드보다 작다.
                if(inputArr[j][0] == i){
                    graph[i].add(new Node(inputArr[j][1], inputArr[j][2]));
                }
                if(inputArr[j][1] == i){
                    graph[i].add(new Node(inputArr[j][0], inputArr[j][2]));
                }
            }
        }

//        System.out.println(Arrays.toString(graph));

        for(int i = 1; i < n + 1; i++){
            dfs(i);
            max = Math.max(max, subMax);
            sum = 0;
            Arrays.fill(visited, false);
        }
        System.out.println(max);

    }
    public static void dfs(int startNode){
        visited[startNode] = true;

        Iterator<Node> iterator = graph[startNode].iterator();

        // key는 연결된 node, value 가중치
        while(iterator.hasNext()){
            Node next = iterator.next();
            int nextNode = next.num; // 다음노드
            int gravity = next.gravity; // 다음노드까지의 가중치
            if(!visited[nextNode]){ // 방문한적이 없으면
                sum += gravity;
                dfs(nextNode);
                subMax = Math.max(sum, subMax);
                sum -= gravity; // 여긴 빼야함. 더이상 갈 노드가없는 노드는 이제 재귀함수 끝나서 이 문으로 오면 최근의 가중치를 빼야함 
                // 예를들면 1 -> 2-> 4 -> 7로 왔는데 7에서 dfs재귀함수이제끝나면 최근 가중치 7을 뺴고 다시 노드 4에서 방문하지않은 8번 노드로 간다. 
                // 이러한 흐름으로 품
            }
        }
    }
}

class Node{
    int num;
    int gravity;
    Node(int num, int gravity){
        this.num = num;
        this.gravity = gravity;
    }

//    @Override
//    public String toString() {
//        return "node : " + num +", gravity : " + gravity;
//    }
}

/**
 메모리초과
 - 인접리스트행렬의 데이터 (노드 번호와 가중치)를 HashMap으로 key value로 저장해서 했더니 메모리초과났음
 
 해결
 - 단순히 Node클래스 만들어서 노드번호, 가중치 저장하는 멤버변수 만들어서 했더니 메모리초과해결.;
 - hashMap은 해쉬테이블때문에(배열 + LinkedList) 메모리를 많이잡아먹는건가? - 정확히는모르겠음 왜그런지
 
 풀이
 1. dfs 를 이용함
 2. 어쨌든 각 노드에서 어떤 노드를 가던간에 최대값을 알아야함 그래서 한 노드 (예를들면 노드 1에서 dfs 그래프 탐색한다면)
 1에서 모든 노드까지 갈떄의 최대 subMax를 구함
 3. 노드1 ~ 노드 N까찌의 max를 subMax를 통해 갱신하며 구함
 **/