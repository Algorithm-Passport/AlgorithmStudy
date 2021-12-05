package algo_study.week2;

import java.io.*;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class Main18258 {
    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());
        Queue q = new Queue();
        for(int i = 0; i < T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String cmd = st.nextToken();
            try{
                int value = Integer.parseInt(st.nextToken());
                q.push(value);
            }catch (NoSuchElementException e) {
                if(cmd.equals("pop")){
                    bw.write(q.pop() + "\n");
                }else if(cmd.equals("size"))
                    bw.write(q.size() + "\n");
                else if(cmd.equals("empty"))
                    bw.write(q.empty() + "\n");
                else if(cmd.equals("front"))
                    bw.write(q.front() + "\n");
                else if(cmd.equals("back"))
                    bw.write(q.back() + "\n");
            }
        }

        bw.flush();
        bw.close();
    }
}

class Queue{
    private LinkedList<Integer> list;

    public Queue() {
        this.list = new LinkedList<>();
    }

    public void push(int value){
        this.list.add(value);
    }

    public int pop(){
        return list.isEmpty() ? -1 : list.remove(0);
    }

    public int size(){
        return list.size();
    }

    public int empty(){
        return list.isEmpty() ? 1 : 0;
    }

    public int front(){
        return list.isEmpty() ? -1 : list.get(0);
    }

    public int back(){
        return list.isEmpty() ? -1 : list.getLast();
    }
}