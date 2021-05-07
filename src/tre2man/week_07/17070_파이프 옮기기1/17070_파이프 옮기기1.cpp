#include <iostream>
#include <cstring>
using namespace std;

/*
dfs 풀이법
맵의 크기가 가로세로 16으로 제한되어 있어서 dfs를 이용해서 풀이해 보았다.
dfs 안의 판별식은 현재 상태를 판별하며, dir 변수는 이전 파이프의 방향을 나타낸다.
*/

int N, ans;
int map[16][16];

// 0 : 우측, 1 : 하단, 2 : 대각선
void dfs(int x, int y, int dir)
{
    if (x >= 0 && y >= 0 && x < N && y < N)
    {
        //현재 상태가 성립될수 없다면 재귀호출을 하지않는다.
        if (dir == 2 && (map[x][y] == 1 || map[x - 1][y] == 1 || map[x][y - 1] == 1))
            return;
        if ((dir == 1 || dir == 0) && map[x][y] == 1)
            return;
        if (x == N - 1 && y == N - 1)
        {
            ans++;
            return;
        }

        //다음 지점을 탐색하자
        if (dir == 0)
        {
            dfs(x, y + 1, 0);
            dfs(x + 1, y + 1, 2);
        }
        else if (dir == 1)
        {
            dfs(x + 1, y, 1);
            dfs(x + 1, y + 1, 2);
        }
        else if (dir == 2)
        {
            dfs(x, y + 1, 0);
            dfs(x + 1, y, 1);
            dfs(x + 1, y + 1, 2);
        }
    }
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(NULL);
    cout.tie(NULL);

    ans = 0;
    memset(map, 0, sizeof(map));
    cin >> N;
    for (int i = 0; i < N; i++)
        for (int j = 0; j < N; j++)
            cin >> map[i][j];
    // 시작위치는 0,1로 고정되어있음.
    dfs(0, 1, 0);
    cout << ans;
}