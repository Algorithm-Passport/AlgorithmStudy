package baekjoon.BS;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main3020 {
    static int N, H;
    static int[] bottomObs; // 석순
    static Integer[] topObs; // 종유석
    static int min = (int)1e9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        bottomObs = new int[N / 2];
        topObs = new Integer[N / 2];

        for(int i = 0; i < N; i++){
            if(i % 2 == 0){
                topObs[i / 2] = Integer.parseInt(br.readLine());
            }else{
                bottomObs[i / 2] = Integer.parseInt(br.readLine());
            }
        }

        Arrays.sort(bottomObs);
        Arrays.sort(topObs, Collections.reverseOrder());

        int[] newTopObs = Arrays.stream(topObs).mapToInt(Integer::intValue).toArray();

        System.out.println(Arrays.toString(bottomObs));
        System.out.println(Arrays.toString(topObs));

//        System.out.println(binarySearch(0, N / 2 - 1, 2, bottomObs));

        for(int i = 1; i < H; i++){
            int bottomUpper = binarySearch(0, N / 2 - 1, i, bottomObs);
            int topUpper = binarySearch(0, N / 2 - 1, i, newTopObs);
            bottomUpper = (N / 2) - bottomUpper;
            topUpper = (N / 2) - topUpper;
            System.out.println("bottomUpper = " + bottomUpper);
            System.out.println("topUpper = " + topUpper);
            min = Math.min(bottomUpper + topUpper, min);

        }
        System.out.println(min);
    }
    static int binarySearch(int start, int end, int target, int[] arr){

        while(start < end){
            int mid = (start + end) / 2;
            if(arr[mid] <= target){
                start = mid + 1;
            }else{
                end = mid;
            }
        }
        return start;
    }
}
