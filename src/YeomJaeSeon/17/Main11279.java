package baekjoon.자료구조;

import java.io.*;
import java.util.PriorityQueue;

//최대힙
public class Main11279 {
    static PriorityQueue<MaxHeap> pq;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        pq = new PriorityQueue<>();

        for(int i = 0; i < N; i++){
            int v = Integer.parseInt(br.readLine());
            if(v == 0){
                if(pq.isEmpty()) bw.write(0 + "\n");
                else bw.write(pq.poll().value + "\n");
            }else{
                pq.offer(new MaxHeap(v));
            }
        }

        bw.flush();
        bw.close();
    }
}

class MaxHeap implements Comparable<MaxHeap>{
    int value;
    public MaxHeap(int value){
        this.value = value;
    }

    @Override
    public int compareTo(MaxHeap o) {
        return o.value - value;
    }
}