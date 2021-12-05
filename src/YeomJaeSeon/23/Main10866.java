package algo_study.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class Main10866 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        MyDeque deque = new MyDeque();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String cmd = st.nextToken();
            try{
                int value = Integer.parseInt(st.nextToken());
                if(cmd.equals("push_front")) deque.push_front(value);
                else deque.push_back(value);
            }catch (NoSuchElementException e){
                if(cmd.equals("pop_front")){
                    sb.append(deque.pop_front()).append("\n");
                }else if(cmd.equals("pop_back"))
                    sb.append(deque.pop_back()).append("\n");
                else if(cmd.equals("size"))
                    sb.append(deque.size()).append("\n");
                else if(cmd.equals("empty"))
                    sb.append(deque.empty()).append("\n");
                else if(cmd.equals("front"))
                    sb.append(deque.front()).append("\n");
                else if(cmd.equals("back"))
                    sb.append(deque.back()).append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}

class MyNode{
    int value;

    MyNode next, before;
    public MyNode(int value) {
        this.value = value;
    }
}

class MyDeque{
    MyNode start, end;
    int size = 0;

    void push_front(int x){
        if(size == 0){
            //아무것도 없으면
            MyNode node = new MyNode(x);
            start = node;
            end = node;
        }else{
            MyNode newNode = new MyNode(x);
            newNode.next = start;
            start.before = newNode;
            start = newNode;
        }
        size++;
    }
    void push_back(int x){
        if(size == 0){
            MyNode node = new MyNode(x);
            start = node;
            end = node;
        }else{
            MyNode newNode = new MyNode(x);
            end.next = newNode;
            newNode.before = end;
            end = newNode;
        }
        size++;
    }
    int pop_front(){
        if(size == 0) return -1;
        else{
            int answer = start.value;
            if(size == 1){
                start = null;
                end = null;
            }else{
                start = start.next;
                start.before = null;
            }
            size--;
            return answer;
        }
    }
    int pop_back(){
        if(size == 0) return -1;
        else{
            int answer = end.value;
            if(size == 1){
                start = null;
                end = null;
            }else{
                end = end.before;
                end.next = null;
            }
            size--;
            return answer;
        }
    }
    int size(){
        return size;
    }
    int empty(){
        return size == 0 ? 1 : 0;
    }
    int front(){
        return size == 0 ? -1 : start.value;
    }
    int back(){
        return size == 0 ? -1 : end.value;
    }
}
