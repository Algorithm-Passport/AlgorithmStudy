package baekjoon.트리구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 새로운아이디어받아들이려면 모든 친구가 얼리어답터여야함.
// 모든사람이 새로운 아이디어 받아들일수있는 얼리어답터 최소의 수 구하기
public class Main2533 {
    static List<TreeNode> list;
    static int sum = 0; // 홀수 level
    static int sum1 = 0; // 짝수 level
    static int count;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        count = N;
        dp = new int[N];

        list = new ArrayList<>(N);
        int maxDepth = 1;

        // 1 2 3 4 ... N까지
        for(int i = 1; i < N + 1; i++){
            list.add(new TreeNode(i));
        }
        int[][] values = new int[N - 1][2];

        for(int i = 0; i < N - 1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            values[i][0] = Integer.parseInt(st.nextToken());
            values[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(values, new Compare());
        System.out.println(Arrays.deepToString(values));

        int root = values[0][0]; // 이녀석을 루트로하기로 결정
        list.get(root - 1).depth = 1; // depth 1로.


        for(int i = 0; i < values.length; i++){
            TreeNode parentNode = list.get(values[i][0] - 1);
            TreeNode childNode = list.get(values[i][1] - 1);

            if(parentNode.depth != 0){
                childNode.depth = parentNode.depth + 1;
                maxDepth = Math.max(maxDepth, childNode.depth);
                parentNode.nodes.add(childNode);
            }else{
                // 부모 가 트리노드로 지정안됐을 경우
                if(childNode.depth != 0){
                    parentNode.depth = childNode.depth - 1;
                }else{
                    // 자식도 트리에 지정안됐을경우
                    parentNode.depth = 1;
                    childNode.depth = 2;
                }
            }
        }

//
        for(int i = 0; i < list.size(); i++){
            System.out.println("depth : " + list.get(i).depth);
        }

        System.out.println("maxDepth = " + maxDepth);


        int cnt = 0;
        int cnt2 = 0;
        for (TreeNode treeNode : list) {
            if(treeNode.depth == 1){
                cnt++;
            }
            if(treeNode.depth == 2){
                cnt2++;
            }
        }
        dp[0] = cnt;
        dp[1] = Math.min(cnt, cnt2);

        TreeNode rootNode = list.get(root - 1);
        search(rootNode, 2);

//        for(int i = 0; i < list.size(); i++){
//            if(list.get(i).depth % 2 == 1){
//                sum++;
//                if(list.get(i).nodes.size() == 0 && list.get(i).depth != maxDepth) sum--;
//            }
//            if(list.get(i).depth % 2 == 0){
//                System.out.println(list.get(i).nodes);
//                System.out.println(list.get(i).depth);
//                sum1++;
//                if(list.get(i).nodes.size() == 0 && list.get(i).depth != maxDepth) sum1--;
//            }
//        }


//        for(int i = 0; i < list.size(); i++){
//            if(list.get(i).depth % 2 == 1) sum += 1;
//            if(list.get(i).depth % 2 == 0) sum1 += 1;
//        }
//
        System.out.println("sum = " + sum);
        System.out.println("sum1 = " + sum1);

        System.out.println(Math.min(sum, sum1));

    }
    public static void search(TreeNode treeNode, int i){
        dp[i] = Math.min(dp[i - 2] + )
    }
}
class TreeNode{
    int value;
    int depth;
    List<TreeNode> nodes = new ArrayList<>();

    TreeNode(int value){
        this.value = value;
    }

    @Override
    public String toString() {
        return value + "";
    }
}

class Compare implements Comparator{

    @Override
    public int compare(Object o1, Object o2) {
        if(o1 instanceof int[] && o2 instanceof int[]){
            int[] int1 = (int[])o1;
            int[] int2 = (int[])o2;
            return int1[0] - int2[0] != 0 ? int1[0] - int2[0] : int1[1] - int2[0];
        }
        return 0;
    }
}