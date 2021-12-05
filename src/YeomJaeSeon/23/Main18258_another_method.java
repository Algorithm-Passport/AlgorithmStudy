package algo_study.week2;

import java.io.*;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class Main18258_another_method {
    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());
        MyQueue q = new MyQueue();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String cmd = st.nextToken();
            try{
                int value = Integer.parseInt(st.nextToken());
                q.push(value);
            }catch (NoSuchElementException e) {
                if(cmd.equals("pop")){
                    sb.append(q.pop()).append("\n");
                }else if(cmd.equals("size"))
                    sb.append(q.size()).append("\n");
                else if(cmd.equals("empty"))
                    sb.append(q.empty()).append("\n");
                else if(cmd.equals("front"))
                    sb.append(q.front()).append("\n");
                else if(cmd.equals("back"))
                    sb.append(q.back()).append("\n");
            }
        }

        System.out.println(sb.toString());
    }

}

class Node{
    int value;
    Node next;

    public Node(int value) {
        this.value = value;
    }
}

class MyQueue{
    Node start, end;
    int size = 0;

    void push(int value){
        if(start == null){
            //아무것도 없으면
            start = new Node(value);
            end = start;
        }else{
            Node newNode = new Node(value);
            end.next = newNode;
            end = newNode;
        }
        size++;
    }

    int pop(){
        if(size == 0)
            return -1;
        int value = start.value;
        start = start.next;
        size--;
        return value;
    }
    int size(){
        return size;
    }

    int empty(){
        return size == 0 ? 1 : 0;
    }
    int front(){
        if(size == 0) return -1;
        return start.value;
    }
    int back(){
        if(size == 0) return -1;
        return end.value;
    }

}
