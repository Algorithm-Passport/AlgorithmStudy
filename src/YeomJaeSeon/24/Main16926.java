package algo_study.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main16926 {
    static int N, M, R;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        board = new int[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int min = Math.min(N, M); //min은 무조건 짝수
        min /= 2; //min / 2만큼의 껍질이 있음

        rotate(min);
    }
    static void rotate(int skinCount){
        int n = N;
        int m = M;

        int x = 0;
        int y = 0;
        List<int[]> list = new ArrayList<>();

        // list에 line을 만들어서 담기
        for(int i = 0; i < skinCount; i++){
            int size = n * m - (n - 2) * (m - 2);
            int[] line = new int[size];
            // 아래 방향
            int idx = 0;
            for(int j = 0; j < n; j++){
                line[idx++] = board[x + j][y];
            }
            //오른쪽
            for(int j = 1; j < m; j++){
                line[idx++] = board[x + n - 1][y + j];
            }
            //위로
            for(int j = 1; j < n; j++){
                line[idx++] = board[x + n - 1 - j][y + m - 1];
            }

            //왼쪽으로
            for(int j = 1; j < m - 1; j++){
                line[idx++] = board[x][y + m - 1 - j];
            }

            x++;
            y++;
            n -= 2;
            m -= 2;

            list.add(line);
        }

        List<int[]> list2 = new ArrayList<>();

        // R만큼 이동시키기
        for (int[] arr : list) {
            int r = R % arr.length;
            int[] result = new int[arr.length];

            for(int i = 0; i < arr.length; i++){
                //R만큼 움직여야함
                if(r + i >= arr.length){
                    //범위 벗어나면
                    result[(r + i) - arr.length] = arr[i];
                }else{
                    result[r + i] = arr[i];
                }
            }

            list2.add(result);
        }

        n = N;
        m = M;

        x = 0;
        y = 0;

        // board에 담기
        for (int[] arr : list2) {
            int idx = 0;
            // 아래 방향
            for(int j = 0; j < n; j++){
                board[x + j][y] = arr[idx++];
            }
            //오른쪽
            for(int j = 1; j < m; j++){
                board[x + n - 1][y + j] = arr[idx++];
            }
            //위로
            for(int j = 1; j < n; j++){
                board[x + n - 1 - j][y + m - 1] = arr[idx++];
            }

            //왼쪽으로
            for(int j = 1; j < m - 1; j++){
                board[x][y + m - 1 - j] = arr[idx++];
            }

            x++;
            y++;
            n -= 2;
            m -= 2;
        }
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

    }
}
/**
 * 구현 문제
 * 맨왼쪽 위 : x, y
 * 맨왼쪽 아래 : x + n - 1, y
 * 맨오른쪽 아래 : x + n - 1, y + m - 1
 * 맨 오른쪾 위 : x, y + m - 1
 *
 * 껍질 하나당 x 와 y는 ++해주고
 * n, m은 2씩 빼줘야한다.
 *
 * 위의 좌표를 기준으로
 * 1) board -> 껍질을 1차원 배열로 변경
 * 2) R만큼 이동 (이때 결과를 담을 배열 껍질수만큼 추가)
 * 3) 이동시킨 결과인 1차원 배열을 board에 다시 담기
 *
 * 풀면서 집중안되고, 딴생각도 많이나고
 * index에러도 많이났다.
 *
 * 귀찮은 구현문제
 */
