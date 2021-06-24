package baekjoon.자료구조;

import java.io.*;
import java.util.*;

public class Main1927 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        Heap heap = new Heap();
        for(int i = 0; i < N; i++){
            int v = Integer.parseInt(br.readLine());
            if(v == 0){
                bw.write(heap.remove() + "\n");
            }else{
                heap.add(v);
            }
        }
        bw.flush();
        bw.close();
    }
}

class Heap{
    private List<Integer> arr;

    public Heap(){
        arr = new ArrayList<>(100001);
        arr.add(0); // get(0) - default
    }

    //== add ==//
    public void add(int value){
       arr.add(value);
       increaseChangePos(arr.size() - 1);
    }

    private void increaseChangePos(int pos){
        int tmp = 0;
        while(pos > 1 && arr.get(pos / 2) > arr.get(pos)){
            tmp = arr.get(pos);
            arr.set(pos, arr.get(pos / 2));
            arr.set(pos / 2, tmp);

            pos /= 2;
        }
    }

    //== remove ==//
    public int remove(){
        if(arr.size() == 1) return 0;

        int tmp = 0;
        tmp = arr.get(arr.size() - 1);
        arr.set(arr.size() - 1, arr.get(1));
        arr.set(1, tmp);

        int removeValue = arr.remove(arr.size() - 1);
        //삭제

        int i = 1;
        while(i * 2 < arr.size()){
            int minIdx = 0;
            if(arr.size() - 1 >= i * 2 + 1) {
                minIdx = arr.get(i * 2) > arr.get(i * 2 + 1) ? i * 2 + 1 : i * 2;
            }else{
                minIdx = i * 2;
            }

            if(arr.get(i) > arr.get(minIdx)){
                tmp = arr.get(i);
                arr.set(i, arr.get(minIdx));
                arr.set(minIdx, tmp);
            }

            i = minIdx;
        }
        return removeValue;
    }

    public List<Integer> getArr() {
        return arr;
    }
}