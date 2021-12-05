package algo_study.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class Main10828 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        MyIntStack stack = new MyIntStack();

        for(int i = 0; i < N; i++){
            String command = br.readLine();

            StringTokenizer st = new StringTokenizer(command, " ");
            String comA = st.nextToken();
            try{
                //push
                int value = Integer.parseInt(st.nextToken());
                stack.push(value);
            }catch (NoSuchElementException e){
                //else..
                if(comA.equals("pop")){
                    System.out.println(stack.pop());
                }else if(comA.equals("size")){
                    System.out.println(stack.size());
                }else if(comA.equals("empty")){
                    System.out.println(stack.empty());
                }else if(comA.equals("top")){
                    System.out.println(stack.top());
                }
            }
        }
    }
}

class MyIntStack{
    private List<Integer> list;

    public MyIntStack() {
        this.list = new ArrayList<>();
    }

    public void push(int value){
        list.add(value);
    }

    public int pop(){
        return list.size() == 0 ? -1 : list.remove(list.size() - 1);
    }

    public int size(){
        return list.size();
    }

    public int empty(){
        return list.size() == 0 ? 1 : 0;
    }

    public int top(){
        return list.size() == 0 ? -1 : list.get(list.size() - 1);
    }
}