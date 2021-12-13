package algo_study.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

enum Direction{
    LEFT, RIGHT;
}

public class Main20436 {
    static char sl, sr;
    static String str;
    static char[][] board = new char[][]{
            {'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'},
            {'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'},
            {'z', 'x', 'c', 'v', 'b', 'n', 'm'}
    };
    static char[] left = {'q', 'w', 'e', 'r', 't', 'a', 's', 'd', 'f', 'g', 'z', 'x', 'c', 'v'};
    static char[] right = {'y', 'u', 'i', 'o', 'p', 'h', 'j', 'k', 'l', 'b', 'n', 'm'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        sl = st.nextToken().charAt(0);
        sr = st.nextToken().charAt(0);

        str = br.readLine();

        System.out.println(countTime());

    }
    static int countTime(){
        int[] startLeft = new int[2];
        int[] startRight = new int[2];

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == sl) startLeft = new int[]{i, j};
                if(board[i][j] == sr) startRight = new int[]{i, j};
            }
        }

        int time = 0;

        for(int i = 0; i < str.length(); i++){
            char targetChar = str.charAt(i);
            if (isContain(Direction.LEFT, targetChar)) {
                //왼쪽이면
                int[] coordinate = getCoordinate(targetChar);
                time += (Math.abs(startLeft[0] - coordinate[0]) + Math.abs(startLeft[1] - coordinate[1]));
                startLeft = coordinate; // 왼손 검지 좌표 최신화

            }else if(isContain(Direction.RIGHT, targetChar)){
                //오른쪽이면
                int[] coordinate = getCoordinate(targetChar);
                time += (Math.abs(startRight[0] - coordinate[0]) + Math.abs(startRight[1] - coordinate[1]));
                startRight = coordinate; // 왼손 검지 좌표 최신화
            }
            time++;//키 누르는 시간 추가
        }

        return time;
    }
    static boolean isContain(Enum direction, char targetChar){
        if(direction == Direction.LEFT){
            for(int i = 0; i < left.length; i++){
                if(left[i] == targetChar) return true;
            }
        }else{
            for(int i = 0; i < right.length; i++){
                if(right[i] == targetChar) return true;
            }
        }
        return false;
    }

    static int[] getCoordinate(char targetChar){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == targetChar) return new int[]{i, j};
            }
        }

        //여기까지 올수없음
        return null;
    }
}

/**
 * 간단한 구현문제
 *
 * 키보드를 2차원 배열로 구현하자.
 * 왼손검지가 도달할수 있는 알파벳 소문자 배열, 오른손 검지가 도달할수 있는 알파벳 소문자 배열을 저장하자.
 *
 * 최소 시간을 구하라했는데 택시시간 자체가 최소시간임.
 */