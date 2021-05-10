package baekjoon.트리구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//트리순회방법
// 전위 preOrder -> 루트, 좌자식, 우자식
// 중위 inOrder -> 좌자식, 루트, 우자식
// 후위 postOrder -> 좌자식, 우자식, 루트
public class Main1991 {
    static List<Node> nodes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] stringArr = new String[N];
        nodes = new ArrayList<>(N);
        for(int i = 0; i < N; i++){
            stringArr[i] = br.readLine();
            nodes.add(new Node(String.valueOf(stringArr[i].charAt(0))));
        }
        // 각노드 다 만들고

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(stringArr[i], " ");
            String value = st.nextToken();
            String leftNodeValue = st.nextToken();
            String rightNodeValue = st.nextToken();
            Node selectedNode = nodes.get(i);

            for (Node node : nodes) {
                if(node.equals(leftNodeValue)){
                    selectedNode.leftNode = node;
                }
                if(node.equals(rightNodeValue)){
                    selectedNode.rightNode = node;
                }
            }
        }
        // 노드 완성

        preOrder(nodes.get(0));
        System.out.println();
        inOrder(nodes.get(0));
        System.out.println();
        postOrder(nodes.get(0));

    }
    public static void preOrder(Node node){
        System.out.print(node);
        if(node.leftNode != null)
            preOrder(node.leftNode);
        if(node.rightNode != null){
            preOrder(node.rightNode);
        }
    }
    public static void inOrder(Node node){
        if(node.leftNode != null){
            inOrder(node.leftNode);
        }
        System.out.print(node);
        if(node.rightNode != null){
            inOrder(node.rightNode);
        }
    }
    public static void postOrder(Node node){
        if(node.leftNode != null){
            postOrder(node.leftNode);
        }
        if(node.rightNode != null){
            postOrder(node.rightNode);
        }
        System.out.print(node);
    }

}
class Node{
    String value;
    Node leftNode;
    Node rightNode;

    Node(String value){
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof String){
            return ((String)obj).equals(this.value);
        }
        return false;
    }

    @Override
    public String toString() {
        return value;
    }
}

/**
 풀이
 leftNode와 rightNode가 멤버인 Node객체를 만들어 ArrayList에 해당 객체를 모두 집어넣고
 각각의 트리순회를 재귀함수로 구현함
 **/